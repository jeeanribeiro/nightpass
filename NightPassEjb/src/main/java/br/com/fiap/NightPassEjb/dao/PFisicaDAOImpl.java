package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Stateless;
import br.com.fiap.NightPassEjb.Entity.PessoaFisica;

@Stateless
public class PFisicaDAOImpl extends GenericDAOImpl<PessoaFisica, Integer> implements PFisicaDAO {

	public PFisicaDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<PessoaFisica> listarPorNome(){
		
		return em.createQuery("from PessoaFisica f Order by nome", PessoaFisica.class)
				.getResultList();
		
	}
	
	

}
