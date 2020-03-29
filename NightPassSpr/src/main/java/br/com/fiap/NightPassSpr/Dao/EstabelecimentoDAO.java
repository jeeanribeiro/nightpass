package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Estabelecimento;

public interface EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer> {
	public List<Estabelecimento> listarPorNome();
}
