package br.com.fiap.NightPassSpr.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Controller
@RequestMapping("/cadastrousuario")
public class CadastroUsuarioController {

	@Autowired
	private PFisicaDAO dao;

	@Autowired
	private HttpSession session;

	@GetMapping()
	public String abrircadastroUsuario (@RequestParam(required=false) PessoaFisica NovoUsuario,
			Model model) {

		session.invalidate();

		model.addAttribute("NovoUsuario", new PessoaFisica());
		model.addAttribute("action", "cadastrousuario");
		model.addAttribute("btnNome", "Cadastrar");

		return "base/CadastroUsuario";
	}

	@Transactional
	@PostMapping()
	public String cadastrarNovoUsuario(@Valid PessoaFisica NovoUsuario, BindingResult bindingResult,
			RedirectAttributes RAttr, Model model) {

			NovoUsuario.setTipoUsuario("CONSUMIDOR");

			RAttr.addFlashAttribute("msg","Usuário Cadastrado com sucesso");

			//codigo para gravar novo usuário

			dao.cadastrar(NovoUsuario);

			return "redirect:cadastrousuario";
	}


	@Transactional
	@PostMapping("alterarUsuario")
	public String alterarUsuario(@Valid PessoaFisica alteraUsuario, BindingResult bindingResult,
			RedirectAttributes RAttr, Model model) {
			//codigo para atualizar o usuario

			PessoaFisica usuarioLog = (PessoaFisica) session.getAttribute("usuarioLog");

			alteraUsuario.setCodigo(usuarioLog.getCodigo());
			alteraUsuario.setTipoUsuario(usuarioLog.getTipoUsuario());
			alteraUsuario.setpJuridicas((usuarioLog.getpJuridicas()));

			dao.atualizar(alteraUsuario);

			RAttr.addFlashAttribute("msg","Cadastrado alterado com sucesso");

			return "redirect:/cadastrousuario/dadosConta";
	}

	@GetMapping("dadosConta")
	public String dadosConta (@RequestParam(required=false) PessoaFisica NovoUsuario,
			Model model) {

		model.addAttribute("NovoUsuario", new PessoaFisica());
		model.addAttribute("action", "/cadastrousuario/alterarUsuario");
		model.addAttribute("btnNome", "Alterar");

		return "base/CadastroUsuario";
	}

}
