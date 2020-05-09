package br.com.fiap.NightPassSpr.Dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Agenda;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;
import br.com.fiap.NightPassSpr.Entity.Presenca;

@Repository
public class PresencaDAOImpl extends GenericDAOImpl<Presenca, Long> implements
		PresencaDAO{

	public PresencaDAOImpl(){
		super();
	}

	public Presenca ListarporPessoaAgenda(Agenda agendaDef, PessoaFisica pessoaDef) {

		try {
		return em.createQuery("from Presenca Where T_AGENDA_AGE_CODIGO = " + agendaDef.getAgeCodigo() +
				"And T_PFISICA_PSA_CODIGO = " + pessoaDef.getCodigo(), Presenca.class)
				.getSingleResult();
		} catch (NoResultException expected) {
			return null;
		}

	}

}
