package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.NightPassEjb.Entity.Estabelecimento;

@Remote
public interface EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer> {

	
	public List<Estabelecimento> listarPorNome();
	
	
	
}
