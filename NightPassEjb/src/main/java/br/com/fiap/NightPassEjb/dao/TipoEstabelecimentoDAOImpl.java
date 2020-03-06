package br.com.fiap.NightPassEjb.dao;

import javax.persistence.EntityManager;

import br.com.fiap.NightPassEjb.Entity.TipoEstabelecimento;

public class TipoEstabelecimentoDAOImpl extends GenericDAOImpl<TipoEstabelecimento, Integer>
implements TipoEstabelecimentoDAO {

	public TipoEstabelecimentoDAOImpl(EntityManager em) {
		super();
	}
	
}
