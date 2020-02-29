package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.NightPassEjb.Entity.PJuridica;


@Remote
public interface PJuridicaDAO extends GenericDAO<PJuridica, Integer>{


public List<PJuridica> listarPorNome();
	

public PJuridica cadastrarR (PJuridica pjuridica);

	
}
