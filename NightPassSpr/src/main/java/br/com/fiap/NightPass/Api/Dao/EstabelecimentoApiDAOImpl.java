package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.NightPassSpr.Entity.Estabelecimento;


public class EstabelecimentoApiDAOImpl extends
GenericApiDAOImpl<Estabelecimento, Long>
implements EstabelecimentoApiDAO {

/**
 * @param em EntityManager
 */
public EstabelecimentoApiDAOImpl(final EntityManager em) {
super(em);
}

/**
 * @return Estabelecimento
 */
public List<Estabelecimento> listarPorNome() {
return em.createQuery("from Estabelecimento"
+ " e Order by est_codigo", Estabelecimento.class)
.getResultList();
}

}
