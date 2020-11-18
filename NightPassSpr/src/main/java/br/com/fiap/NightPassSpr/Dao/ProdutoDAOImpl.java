package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Agenda;
import br.com.fiap.NightPassSpr.Entity.Produto;

@Repository
public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Long> implements
		ProdutoDAO{

	public ProdutoDAOImpl() {
		super();
	}

	public List<Produto> listarProdutoEst(long EstCodigo){
		return em.createQuery("from Produto Where T_Estabeleci_Est_Codigo = " + EstCodigo
				+ "Order by age_data", Produto.class)
				.getResultList();
	}

}
