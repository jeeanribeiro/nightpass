package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Stateless;
import br.com.fiap.NightPassEjb.Entity.Estabelecimento;

@Stateless
public class EstabelecimentoDAOImpl extends GenericDAOImpl<Estabelecimento, Integer> 
			implements EstabelecimentoDAO {

	public EstabelecimentoDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Estabelecimento> listarPorNome(){
		
		return em.createQuery("from Estabelecimento e Order by est_codigo", Estabelecimento.class)
				.getResultList();
		
	}

	
}
