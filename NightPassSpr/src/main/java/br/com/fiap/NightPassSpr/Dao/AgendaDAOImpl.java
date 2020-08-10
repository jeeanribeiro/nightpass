package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.Agenda;

@Repository
public class AgendaDAOImpl extends GenericDAOImpl<Agenda, Long> implements
		AgendaDAO{

	public AgendaDAOImpl() {
		super();
	}

	public List<Agenda> listarAgendaEst(long EstCodigo){
		return em.createQuery("from Agenda Where T_Estabeleci_Est_Codigo = " + EstCodigo
				+ "Order by age_data", Agenda.class)
				.getResultList();
	}

}
