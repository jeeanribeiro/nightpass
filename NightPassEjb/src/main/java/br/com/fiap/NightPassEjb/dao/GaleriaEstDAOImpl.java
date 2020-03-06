package br.com.fiap.NightPassEjb.dao;

import javax.persistence.EntityManager;

import br.com.fiap.NightPassEjb.Entity.GaleriaEst;

public class GaleriaEstDAOImpl extends GenericDAOImpl<GaleriaEst, Integer> 
		implements GaleriaEstDAO {

	public GaleriaEstDAOImpl(EntityManager em) {
		super();
	}

}
