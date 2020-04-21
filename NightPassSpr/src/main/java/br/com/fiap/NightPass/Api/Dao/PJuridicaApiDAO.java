package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.PJuridica;

public interface PJuridicaApiDAO extends GenericApiDAO<PJuridica, Long> {
  public List<PJuridica> listarPorNome();
  public PJuridica cadastrarR (PJuridica pjuridica);
}
