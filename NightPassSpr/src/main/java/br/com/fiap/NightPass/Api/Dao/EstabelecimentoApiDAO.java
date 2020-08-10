package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Estabelecimento;

public interface EstabelecimentoApiDAO extends
GenericApiDAO<Estabelecimento, Long> {

/**
@return listarPorNome() Retorna os estabelecimentos pelo nome
*/

List<Estabelecimento> listarPorNome();
}
