package lixo;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.GaleriaEstDAO;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;
import br.com.fiap.NightPassSpr.util.BlobUtil;

@Controller
public class GaleriaEstController_old {
	
	@Autowired
	GaleriaEstDAO galeriaEstDao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	EstabelecimentoDAO estabelecimentoDao;
	
	
	@Transactional
	@GetMapping("/abreGaleria_old")
	public String AbreGaleria() throws SQLException {
	
		List <GaleriaEst> galeriaEst;
		
		Estabelecimento estabelecimentoAtu = estabelecimentoDao.buscar(22L); 
		
		estabelecimentoAtu.getGaleriaEst();
		
		
		TipoGaleria tipoGaleria = new TipoGaleria();
		
		//Abre Foto da Fachada
		tipoGaleria.setTgacodigo(1);
		galeriaEst = galeriaEstDao.listarPorTipo(estabelecimentoAtu, tipoGaleria);
		
		//galeriaEst.get(0).setGaeFotoExibivel();
		
		session.setAttribute("Foto3", galeriaEst.get(0));

		//Abre Foto da area do Bar
		tipoGaleria.setTgacodigo(2);
		galeriaEst = galeriaEstDao.listarPorTipo(estabelecimentoAtu, tipoGaleria);
		
		galeriaEst.get(0).setGaeFotoExibivel();
		
		session.setAttribute("Foto4", galeriaEst.get(0));
		
		//session.setAttribute("Foto2", BlobUtil.BlobToString64(galeriaEst.get(0).getGaefoto()));
		
		//galeriaEst.get(0).setGaeFotoExibivel(BlobUtil.BlobToString64(galeriaEst.get(0).getGaefoto()));
		
		//session.setAttribute("roger", estabelecimentoAtu.getGaleriaEstporTipo(tipoGaleria));
		
		/*
		 * session.setAttribute("roger2", estabelecimentoAtu);
		 * 
		 * List <GaleriaEst> gal = estabelecimentoAtu.getGaleriaEst();
		 * 
		 * String Label = String.valueOf(estabelecimentoAtu.getEstcodigo());
		 * 
		 * session.setAttribute("teste" + Label, gal);
		 * 
		 * 
		 * Estabelecimento estabelecimentoAtu2 = estabelecimentoDao.buscar(45L);
		 * 
		 * List <GaleriaEst> gal2 = estabelecimentoAtu2.getGaleriaEst();
		 * 
		 * Label = String.valueOf(estabelecimentoAtu2.getEstcodigo());
		 * 
		 * session.setAttribute("teste" + Label, gal2);
		 * 
		 * 
		 * 
		 * 
		 * session.setAttribute("roger4", estabelecimentoAtu);
		 * 
		 * 
		 * gal.get(0).getGaeFotoExibivel();
		 * 
		 */		
		
		galeriaEst = galeriaEstDao.listar();
				
		List <Estabelecimento> lEstabelecimentos =  estabelecimentoDao.listar();
		
		session.setAttribute("estabelecimento", lEstabelecimentos);
		session.setAttribute("galeria", galeriaEst);
		
		galeriaEst.get(0).getGae_est_codigo().getEstcodigo();
		galeriaEst.get(0).getGae_tga_codigo().getTgacodigo();
		
		lEstabelecimentos.get(0).getEstcodigo();
		lEstabelecimentos.get(0).getGaleriaEst().get(0).getGae_est_codigo();
		
		
		return "base/PainelGaleriaEstabelecimento";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
