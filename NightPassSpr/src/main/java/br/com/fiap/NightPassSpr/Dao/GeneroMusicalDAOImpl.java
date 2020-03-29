package br.com.fiap.NightPassSpr.Dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.GeneroMusical;

@Repository
public class GeneroMusicalDAOImpl extends GenericDAOImpl<GeneroMusical, Integer>
			implements GeneroMusicalDAO {

	public GeneroMusicalDAOImpl() {
		super();
	}

}
