package br.com.fiap.NightPassEjb.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="T_PFGESTOR")
public class PFGestor implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="Seq_T_PFGestor", sequenceName="Seq_T_PFGestor", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_T_PFGestor")
	@Column(name="RGE_CODIGO", nullable=false)
	private int rgeCodigo;
	
	@Column(name="RGE_PERFIL", nullable=false, length=40)
	private String rgePerfil; 

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="T_PFISICA_PSA_CODIGO")
	private PessoaFisica pessoaFisica;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="T_PJURIDICA_PSJ_CODIGO")
	private PJuridica pJuridica;
	
	
	public PFGestor() {
		super();

	}

	public int getRgeCodigo() {
		return rgeCodigo;
	}

	public void setRgeCodigo(int rgeCodigo) {
		this.rgeCodigo = rgeCodigo;
	}

	public String getRgePerfil() {
		return rgePerfil;
	}

	public void setRgePerfil(String rgePerfil) {
		this.rgePerfil = rgePerfil;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PJuridica getpJuridica() {
		return pJuridica;
	}

	public void setpJuridica(PJuridica pJuridica) {
		this.pJuridica = pJuridica;
	}
	
	
	
	
	

}
