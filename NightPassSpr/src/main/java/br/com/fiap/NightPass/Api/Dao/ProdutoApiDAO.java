package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Produto;


public interface ProdutoApiDAO extends GenericApiDAO<Produto, Long> {
  public List<Produto> listarPorNome();
  public Produto cadastrarR (Produto produto);
  public List<Produto> listarPorEst(long EstCodigo);
}
