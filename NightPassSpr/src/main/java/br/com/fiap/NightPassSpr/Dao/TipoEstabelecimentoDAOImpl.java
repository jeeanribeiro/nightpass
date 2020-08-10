package br.com.fiap.NightPassSpr.Dao;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.TipoEstabelecimento;

@Repository
public class TipoEstabelecimentoDAOImpl extends GenericDAOImpl<TipoEstabelecimento, Long>
implements TipoEstabelecimentoDAO {

	public TipoEstabelecimentoDAOImpl() {
		super();
	}

}
