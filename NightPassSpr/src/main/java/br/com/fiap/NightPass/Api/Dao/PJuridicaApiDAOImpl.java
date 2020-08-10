package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.PJuridica;

@Repository
public class PJuridicaApiDAOImpl extends GenericApiDAOImpl<PJuridica, Long> implements PJuridicaApiDAO {

	public PJuridicaApiDAOImpl(EntityManager em) {
		super(em);
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
