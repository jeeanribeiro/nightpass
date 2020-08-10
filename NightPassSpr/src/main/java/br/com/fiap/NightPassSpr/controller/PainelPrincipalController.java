package br.com.fiap.NightPassSpr.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaEstDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;

@Transactional
@Controller
public class PainelPrincipalController {

	@Autowired
	private  EstabelecimentoDAO estabelecimentoDao;

	@Autowired
	GaleriaEstDAO galeriaEstDao;

	@GetMapping("/carregarListaEstabelecimentos")
	public String carregarListaEstabelecimentos(Model model) throws SQLException {

		List <Estabelecimento> lEstabelecimentos =  estabelecimentoDao.listar();
			Collections.sort(lEstabelecimentos);

			model.addAttribute("estabelecimentos", lEstabelecimentos);

			//Carrega as Fotos de Fachada dos Estabelecimentos
			List <GaleriaEst> galeriaEst;
			galeriaEst = galeriaEstDao.listar();

			model.addAttribute("galeria", galeriaEst);

			//Novo Teste
			for (Estabelecimento estabelecimento : lEstabelecimentos) {
				model.addAttribute(String.valueOf((estabelecimento.getEstcodigo())),
						estabelecimento.getGaleriaEst());
			}

		return ("base/PainelPrincipal");
	}

}
