package br.com.fiap.NightPassSpr.Entity;

public class PessoaAgenda {

	public PessoaAgenda() {
		super();
	}
	
	public Agenda agenda;
	
	public Presenca presenca;

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Presenca getPresenca() {
		return presenca;
	}

	public void setPresenca(Presenca presenca) {
		this.presenca = presenca;
	}
	

}
