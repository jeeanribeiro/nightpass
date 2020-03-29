package br.com.fiap.NightPassSpr.Dao;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.TipoGaleria;

@Repository
public class TipoGaleriaDAOImpl extends GenericDAOImpl<TipoGaleria, Integer> implements
		TipoGaleriaDAO{

	public TipoGaleriaDAOImpl() {
		super();
	}

}
