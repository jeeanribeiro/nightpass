package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Agenda;
import br.com.fiap.NightPassSpr.Entity.GaleriaProduto;
import br.com.fiap.NightPassSpr.Entity.Produto;

@Repository
public class GaleriaProdutoDAOImpl extends GenericDAOImpl<GaleriaProduto, Long> implements
		GaleriaProdutoDAO{

	public GaleriaProdutoDAOImpl() {
		super();
	}

	public List<GaleriaProduto> listarGaleriaProduto(long GaleriaProdCod){
		return em.createQuery("from GaleriaProduto Where T_Produto_prd_codigo = " + GaleriaProdCod
				+ "Order by gap_codigo", GaleriaProduto.class)
				.getResultList();
	}

}
