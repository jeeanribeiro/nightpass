package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="T_PFGESTOR")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rgeCodigo")
public class PFGestor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_PFGestor", sequenceName="Seq_T_PFGestor", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_T_PFGestor")
	@Column(name="RGE_CODIGO", nullable=false)
	private long rgeCodigo;

	@Column(name="RGE_PERFIL", nullable=false, length=40)
	private String rgePerfil;

	@JsonManagedReference
	@Column(name="T_PFISICA_PSA_CODIGO", nullable=false, length=40)
	private long psacodigo;

	@JsonManagedReference
	@Column(name="T_PJURIDICA_PSJ_CODIGO", nullable=false, length=40)
	private long psjcodigo;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="T_PFISICA_PSA_CODIGO", insertable = false, updatable = false)
	private PessoaFisica pessoaFisica;

	//@ManyToOne(cascade=CascadeType.REFRESH)
	//@JoinColumn(name="T_PJURIDICA_PSJ_CODIGO")
	//private PJuridica pJuridica;

	public PFGestor() {
		super();
	}

	public long getRgeCodigo() {
		return rgeCodigo;
	}

	public void setRgeCodigo(long rgeCodigo) {
		this.rgeCodigo = rgeCodigo;
	}

	public String getRgePerfil() {
		return rgePerfil;
	}

	public void setRgePerfil(String rgePerfil) {
		this.rgePerfil = rgePerfil;
	}
	
	public PessoaFisica getPessoaFisica() { return pessoaFisica; }
	 
	public void setPessoaFisica(PessoaFisica pessoaFisica) { this.pessoaFisica =
	pessoaFisica; }
	 
	/*
	 * public PJuridica getpJuridica() { return pJuridica; }
	 * 
	 * public void setpJuridica(PJuridica pJuridica) { this.pJuridica = pJuridica; }
	 */	 
	public long getPsacodigo() {
		return psacodigo;
	}

	public void setPsacodigo(long psacodigo) {
		this.psacodigo = psacodigo;
	}

	public long getPsjcodigo() {
		return psjcodigo;
	}

	public void setPsjcodigo(long psjcodigo) {
		this.psjcodigo = psjcodigo;
	}

}
