package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Produto;


public interface ProdutoDAO extends GenericDAO<Produto, Long> {

	public List<Produto> listarProdutoEst(long EstCodigo);

}
