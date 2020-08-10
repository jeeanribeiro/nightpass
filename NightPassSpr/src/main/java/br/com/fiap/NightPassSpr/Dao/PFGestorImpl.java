package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.PFGestor;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Repository
public class PFGestorImpl extends GenericDAOImpl<PFGestor, Long>
				implements PFGestorDAO{

	public PFGestorImpl() {
		super();
	}

	public List<PFGestor> listarPorGestorPJ(PJuridica pjuridica, PessoaFisica pfisica){
		return em.createQuery("from PFGestor p Where "
				+ "p.psjcodigo = " + pjuridica.getPsjCodigo() + " And " +
				"p.psacodigo = " + pfisica.getCodigo(), PFGestor.class).getResultList();
	}

}
