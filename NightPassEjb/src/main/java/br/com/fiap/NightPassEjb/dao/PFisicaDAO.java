package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;

@Remote
public interface PFisicaDAO extends GenericDAO<PessoaFisica, Integer>{
	
	public List<PessoaFisica> listarPorNome();

}
