package br.com.fiap.NightPassSpr.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.smartcardio.ATR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaEstDAO;
import br.com.fiap.NightPassSpr.Dao.TipoGaleriaDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;
import br.com.fiap.NightPassSpr.util.BlobUtil;

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
			Model model, @RequestParam("uploadfoto") MultipartFile uploadfoto) throws IOException {
	
		//Preenche os campos que não veem diretamente do Form via Path
		
		try {
			galeriaEst.setGaefoto(uploadfoto.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		galeriaEst.setGae_est_codigo(estabelecimentoAtual);
		
		galeriaEst = galeriaEstDao.cadastrarRetEntity(galeriaEst);
				
		atualizaGaleria();
		
		
		/*
		 * // Salvando imagem no servidor
		 * 
		 * 
		 * String path =
		 * "E:/Projetos_GIT/nightpass/NightPassSpr/src/main/webapp/resources/ImgBase";
		 * 
		 * String filename = uploadfoto.getOriginalFilename();
		 * 
		 * BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(
		 * new File(path + File.separator + filename)));
		 * 
		 * stream.write(uploadfoto.getBytes()); stream.flush(); stream.close();
		 */		
				
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
