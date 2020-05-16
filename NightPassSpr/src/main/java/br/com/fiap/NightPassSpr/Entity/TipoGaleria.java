package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="T_TipoGaleria")
public class TipoGaleria implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_TipoGaleria", sequenceName="Seq_T_TipoGaleria", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Seq_T_TipoGaleria")
	@Column(name="tga_codigo", nullable=false)
	private long tgacodigo;

	@Column(name="tga_nome", nullable=false, length=25)
	private String tganome;
	
	@Column(name="tga_descricao", nullable=false, length=50)
	private String tga_descricao;
	
	@OneToMany(mappedBy = "gae_tga_codigo")
	@JsonManagedReference(value="gae_tga_codigo")
	private List<GaleriaEst> galeriaEst;

	
	public TipoGaleria() {
		super();
	}

	public long getTgacodigo() {
		return tgacodigo;
	}

	public void setTgacodigo(long tgacodigo) {
		this.tgacodigo = tgacodigo;
	}

	public String getTganome() {
		return tganome;
	}

	public void setTganome(String tganome) {
		this.tganome = tganome;
	}

	public String getTga_descricao() {
		return tga_descricao;
	}

	public void setTga_descricao(String tga_descricao) {
		this.tga_descricao = tga_descricao;
	}

	public List<GaleriaEst> getGaleriaEst() {
		return galeriaEst;
	}

	public void setGaleriaEst(List<GaleriaEst> galeriaEst) {
		this.galeriaEst = galeriaEst;
	}
	
}
