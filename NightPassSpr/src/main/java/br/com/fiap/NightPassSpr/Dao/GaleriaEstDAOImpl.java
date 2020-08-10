package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;

@Repository
public class GaleriaEstDAOImpl extends GenericDAOImpl<GaleriaEst, Long>
		implements GaleriaEstDAO {

	public GaleriaEstDAOImpl() {
		super();
	}

	public List<GaleriaEst> listarPorTipo(Estabelecimento defEestabelecimento,
			TipoGaleria tipoGaleria) {

		try {
			return em.createQuery("from GaleriaEst e where e.gae_est_codigo= "
					+ defEestabelecimento.getEstcodigo() + "and " +
					"e.gae_tga_codigo = " + tipoGaleria.getTgacodigo(), GaleriaEst.class)
					.getResultList();
		} catch (NoResultException expected) {
			return null;
		}

	}

}
