package br.com.fiap.NightPassSpr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Controller
public class LoginUsuarioController {

	@Autowired
	private PFisicaDAO dao;

	PessoaFisica usuarioLog = new PessoaFisica();

	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String login(PessoaFisica pessoaFisica) {
		return "base/LoginUsuario";
	}

	@GetMapping("/signout")
	public String signout(PessoaFisica pessoaFisica) {
		session.invalidate();
		return "base/LoginUsuario";
	}


	@GetMapping("/acessaPainelPrincipal")
	public String acessaPainelPrincipal() {
		return "base/PainelPrincipal";
	}

	@Transactional
	@PostMapping("/logar")
	public ModelAndView login (PessoaFisica pessoaFisica,
			Model model, @RequestParam(required=false) boolean baseimagens) {

		usuarioLog = dao.buscarPorEmail(pessoaFisica.getEmail());

		session.setAttribute("baseimagens", baseimagens);
		System.out.println(baseimagens);

		if(usuarioLog == null) {
			model.addAttribute("msg", "Login não cadastrado");
			return new ModelAndView("base/LoginUsuario");
		}

		if (usuarioLog.ValidarSenha(pessoaFisica.getSenha()) == true) {
			//Senha Valida
			model.addAttribute("msg", "Usuario Autenticado");
			session.setAttribute("usuarioLog", usuarioLog);
			//Vai para o painel de controle
		} else {
			//Senha Inválida
			model.addAttribute("msg", "Senha Incorreta");
			return new ModelAndView("base/LoginUsuario");
		}
		//Procedimentos básicos de carregamento de páginas
		return new ModelAndView("redirect:/carregarListaEstabelecimentos");
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
