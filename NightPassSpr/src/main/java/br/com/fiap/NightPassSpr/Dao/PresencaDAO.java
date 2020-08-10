package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Agenda;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;
import br.com.fiap.NightPassSpr.Entity.Presenca;

public interface PresencaDAO extends GenericDAO<Presenca, Long> {

	public Presenca ListarporPessoaAgenda(Agenda agendaDef, PessoaFisica pessoaDef);

}
