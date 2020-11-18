package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import javax.persistence.Basic;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.fiap.NightPassSpr.util.BlobUtil;

@Entity
@Table(name="T_GaleriaProduto")
@Transactional
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "gaecodigo")
public class GaleriaProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_GaleriaProduto",sequenceName="Seq_T_GaleriaProduto",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Seq_T_GaleriaProduto")
	@Column(name="gap_codigo", nullable = false)
	private long gap_codigo;

	@ManyToOne()
	@JoinColumn(name="T_Produto_prd_codigo", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	@JsonBackReference(value="galeriaProduto")
	private Produto gap_produto_prd_codigo;

	@Column(name="GAP_ENDSERVIDOR", nullable = true)
	private String gap_EndServidor;

	public long getGap_codigo() {
		return gap_codigo;
	}

	public void setGap_codigo(long gap_codigo) {
		this.gap_codigo = gap_codigo;
	}

	public Produto getGap_produto_prd_codigo() {
		return gap_produto_prd_codigo;
	}

	public void setGap_produto_prd_codigo(Produto gap_produto_prd_codigo) {
		this.gap_produto_prd_codigo = gap_produto_prd_codigo;
	}

	public String getGap_EndServidor() {
		return gap_EndServidor;
	}

	public void setGap_EndServidor(String gap_EndServidor) {
		this.gap_EndServidor = gap_EndServidor;
	}

	

}
