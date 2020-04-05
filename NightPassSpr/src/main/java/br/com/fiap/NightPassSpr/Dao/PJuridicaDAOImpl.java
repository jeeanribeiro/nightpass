package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.PJuridica;

@Repository
public class PJuridicaDAOImpl extends GenericDAOImpl<PJuridica, Long> implements PJuridicaDAO {

	public PJuridicaDAOImpl() {
		super();
	}
		
	public List<PJuridica> listarPorNome(){
		return em.createQuery("from PJuridica p Order by psjNome", PJuridica.class)
				.getResultList();
	}
	
	public PJuridica cadastrarR (PJuridica pjuridica) {
		em.persist(pjuridica);
		return pjuridica;
	}
	
}
