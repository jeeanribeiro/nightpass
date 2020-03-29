package br.com.fiap.NightPassSpr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Controller
public class PainelEstabelecimentoController {

	
	@Autowired
	private PFisicaDAO dao;
	
	@Autowired
	private HttpSession session;

	@Transactional
	@PostMapping("/estab") 
	public ModelAndView estab (PessoaFisica pessoaFisica,
			Model model) {

		return null;
		
		
	}
	
	
	
	
}
