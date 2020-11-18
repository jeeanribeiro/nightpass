package br.com.fiap.NightPassSpr.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaEstDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaProdutoDAO;
import br.com.fiap.NightPassSpr.Dao.ProdutoDAO;
import br.com.fiap.NightPassSpr.Dao.TipoGaleriaDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.GaleriaProduto;
import br.com.fiap.NightPassSpr.Entity.GeneroMusical;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.Produto;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;

@Controller
public class ManutencaoCardapio {

	
	@Autowired
	GaleriaEstDAO galeriaEstDao;
	
	@Autowired
	GaleriaProdutoDAO galeriaprodutoDAO;
	
	@Autowired
	ProdutoDAO produtoDAO;

	@Autowired
	TipoGaleriaDAO tipoGaleriaDao;

	@Autowired
	HttpSession session;

	@Autowired
	EstabelecimentoDAO estabelecimentoDao;

	HttpServletRequest request;

	List<TipoGaleria> tipoGaleria;

	Estabelecimento estabelecimentoAtual;
	List<Produto> produtoEstAtu;
	private PJuridica pJuridicaAtual;

	@Transactional
	@GetMapping("/abreCardapio")
	public String AbreCardapio(Model model, 
			@RequestParam(required=false) Produto produto) {
				
		pJuridicaAtual = (PJuridica) session.getAttribute("pJuridicaAtual");

		estabelecimentoDao.flush();
		
		estabelecimentoAtual = estabelecimentoDao.buscar(pJuridicaAtual.getEstabelecimento().getEstcodigo());

		session.setAttribute("estabelecimentoAtual", estabelecimentoAtual);

		produtoEstAtu = estabelecimentoAtual.getProdutoEst();

		model.addAttribute("produtoEstAtu", produtoEstAtu);
		model.addAttribute("produto", new Produto());
		
		
		return "base/ManutencaoCardapio";
	}

	@Transactional
	@PostMapping("/incluirproduto")
	public String Incluirproduto(Model model, 
			RedirectAttributes RAttr, Produto produto,
			@RequestParam("uploadfoto") MultipartFile uploadfoto) throws IOException {
				

		Produto produtocad = new Produto();
		
		produtocad = produto;
		
		estabelecimentoAtual = estabelecimentoDao.buscar(pJuridicaAtual.getEstabelecimento().getEstcodigo());
		
		produtocad.setEstabelecimentoPrd(estabelecimentoAtual);
		
		
 		// Salvando imagem no servidor
		//Obtem o caminho base do Servidor
		String path = session.getServletContext().getRealPath("/resources/ImgBase");

		//Obs: ao usar o eclipse é necessário definir o caminho manualmente,
		//pois o comando anterior é obtido um caminho temporário do eclipse que
		//e não reflete o caminho do servidor.

		//O caminho é obtido clicando com o botão direito na pasta "/resources/ImgBase"
		//propriedades/location

		//Após garregar a imagem dar um refresh no projeto para atualizar a imagem


		boolean baseimagens = (boolean) session.getAttribute("baseimagens");

			if(baseimagens == true) {

				path = "E:/Projetos_GIT/nightpass/NightPassSpr/src/main/webapp/resources/ImgBase";
				
			}

		String filename = uploadfoto.getOriginalFilename();

		//Cria um String aleatório para armazenar a imagem como indice da imagem
		//(obs.: Criar um processo para regeitar strings já gerados)

		String IdAleatorio;

		IdAleatorio = RandomStringUtils.randomAlphabetic(20);

		BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(
				new File(path + File.separator + IdAleatorio + "_" + filename)));

		stream.write(uploadfoto.getBytes()); stream.flush(); stream.close();

		//Grava o caminho do arquivo no banco de dados

		GaleriaProduto galeriaProd = new GaleriaProduto();
		
		galeriaProd.setGap_EndServidor("resources/ImgBase/" + IdAleatorio + "_" + filename);
		galeriaProd.setGap_produto_prd_codigo(produtocad);
		
		List<GaleriaProduto> galeriaprodutolist = new ArrayList<GaleriaProduto>();
		
		galeriaprodutolist.add(galeriaProd);
		
		produtocad.setGaleriaProduto(galeriaprodutolist);
		
		produtoDAO.cadastrar(produtocad);
		galeriaprodutoDAO.atualizar(galeriaProd);
		
	
		return "redirect:/abreCardapio";
	}


	
	
	
	@Transactional
	@PostMapping("/atualizaproduto/{prdCodigo}")
	public String AtualizaProduto (Produto produto,
			RedirectAttributes RAttr, Model model) {
		
		Produto produtoAtu;
		
		produtoAtu = produtoDAO.buscar(produto.getPrd_Codigo());
		
		produto.setEstabelecimentoPrd(produtoAtu.getEstabelecimentoPrd());
		produto.setGaleriaProduto(produtoAtu.getGaleriaProduto());
		
		produtoDAO.atualizar(produto);
				
		return "redirect:/abreCardapio";
	}

	
	@Transactional
	@GetMapping("/excluirproduto/{prdCodigo}")
	public String ExcluirProduto (@PathVariable("prdCodigo") long prdCodigo) {
		
		try {
			produtoDAO.remover(prdCodigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "redirect:/abreCardapio";
	}

	
	
	
	@Transactional
	@PostMapping("/grafafotoproduto/{prdCodigo}")
	
	public String GravaNovaFoto (@PathVariable("prdCodigo") long prdCodigo, 
			GaleriaProduto galeriaProd, RedirectAttributes RAttr,
			Model model, @RequestParam(name="gapCodigo", required=false) Long gapCodigo,
			@RequestParam("uploadfoto") MultipartFile uploadfoto
			) throws IOException {
		
		Produto produto = new Produto();
		
		produto = produtoDAO.buscar(prdCodigo);
		
		galeriaProd.setGap_produto_prd_codigo(produto);
		
 		// Salvando imagem no servidor
		//Obtem o caminho base do Servidor
		String path = session.getServletContext().getRealPath("/resources/ImgBase");

		//Obs: ao usar o eclipse é necessário definir o caminho manualmente,
		//pois o comando anterior é obtido um caminho temporário do eclipse que
		//e não reflete o caminho do servidor.

		//O caminho é obtido clicando com o botão direito na pasta "/resources/ImgBase"
		//propriedades/location

		//Após garregar a imagem dar um refresh no projeto para atualizar a imagem


		boolean baseimagens = (boolean) session.getAttribute("baseimagens");

			if(baseimagens == true) {

				path = "E:/Projetos_GIT/nightpass/NightPassSpr/src/main/webapp/resources/ImgBase";
				
			}

		String filename = uploadfoto.getOriginalFilename();

		//Cria um String aleatório para armazenar a imagem como indice da imagem
		//(obs.: Criar um processo para regeitar strings já gerados)

		String IdAleatorio;

		IdAleatorio = RandomStringUtils.randomAlphabetic(20);

		BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(
				new File(path + File.separator + IdAleatorio + "_" + filename)));

		stream.write(uploadfoto.getBytes()); stream.flush(); stream.close();

		//Grava o caminho do arquivo no banco de dados


		galeriaProd.setGap_EndServidor("resources/ImgBase/" + IdAleatorio + "_" + filename);

		
		//Atribui o código da Foto na galeria se existir, se não é criada uma nova foto
				
		if (gapCodigo != null) {
			
			galeriaProd.setGap_codigo(gapCodigo);
			
		}
		
		galeriaprodutoDAO.atualizar(galeriaProd);

		//atualizaGaleria();
	
		return "redirect:/abreCardapio";
	}


}
