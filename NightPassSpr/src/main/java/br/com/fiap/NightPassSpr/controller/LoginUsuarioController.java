package br.com.fiap.NightPassSpr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Controller
public class LoginUsuarioController {

	@Autowired
	private PFisicaDAO dao;
	
	
	@Autowired
	private HttpSession session;
		
	
	PessoaFisica usuarioLog = new PessoaFisica();
	
	
	@GetMapping("/")
	public String login(PessoaFisica pessoaFisica) {

		return "base/LoginUsuario";

	}

	@GetMapping("/acessaPainelPrincipal") 
	public String acessaPainelPrincipal() {

		return "base/PainelPrincipal";

	}
	
	
	@Transactional
	@PostMapping("/logar") 
	public ModelAndView login (PessoaFisica pessoaFisica,
			RedirectAttributes redirect) {
	
		System.out.println(pessoaFisica.getEmail());
		
		usuarioLog = dao.buscarPorEmail(pessoaFisica.getEmail());
		
		if (usuarioLog.ValidarSenha(pessoaFisica.getSenha()) == true) {
			
			//Senha Valida
			
			session.setAttribute("usuarioLog", usuarioLog);
			
			//Vai para o painel de controle
						
		}else {
			
			//Senha Inválida
			
			return new ModelAndView("base/LoginUsuario");
			
		}
		
		
	return new ModelAndView("redirect:/acessaPainelPrincipal");
	
	}

	/*
	 * @Transactional
	 * 
	 * @GetMapping("/") public String login(PessoaFisica pessoaFisica) {
	 * 
	 * return "base/LoginUsuario";
	 * 
	 * }
	 */	
	
	/*
	 * @GetMapping("cadastrar") //continuação com / para separar public String
	 * AbrirForm(PessoaFisica pessoaFisica) {
	 * 
	 * return "base/cadastro";
	 * 
	 * }
	 * 
	 * @GetMapping("logar") //continuação com / para separar public String
	 * LoginUsuario(PessoaFisica pessoaFisica) {
	 * 
	 * return "base/LoginUsuario";
	 * 
	 * }
	 * 
	 */
	
}
