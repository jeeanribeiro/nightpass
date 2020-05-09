package br.com.fiap.NightPassSpr.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaEstDAO;
import br.com.fiap.NightPassSpr.Dao.TipoGaleriaDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;

@Controller
public class GaleriaEstController {

	@Autowired
	GaleriaEstDAO galeriaEstDao;

	@Autowired
	TipoGaleriaDAO tipoGaleriaDao;

	@Autowired
	HttpSession session;

	@Autowired
	EstabelecimentoDAO estabelecimentoDao;

	HttpServletRequest request;

	List<TipoGaleria> tipoGaleria;

	Estabelecimento estabelecimentoAtual;
	List<GaleriaEst> galeriaEstAtu;
	private PJuridica pJuridicaAtual;

	@Transactional
	@GetMapping("/abreGaleria")
	public String AbreGaleria(Model model) {
		pJuridicaAtual = (PJuridica) session.getAttribute("pJuridicaAtual");

		estabelecimentoAtual = estabelecimentoDao.buscar(pJuridicaAtual.getEstabelecimento().getEstcodigo());

		session.setAttribute("estabelecimentoAtual", estabelecimentoAtual);

		galeriaEstAtu = estabelecimentoAtual.getGaleriaEst();

		model.addAttribute("galeriaEstAtu", galeriaEstAtu);

		return "base/PainelGaleriaEstabelecimento";
	}

	@GetMapping("/NovaFoto")
	public String NovaFoto (@RequestParam(required=false) GaleriaEst galeriaEst,
			RedirectAttributes RAttr, Model model) {

		//Garrega os tipos de Galeria
		tipoGaleria = tipoGaleriaDao.listar();

		model.addAttribute("tipoGaleria", tipoGaleria);
		model.addAttribute("galeriaEst", new GaleriaEst());

		return "base/NovaFotoEst";
	}

	@Transactional
	@PostMapping("/GravaNovaFoto")
	public String GravaNovaFoto (GaleriaEst galeriaEst, RedirectAttributes RAttr,
			Model model, @RequestParam("uploadfoto") MultipartFile uploadfoto
			) throws IOException {

		//Preenche os campos que não veem diretamente do Form via Path
		//procedimento para lançamento em campo Blob

//		try {
//			galeriaEst.setGaefoto(uploadfoto.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
		galeriaEst.setGae_est_codigo(estabelecimentoAtual);

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

		galeriaEst.setGae_EndServidor("resources/ImgBase/" + IdAleatorio + "_" + filename);

		galeriaEst = galeriaEstDao.cadastrarRetEntity(galeriaEst);

		atualizaGaleria();

		return "redirect:/abreGaleria";
	}

	@Transactional
	@GetMapping("/atualizaGaleria")
	public void atualizaGaleria() {
		pJuridicaAtual = (PJuridica) session.getAttribute("pJuridicaAtual");

		estabelecimentoAtual = estabelecimentoDao.buscar(pJuridicaAtual.getEstabelecimento().getEstcodigo());

		session.setAttribute("estabelecimentoAtual", estabelecimentoAtual);
	}

}
