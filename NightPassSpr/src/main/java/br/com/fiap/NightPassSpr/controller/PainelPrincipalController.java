package br.com.fiap.NightPassSpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;


@Controller
public class PainelPrincipalController {

	@Autowired
	private  EstabelecimentoDAO estabelecimentoDao;
	
	@GetMapping("/carregarListaEstabelecimentos")
	public String carregarListaEstabelecimentos(Model model) {
		
		List <Estabelecimento> lEstabelecimentos =  estabelecimentoDao.listar();
		
			model.addAttribute("lEstabelecimentos", lEstabelecimentos);
		
			//lEstabelecimentos.get(1).getEstDescricao()
			
		return ("base/PainelPrincipal");
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
