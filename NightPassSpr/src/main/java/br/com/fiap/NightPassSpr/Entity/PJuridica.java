package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="T_PJURIDICA")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "psjCodigo")
public class PJuridica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_PJuridica", sequenceName="Seq_T_PJuridica", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_T_PJuridica")
	@Column(name="PSJ_CODIGO", nullable=false)
	private long psjCodigo;
	
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

//	@OneToMany(mappedBy = "pJuridica")
//	private List<PFGestor> pfGestor;
	
	@ManyToMany(mappedBy="pJuridicas", fetch=FetchType.EAGER) @Fetch(value=FetchMode.SUBSELECT)
	private List<PessoaFisica> pessoaFisicas;

	@JsonManagedReference(value="estabelecimento")
	@OneToOne(mappedBy = "PSJ_CODIGO")
	private Estabelecimento estabelecimento;
	
	public PJuridica() {
		super();
	}

	public long getPsjCodigo() {
		return psjCodigo;
	}

	public void setPsjCodigo(long psjCodigo) {
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

	@JsonBackReference(value="pessoaFisicas")
	//Inibe a Exibiçãoé necessária para impedir o loop infinito

	public List<PessoaFisica> getPessoaFisicas() {
		return pessoaFisicas;
	}

	public void setPessoaFisicas(List<PessoaFisica> pessoaFisica) {
		this.pessoaFisicas = pessoaFisica;
	}

}
