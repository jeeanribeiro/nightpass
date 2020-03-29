package br.com.fiap.NightPassSpr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Controller
public class PainelGestorPJController {
	
	
	@Autowired
	private PFisicaDAO dao;
	
	@Autowired
	private HttpSession session;
	
	PessoaFisica usuarioLog = new PessoaFisica();
	
	@Transactional
	@GetMapping("/buscarTodasPJGestor") 
	public String buscarTodasPJGestor (Model model) {
		
		//usuarioLog = (PessoaFisica) session.getAttribute("usuarioLog");
		
		return "base/PainelGestorPJ";
		
		
	}


	

}
