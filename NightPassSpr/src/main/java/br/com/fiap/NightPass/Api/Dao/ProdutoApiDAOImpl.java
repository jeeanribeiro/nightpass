package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Produto;


@Repository
public class ProdutoApiDAOImpl extends GenericApiDAOImpl<Produto, Long> implements ProdutoApiDAO {

	public ProdutoApiDAOImpl(EntityManager em) {
		super(em);
	}

	public List<Produto> listarPorNome(){
		return em.createQuery("from Produto p Order by prd_Codigo", Produto.class)
				.getResultList();
	}

	public List<Produto> listarPorEst(long EstCodigo){
		return em.createQuery("from Produto p "
				+ "where t_Estabeleci_est_codigo='" + EstCodigo + "' " + 
				"Order by prd_Codigo" , Produto.class)
				.getResultList();
	}
	
	public Produto cadastrarR (Produto produto) {
		em.persist(produto);
		return produto;
	}

}
