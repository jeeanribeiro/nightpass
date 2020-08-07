package br.com.fiap.NightPassSpr.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaEstDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;

@Transactional
@Controller
public class CatalogoEstController {

	
	@GetMapping("/")
	public String abrirHome(Model model) {
		
		AtuListaEstabelecimentos(model);
		
		return "base/CatalogoEst";
	}
	

	@Autowired
	private  EstabelecimentoDAO estabelecimentoDao;

	@Autowired
	GaleriaEstDAO galeriaEstDao;

	@GetMapping("/AtuListaEstabelecimentos")
	public void AtuListaEstabelecimentos(Model model){

		List <Estabelecimento> lEstabelecimentos =  estabelecimentoDao.listar();
			Collections.sort(lEstabelecimentos);

			model.addAttribute("estabelecimentos", lEstabelecimentos);
	
			//lEstabelecimentos.get(0).getGaleriaEst().get(0).getGae_EndServidor()
			//lEstabelecimentos.get(0).getGaleriaEst().get(0).getGae_tga_codigo().getTgacodigo()
			//lEstabelecimentos.get(0).getPSJ_CODIGO().getPsjNome()
			
			//lEstabelecimentos.get(0).getGeneroMusical().get(0).getNome()
			
			
			//Carrega as Fotos de Fachada dos Estabelecimentos
			List <GaleriaEst> galeriaEst;
			galeriaEst = galeriaEstDao.listar();

			model.addAttribute("galeria", galeriaEst);

			//Insere uma foto vazia se necessário
			for (Estabelecimento estabelecimento : lEstabelecimentos) {
				model.addAttribute(String.valueOf((estabelecimento.getEstcodigo())),
						estabelecimento.getGaleriaEst());
				
				if(estabelecimento.getGaleriaEst().isEmpty() != true) {
				
				System.out.println(estabelecimento.getGaleriaEst().get(0).getGae_EndServidor());
				}else{
					
					GaleriaEst ngaleriaEst = new GaleriaEst();
					
					ngaleriaEst.setGae_EndServidor("resources/imgs/EstabelecimentoSemFoto.jpg");
					
					estabelecimento.getGaleriaEst().add(ngaleriaEst);
				
				}
				
			}

	}
	
	
}
