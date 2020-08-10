package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Estabelecimento;

@Repository
public class EstabelecimentoDAOImpl extends GenericDAOImpl<Estabelecimento, Long>
			implements EstabelecimentoDAO {

	public EstabelecimentoDAOImpl() {
		super();
	}

	public List<Estabelecimento> listarPorNome() {
		return em.createQuery("from Estabelecimento e Order by est_codigo", Estabelecimento.class)
				.getResultList();
	}

}
