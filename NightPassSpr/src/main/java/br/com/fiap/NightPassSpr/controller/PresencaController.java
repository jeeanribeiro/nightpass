package br.com.fiap.NightPassSpr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.NightPassSpr.Dao.AgendaDAO;
import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.PresencaDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;
import br.com.fiap.NightPassSpr.Entity.Presenca;

@Controller
@RequestMapping("/presenca")
public class PresencaController {
	
	@Autowired
	private PresencaDAO presencaDao;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private EstabelecimentoDAO estabelecimentoDAO;
	
	PessoaFisica usuarioLog;
	
	@Transactional
	@PostMapping()
	public String alterarPresenca(Presenca Presenca, Model model,
			@RequestParam("Estcodigo") long Estcodigo){
		
		usuarioLog = (PessoaFisica) session.getAttribute("usuarioLog");
		
		Presenca.setPrePessoaFisica(usuarioLog);
			
		if (Presenca.getPrePessoaFisica().getCodigo() == usuarioLog.getCodigo()) {
			
			Presenca = presencaDao.atualizarRetEntity((Presenca));
			
			return "redirect:/agenda/" + Estcodigo;
			
		}else {
			
			return "/base/Error";
			
			
		}
		
		
	}
	
	

}
