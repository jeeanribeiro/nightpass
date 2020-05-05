package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Agenda;

public interface AgendaDAO extends GenericDAO<Agenda, Long> {
	
	public List<Agenda> listarAgendaEst(long EstCodigo);
	
}
