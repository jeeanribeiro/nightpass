package br.com.fiap.NightPassEjb.Entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_GaleriaEst")
public class GaleriaEst implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sqTGaleriaEst",sequenceName="sq_T_GaleriaEst",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sqTGaleriaEst")
	@Column(name="gae_codigo", nullable = false)
	private Integer gaecodigo;
	
	@Column(name="gae_foto", nullable = false)
	private Blob gaefoto;
		
	@ManyToOne
	@JoinColumn(name="T_TipoGaleria_tga_codigo", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private TipoGaleria gae_tga_codigo;

	@ManyToOne
	@JoinColumn(name="T_Estabeleci_est_codigo", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Estabelecimento gae_est_codigo;
	
	public TipoGaleria getTga_codigo() {
		return gae_tga_codigo;
	}

	public void setTga_codigo(TipoGaleria tga_codigo) {
		this.gae_tga_codigo = tga_codigo;
	}

	public Estabelecimento getGae_est_codigo() {
		return gae_est_codigo;
	}

	public void setGae_est_codigo(Estabelecimento gae_est_codigo) {
		this.gae_est_codigo = gae_est_codigo;
	}

	public Blob getGaefoto() {
		return gaefoto;
	}

	public void setGaefoto(Blob gaefoto) {
		this.gaefoto = gaefoto;
	}

}
