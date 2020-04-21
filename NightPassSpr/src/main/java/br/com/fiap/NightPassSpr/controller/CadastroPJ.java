package br.com.fiap.NightPassSpr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.NightPassSpr.Dao.PFGestorDAO;
import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Dao.PJuridicaDAO;
import br.com.fiap.NightPassSpr.Entity.PFGestor;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;



@Controller
@RequestMapping("/cadastropj")
public class CadastroPJ {

	@Autowired
	PJuridicaDAO pJuridicaDao;
	
	@Autowired
	PFGestorDAO pfGestorDao;
	
	@Autowired
	PFisicaDAO pFisicaDao;
	
	@Autowired
	private HttpSession session;
	
	PessoaFisica usuarioLog = new PessoaFisica();
	
	
	
	@GetMapping()
	public String cadastroPJ(@Valid PJuridica pJuridicaNova, BindingResult bindingResult,
			RedirectAttributes RAttr, Model model){
		
		model.addAttribute("action", "cadastropj/cadastrarNovaPJ");
		
		return "base/CadastroPJ";
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@PostMapping("cadastrarNovaPJ") 
	public String cadastrarNovaPJ(@Valid PJuridica pJuridicaNova, BindingResult bindingResult,
			RedirectAttributes RAttr, Model model) {

			RAttr.addFlashAttribute("msg","Pessoa Jurídica cadastrada com sucesso");
			
			//codigo para gravar nova PJ
			
			usuarioLog = (PessoaFisica) session.getAttribute("usuarioLog");
			
			pJuridicaDao.cadastrar(pJuridicaNova);
			
			//associa a PJ juridica ao usuário atual como PROPRIETÁRIO
			
			PFGestor pfGestor = new PFGestor();
			
			pfGestor.setPsacodigo(usuarioLog.getCodigo());
			pfGestor.setPsjcodigo(pJuridicaNova.getPsjCodigo());
			pfGestor.setRgePerfil("PROPRIETARIO");
			
			model.addAttribute("msg", "Pessoa Jurídica Cadastrada com Sucesso");
			
			pfGestorDao.cadastrar(pfGestor);
			
			pfGestorDao.flush();
			
			return "base/CadastroPJ";
		
	}
	
}
