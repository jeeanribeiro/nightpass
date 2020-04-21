package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="T_PFisica")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codigo")
public class PessoaFisica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="pessoaFisica",sequenceName="sq_t_pfisica",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pessoaFisica")
	@Column(name="psa_codigo")
	private long codigo;
	
	@Column(name="psa_nome", nullable=false, length=40)
	private String nome;
	
	@Column(name="psa_sobrenome", nullable=false, length=100)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="psa_dtnascimento", nullable=false)
	private Calendar dataNasc;
	
	@Column(name="psa_RG", nullable=false, length=15)
	private String rg;
	
	@Column(name="psa_RGOrgaoEmissor", nullable=false, length=15)
	private String rgOrgaoEmissor;
	
	@Column(name="psa_RGEstadoEmissor", nullable=false, length=15)
	private String rgEstadoEmissor;
	
	@Column(name="psa_CPF", nullable=false, length=11)
	private long cpf;
	
	@Column(name="psa_Sexo", nullable=false, length=1)
	private String sexo;
	
	@Column(name="psa_cdProfissao")
	private Integer cdProfissao;
	
	@Column(name="psa_email", nullable=false, length=100)
	private String email;
	
	@Column(name="psa_senha", nullable=false, length=40)
	private String senha;
	
	@Column(name="psa_TelResidencial")
	private long telResidencial;
	
	@Column(name="psa_TelComercial")
	private long telComercial;
	
	@Column(name="psa_TelCelular", nullable=false, length=15)
	private long telCelular;
	
	@Column(name="psa_CepRes")
	private int cepRes;
	
	@Column(name="psa_EnderecoRes")
	private String enderecoRes;
	
	@Column(name="psa_NumeroRes")
	private Integer numeroRes;
	
	@Column(name="psa_ComplementoRes")
	private String complementoRes;
	
	@Column(name="psa_BairroRes")
	private String bairroRes;
	
	@Column(name="psa_CidadeRes")
	private String cidadeRes;
	
	@Column(name="psa_EstadoRes")
	private String estadoRes;
	
	@Column(name="psa_CepCom")
	private int cepCom;
	
	@Column(name="psa_EnderecoCom")
	private String enderecoCom;
	
	@Column(name="psa_numeroCom")
	private Integer numeroCom;
	
	@Column(name="psa_ComplementoCom")
	private String complementoCom;
	
	@Column(name="psa_BairroCom")
	private String bairroCom;
	
	@Column(name="psa_CidadeCom")
	private String cidadeCom;
	
	@Column(name="psa_EstadoCom")
	private String estadoCom;
	
	@Column(name="psa_tipousuario", nullable=false, length=20)
	private String tipoUsuario;

//	@OneToOne(cascade = {CascadeType.REFRESH}
//    , fetch = FetchType.EAGER)
//	@JoinColumn(name="T_PJURIDICA_PSJ_CODIGO")
//	private PJuridica PSJ_CODIGO;
	
