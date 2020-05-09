package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="T_PRESENCA")
public class Presenca implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_PRESENCA", sequenceName="Seq_T_PRESENCA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "Seq_T_PRESENCA")
	@Column(name="PRE_CODIGO", nullable=false)
	private long preCodigo;
	
	
	@ManyToOne
	@JoinColumn(name="T_PFISICA_PSA_CODIGO", nullable=false)
	private PessoaFisica prePessoaFisica;
	
	@ManyToOne
	@JoinColumn(name="T_AGENDA_AGE_CODIGO", nullable=false)
	private Agenda preAgenda;

	@Column(name="PRE_STATUS", nullable=false)
	private String status;

	public long getPreCodigo() {
		return preCodigo;
	}

	public void setPreCodigo(long preCodigo) {
		this.preCodigo = preCodigo;
	}

	public PessoaFisica getPrePessoaFisica() {
		return prePessoaFisica;
	}

	public void setPrePessoaFisica(PessoaFisica prePessoaFisica) {
		this.prePessoaFisica = prePessoaFisica;
	}

	public Agenda getPreAgenda() {
		return preAgenda;
	}

	public void setPreAgenda(Agenda preAgenda) {
		this.preAgenda = preAgenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
