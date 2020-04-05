package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.PFGestor;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

public interface PFGestorDAO  extends GenericDAO<PFGestor, Long> { 
	
	public List<PFGestor> listarPorGestorPJ(PJuridica pjuridica, PessoaFisica pfisica);

}
