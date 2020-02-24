package br.com.fiap.NightPassEjb.Entity;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.sql.Clob;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_ESTABELECI")

public class Estabelecimento implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_Estabeleci", sequenceName="Seq_T_Estabeleci", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_T_Estabeleci")
	@Column(name="est_codigo", nullable=false)
	private long estcodigo;
	
	@Lob
	@Column(name="EST_DESCRICAO", nullable=false)
	private String estDescricao;
	
	//private Clob Est_Descricao;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EST_ABERTURA", nullable=false)
	private Calendar estAbertura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EST_FECHAMENTO", nullable=false)
	private Calendar estFechamento;
	
	@ManyToOne
	@JoinColumn(name="T_TIPOEST_TES_CODIGO", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private TipoEstabelecimento tes_codigo;

	@OneToMany(mappedBy = "gae_est_codigo")
	private List<GaleriaEst> galeriaEst;
	
	@OneToOne
	@JoinColumn(name="T_PJURIDICA_PSJ_CODIGO", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private PJuridica PSJ_CODIGO;

	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn(name="T_ESTABELECI_EST_CODIGO"),
	inverseJoinColumns = @JoinColumn(name="T_GENMUSICAL_GMU_CODIGO"),
	name="T_ESTGENMUSICAL")
	private List<GeneroMusical> generoMusical;
	
		
	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getEstcodigo() {
		return estcodigo;
	}


	public void setEstcodigo(long estcodigo) {
		this.estcodigo = estcodigo;
	}


	public String getEstDescricao() {
		return estDescricao;
	}


	public void setEstDescricao(String estDescricao) {
		this.estDescricao = estDescricao;
	}


	public Calendar getEstAbertura() {
		return estAbertura;
	}


	public void setEstAbertura(Calendar estAbertura) {
		this.estAbertura = estAbertura;
	}


	public Calendar getEstFechamento() {
		return estFechamento;
	}


	public void setEstFechamento(Calendar estFechamento) {
		this.estFechamento = estFechamento;
	}


	public TipoEstabelecimento getTes_codigo() {
		return tes_codigo;
	}


	public void setTes_codigo(TipoEstabelecimento tes_codigo) {
		this.tes_codigo = tes_codigo;
	}


	public List<GaleriaEst> getGaleriaEst() {
		return galeriaEst;
	}


	public void setGaleriaEst(List<GaleriaEst> galeriaEst) {
		this.galeriaEst = galeriaEst;
	}


	public PJuridica getPSJ_CODIGO() {
		return PSJ_CODIGO;
	}


	public void setPSJ_CODIGO(PJuridica pSJ_CODIGO) {
		PSJ_CODIGO = pSJ_CODIGO;
	}


	public List<GeneroMusical> getGeneroMusical() {
		return generoMusical;
	}


	public void setGeneroMusical(List<GeneroMusical> generoMusical) {
		this.generoMusical = generoMusical;
	}

	

	
}
