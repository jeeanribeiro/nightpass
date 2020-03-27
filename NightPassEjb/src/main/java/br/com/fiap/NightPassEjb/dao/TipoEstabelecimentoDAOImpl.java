package br.com.fiap.NightPassEjb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.com.fiap.NightPassEjb.Entity.TipoEstabelecimento;

@Stateless
public class TipoEstabelecimentoDAOImpl extends GenericDAOImpl<TipoEstabelecimento, Integer>
implements TipoEstabelecimentoDAO {

	public TipoEstabelecimentoDAOImpl() {
		super();
	}
	
}
