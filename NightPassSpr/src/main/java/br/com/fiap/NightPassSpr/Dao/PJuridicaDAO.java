package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.PJuridica;

public interface PJuridicaDAO extends GenericDAO<PJuridica, Long> {
	public List<PJuridica> listarPorNome();
	public PJuridica cadastrarR (PJuridica pjuridica);
}
