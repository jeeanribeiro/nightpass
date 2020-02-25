package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Stateless;
import br.com.fiap.NightPassEjb.Entity.PJuridica;


@Stateless
public class PJuridicaDAOImpl extends GenericDAOImpl<PJuridica, Integer> implements PJuridicaDAO {

	public PJuridicaDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<PJuridica> listarPorNome(){
		
		return em.createQuery("from PJuridica p Order by psjNome", PJuridica.class)
				.getResultList();
	
	}
	
	
	
}
