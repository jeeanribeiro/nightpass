package br.com.fiap.NightPassEjb.dao;

import javax.ejb.Remote;

import br.com.fiap.NightPassEjb.Entity.TipoEstabelecimento;

@Remote
public interface TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {}
