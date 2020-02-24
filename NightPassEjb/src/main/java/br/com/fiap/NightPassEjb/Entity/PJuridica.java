package br.com.fiap.NightPassEjb.Entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PJURIDICA")
public class PJuridica implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_PJuridica", sequenceName="Seq_T_PJuridica", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_T_PJuridica")
	@Column(name="PSJ_CODIGO", nullable=false)
	private int psjCodigo;
	
	@Column(name="PSJ_NOME", nullable=false, length=100)
	private String psjNome; 

	@Temporal(TemporalType.DATE)
	@Column(name="PSJ_DTFUNDACAO", nullable=true)
	private Calendar psjDtFundacao;

	@Column(name="PSJ_INSCESTADUAL", nullable=true, length=15)
	private String psjInscEstadual;

	@Column(name="PSJ_INSCESTADO", nullable=true, length=15)
	private String psjInscEstado;

	@Column(name="PSJ_CNPJ", nullable=false)
	private long psjCnpj;

	@Column(name="PSJ_EMAIL", nullable=false, length=100)
	private String psjEmail;

	@Column(name="PSJ_TELCOMERCIAL", nullable=false)
	private long psjTelComercial;

	@Column(name="PSJ_CEPCOM", nullable=false)
	private int psjCepCom;

	@Column(name="PSJ_ENDERECOCOM", nullable=false, length=60)
	private String psjEnderecoCom;

	@Column(name="PSJ_NUMEROCOM", nullable=false)
	private int psjNumeroCom;

	@Column(name="PSJ_COMPLEMENTOCOM", nullable=true, length=15)
	private String psjComplementoCom;

	@Column(name="PSJ_BAIRROCOM", nullable=false, length=30)
	private String psjBairroCom;

	@Column(name="PSJ_ESTADOCOM", nullable=false, length=30)
	private String psjEstadoCom;

	@Column(name="PSJ_CIDADECOM", nullable=false, length=30)
	private String psjCidadeCom;
	
	@Column(name="PSJ_APELIDO", nullable=true, length=30)
	private String psjApelido;
	
	@OneToOne(mappedBy = "PSJ_CODIGO")
	private Estabelecimento estabelecimento;
	
	public PJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPsjCodigo() {
		return psjCodigo;
	}

	public void setPsjCodigo(int psjCodigo) {
		this.psjCodigo = psjCodigo;
	}

	public String getPsjNome() {
		return psjNome;
	}

	public void setPsjNome(String psjNome) {
		this.psjNome = psjNome;
	}

	public Calendar getPsjDtFundacao() {
		return psjDtFundacao;
	}

	public void setPsjDtFundacao(Calendar psjDtFundacao) {
		this.psjDtFundacao = psjDtFundacao;
	}

	public String getPsjInscEstadual() {
		return psjInscEstadual;
	}

	public void setPsjInscEstadual(String psjInscEstadual) {
		this.psjInscEstadual = psjInscEstadual;
	}

	public String getPsjInscEstado() {
		return psjInscEstado;
	}

	public void setPsjInscEstado(String psjInscEstado) {
		this.psjInscEstado = psjInscEstado;
	}

	public long getPsjCnpj() {
		return psjCnpj;
	}

	public void setPsjCnpj(long psjCnpj) {
		this.psjCnpj = psjCnpj;
	}

	public String getPsjEmail() {
		return psjEmail;
	}

	public void setPsjEmail(String psjEmail) {
		this.psjEmail = psjEmail;
	}

	public long getPsjTelComercial() {
		return psjTelComercial;
	}

	public void setPsjTelComercial(long psjTelComercial) {
		this.psjTelComercial = psjTelComercial;
	}

	public int getPsjCepCom() {
		return psjCepCom;
	}

	public void setPsjCepCom(int psjCepCom) {
		this.psjCepCom = psjCepCom;
	}

	public String getPsjEnderecoCom() {
		return psjEnderecoCom;
	}

	public void setPsjEnderecoCom(String psjEnderecoCom) {
		this.psjEnderecoCom = psjEnderecoCom;
	}

	public int getPsjNumeroCom() {
		return psjNumeroCom;
	}

	public void setPsjNumeroCom(int psjNumeroCom) {
		this.psjNumeroCom = psjNumeroCom;
	}

	public String getPsjComplementoCom() {
		return psjComplementoCom;
	}

	public void setPsjComplementoCom(String psjComplementoCom) {
		this.psjComplementoCom = psjComplementoCom;
	}

	public String getPsjBairroCom() {
		return psjBairroCom;
	}

	public void setPsjBairroCom(String psjBairroCom) {
		this.psjBairroCom = psjBairroCom;
	}

	public String getPsjEstadoCom() {
		return psjEstadoCom;
	}

	public void setPsjEstadoCom(String psjEstadoCom) {
		this.psjEstadoCom = psjEstadoCom;
	}

	public String getPsjCidadeCom() {
		return psjCidadeCom;
	}

	public void setPsjCidadeCom(String psjCidadeCom) {
		this.psjCidadeCom = psjCidadeCom;
	}

	public String getPsjApelido() {
		return psjApelido;
	}

	public void setPsjApelido(String psjApelido) {
		this.psjApelido = psjApelido;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	
	
//	@Column(name="xxx", nullable=xxx, length=xxx)
//	private String xxx;
	
	
	
	
	
	

}
