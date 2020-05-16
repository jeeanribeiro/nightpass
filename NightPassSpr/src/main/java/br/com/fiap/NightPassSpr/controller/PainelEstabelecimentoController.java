package br.com.fiap.NightPassSpr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.PFGestorDAO;
import br.com.fiap.NightPassSpr.Dao.PJuridicaDAO;
import br.com.fiap.NightPassSpr.Dao.TipoEstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GeneroMusical;
import br.com.fiap.NightPassSpr.Entity.PFGestor;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;
import br.com.fiap.NightPassSpr.Entity.TipoEstabelecimento;

@Controller
@RequestMapping("/painelestabelecimento")
public class PainelEstabelecimentoController {

	@Autowired
	private EstabelecimentoDAO estabelecimentoDAO;

	@Autowired
	private PJuridicaDAO pjuridicaDao;

	@Autowired
	PFGestorDAO pfGestorDao;

	@Autowired
	private TipoEstabelecimentoDAO tipoEstabelecimentoDao;

	private PJuridica pJuridicaAtual;
	private PessoaFisica pFisicaAtual;

	List <TipoEstabelecimento> tpEstabelecimento;

	@Autowired
	private HttpSession session;

	@GetMapping(value = "/{pJuridicaSel}")
	public String abrircadastroEstabelecimento (@PathVariable("pJuridicaSel") long pJuridicaSel,
		@RequestParam(required=false) Estabelecimento estabelecimento, Model model) {

		//Carrega a PJ e PF e verifica se o usuário possui acesso
		pJuridicaAtual = pjuridicaDao.buscar(pJuridicaSel);

		pFisicaAtual = (PessoaFisica) session.getAttribute("usuarioLog");

		List <PFGestor> pfGestor = pfGestorDao.listarPorGestorPJ(pJuridicaAtual, pFisicaAtual);

		if (pfGestor.isEmpty() == true) {
			return "base/Error";
		}

		estabelecimento = pJuridicaAtual.getEstabelecimento();

		if (estabelecimento != null) {
			//Se o Estabelecimento existir carrega dos dados
			model.addAttribute("estabelecimento", estabelecimento);
		} else {
			//Se não existir cria um novo estabelecimento
			model.addAttribute("estabelecimento", estabelecimento = new Estabelecimento());
		}

		//adiciona a pessoa jurídica Atual a sessão do usuario
		session.setAttribute("pJuridicaAtual", pJuridicaAtual);

		//adiciona o Estabelecimento Atual a sessão do usuario
		session.setAttribute("estabelecimentoAtual", estabelecimento);

		//Carrega a Lista de Tipos de Estabelecimentos
		tpEstabelecimento = tipoEstabelecimentoDao.listar();

		//Recupera a lista de generos musicais vinculados ao Estabelecimento
		List <GeneroMusical> estabelecimentoGenMusical;
		estabelecimentoGenMusical = estabelecimento.getGeneroMusical();

//		model.addAttribute("estabelecimentoGenMusical", estabelecimentoGenMusical);
		session.setAttribute("estabelecimentoGenMusical", estabelecimentoGenMusical);

		model.addAttribute("tpEstabelecimento", tpEstabelecimento);

		return "base/PainelEstabelecimento";
	}


	@Transactional
	@PostMapping()
	public String atualizarEstabelecimento (Estabelecimento estabelecimento, Model model,
			RedirectAttributes redirectAttributes) {

		PJuridica pJuridicaAt = (PJuridica) session.getAttribute("pJuridicaAtual");

		List<GeneroMusical> pGeneroMusical = (List<GeneroMusical>) session.getAttribute("estabelecimentoGenMusical");

		estabelecimento.setPSJ_CODIGO(pJuridicaAt);
		estabelecimento.setGeneroMusical(pGeneroMusical);

		estabelecimentoDAO.atualizar(estabelecimento);

		redirectAttributes.addFlashAttribute("msg", "Estabelecimento atualizado!");

		return "redirect:/painelestabelecimento/" + pJuridicaAt.getPsjCodigo();
	}

}