//	@OneToMany(mappedBy = "pessoaFisica", fetch=FetchType.EAGER) @Fetch(value=FetchMode.SUBSELECT)
//	private List< PFGestor > pfGestor;
	
	@ManyToMany(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER) @Fetch(value=FetchMode.SUBSELECT)
	@JoinTable(joinColumns=@JoinColumn(name="T_PFISICA_PSA_CODIGO"),
	inverseJoinColumns = @JoinColumn(name="T_PJURIDICA_PSJ_CODIGO"),
	name="T_PFGESTOR")
	private List<PJuridica> pJuridicas;
	
	@Transient
	private boolean loginValidado = false;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(Integer codigo, String nome, String sobrenome, Calendar dataNasc, String rg,
			String rgOrgaoEmissor, String rgEstadoEmissor, long cpf, String sexo, Integer cdProfissao, String email,
			String senha, long telResidencial, long telComercial, long telCelular, int cepRes, String enderecoRes,
			Integer numeroRes, String complementoRes, String bairroRes, String cidadeRes, String estadoRes,
			int cepCom, String enderecoCom, Integer numeroCom, String complementoCom, String bairroCom,
			String cidadeCom, String estadoCom, String tipoUsuario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.rg = rg;
		this.rgOrgaoEmissor = rgOrgaoEmissor;
		this.rgEstadoEmissor = rgEstadoEmissor;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cdProfissao = cdProfissao;
		this.email = email;
		this.senha = senha;
		this.telResidencial = telResidencial;
		this.telComercial = telComercial;
		this.telCelular = telCelular;
		this.cepRes = cepRes;
		this.enderecoRes = enderecoRes;
		this.numeroRes = numeroRes;
		this.complementoRes = complementoRes;
		this.bairroRes = bairroRes;
		this.cidadeRes = cidadeRes;
		this.estadoRes = estadoRes;
		this.cepCom = cepCom;
		this.enderecoCom = enderecoCom;
		this.numeroCom = numeroCom;
		this.complementoCom = complementoCom;
		this.bairroCom = bairroCom;
		this.cidadeCom = cidadeCom;
		this.estadoCom = estadoCom;
		this.tipoUsuario = tipoUsuario;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	@JsonIgnore //Ignorado para impedir o erro de duplicidade de metodos set
	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc.setTime(dataNasc);
	}
	
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}

	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}

	public String getRgEstadoEmissor() {
		return rgEstadoEmissor;
	}

	public void setRgEstadoEmissor(String rgEstadoEmissor) {
		this.rgEstadoEmissor = rgEstadoEmissor;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getCdProfissao() {
		return cdProfissao;
	}

	public void setCdProfissao(Integer cdProfissao) {
		this.cdProfissao = cdProfissao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(long telResidencial) {
		this.telResidencial = telResidencial;
	}

	public long getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(long telComercial) {
		this.telComercial = telComercial;
	}

	public long getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(long telCelular) {
		this.telCelular = telCelular;
	}

	public int getCepRes() {
		return cepRes;
	}

	public void setCepRes(int cepRes) {
		this.cepRes = cepRes;
	}

	public String getEnderecoRes() {
		return enderecoRes;
	}

	public void setEnderecoRes(String enderecoRes) {
		this.enderecoRes = enderecoRes;
	}

	public Integer getNumeroRes() {
		return numeroRes;
	}

	public void setNumeroRes(Integer numeroRes) {
		this.numeroRes = numeroRes;
	}

	public String getComplementoRes() {
		return complementoRes;
	}

	public void setComplementoRes(String complementoRes) {
		this.complementoRes = complementoRes;
	}

	public String getBairroRes() {
		return bairroRes;
	}

	public void setBairroRes(String bairroRes) {
		this.bairroRes = bairroRes;
	}

	public String getCidadeRes() {
		return cidadeRes;
	}

	public void setCidadeRes(String cidadeRes) {
		this.cidadeRes = cidadeRes;
	}

	public String getEstadoRes() {
		return estadoRes;
	}

	public void setEstadoRes(String estadoRes) {
		this.estadoRes = estadoRes;
	}

	public int getCepCom() {
		return cepCom;
	}

	public void setCepCom(int cepCom) {
		this.cepCom = cepCom;
	}

	public String getEnderecoCom() {
		return enderecoCom;
	}

	public void setEnderecoCom(String enderecoCom) {
		this.enderecoCom = enderecoCom;
	}

	public Integer getNumeroCom() {
		return numeroCom;
	}

	public void setNumeroCom(Integer numeroCom) {
		this.numeroCom = numeroCom;
	}

	public String getComplementoCom() {
		return complementoCom;
	}

	public void setComplementoCom(String complementoCom) {
		this.complementoCom = complementoCom;
	}

	public String getBairroCom() {
		return bairroCom;
	}

	public void setBairroCom(String bairroCom) {
		this.bairroCom = bairroCom;
	}

	public String getCidadeCom() {
		return cidadeCom;
	}

	public void setCidadeCom(String cidadeCom) {
		this.cidadeCom = cidadeCom;
	}

	public String getEstadoCom() {
		return estadoCom;
	}

	public void setEstadoCom(String estadoCom) {
		this.estadoCom = estadoCom;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/*
	 * public PJuridica getPSJ_CODIGO() { return PSJ_CODIGO; }
	 * 
	 * public void setPSJ_CODIGO(PJuridica pSJ_CODIGO) { PSJ_CODIGO = pSJ_CODIGO; }
	 */
	public String getDtNascimentoFmt() {
		SimpleDateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
		return DtFormat.format(this.dataNasc.getTime());
	}
	
	public boolean ValidarSenha(String SenhaUsuario) {
		if (SenhaUsuario.equals(this.senha)) {
			this.loginValidado = true;
		} else {
			this.loginValidado = false;
		}
		return loginValidado;
	}

	public boolean isLoginValidado() {
		return loginValidado;
	}

	public List<PJuridica> getpJuridicas() {
		return pJuridicas;
	}

	public void setpJuridicas(List<PJuridica> pJuridica) {
		this.pJuridicas = pJuridica;
	}

	/*
	 * public List<PFGestor> getPfGestor() { return pfGestor; }
	 * 
	 * public void setPfGestor(List<PFGestor> pfGestor) { this.pfGestor = pfGestor;
	 * }
	 */	
	
	
	
}
