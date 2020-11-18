package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T_PRODUTO")
public class Produto implements Serializable {

	public Produto() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_PRODUTO", sequenceName="Seq_T_PRODUTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "Seq_T_PRODUTO")
	@Column(name="PRD_CODIGO", nullable=false)
	private long prd_Codigo;

	@Column(name="PRD_NOME", nullable=true)
	private String prd_Nome;
	
	@Column(name="PRD_MARCA", nullable=true)
	private String prd_Marca;

	@Column(name="PRD_DESCRICAO", nullable=true)
	private String prd_Descricao;

	@Column(name="PRD_PRECO", nullable=true)
	private float prd_Preco;

	@Column(name="PRD_FORMATO", nullable=true)
	private String prd_Formato;
	
	@ManyToOne()
	@JoinColumn(name="T_ESTABELECI_EST_CODIGO", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Estabelecimento EstabelecimentoPrd;
	
	
	@OneToMany(mappedBy = "gap_produto_prd_codigo", fetch=FetchType.EAGER) @Fetch(value=FetchMode.SUBSELECT)
	@JsonManagedReference(value="galeriaProduto")
	private List<GaleriaProduto> galeriaProduto;

	public long getPrd_Codigo() {
		return prd_Codigo;
	}

	public void setPrd_Codigo(long prd_Codigo) {
		this.prd_Codigo = prd_Codigo;
	}

	public String getPrd_Nome() {
		return prd_Nome;
	}

	public void setPrd_Nome(String prd_Nome) {
		this.prd_Nome = prd_Nome;
	}

	public String getPrd_Marca() {
		return prd_Marca;
	}

	public void setPrd_Marca(String prd_Marca) {
		this.prd_Marca = prd_Marca;
	}

	public String getPrd_Descricao() {
		return prd_Descricao;
	}

	public void setPrd_Descricao(String prd_Descricao) {
		this.prd_Descricao = prd_Descricao;
	}

	public float getPrd_Preco() {
		return prd_Preco;
	}

	public void setPrd_Preco(float prd_Preco) {
		this.prd_Preco = prd_Preco;
	}

	public String getPrd_Formato() {
		return prd_Formato;
	}

	public void setPrd_Formato(String prd_Formato) {
		this.prd_Formato = prd_Formato;
	}

	public Estabelecimento getEstabelecimentoPrd() {
		return EstabelecimentoPrd;
	}

	public void setEstabelecimentoPrd(Estabelecimento estabelecimentoPrd) {
		EstabelecimentoPrd = estabelecimentoPrd;
	}

	public List<GaleriaProduto> getGaleriaProduto() {
		return galeriaProduto;
	}

	public void setGaleriaProduto(List<GaleriaProduto> galeriaProduto) {
		this.galeriaProduto = galeriaProduto;
	}

	
	
}
