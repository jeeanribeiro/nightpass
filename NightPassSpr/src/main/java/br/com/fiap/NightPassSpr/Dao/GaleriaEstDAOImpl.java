package br.com.fiap.NightPassSpr.Dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.GaleriaEst;

@Repository
public class GaleriaEstDAOImpl extends GenericDAOImpl<GaleriaEst, Integer> 
		implements GaleriaEstDAO {

	public GaleriaEstDAOImpl() {
		super();
	}

}
