package br.com.fiap.NightPassSpr.Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="T_AGENDA")
public class Agenda implements Serializable {

	public Agenda() {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Seq_T_AGENDA", sequenceName="Seq_T_AGENDA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "Seq_T_AGENDA")
	@Column(name="AGE_CODIGO", nullable=false)
	private long ageCodigo;

	@Lob
	@Column(name="AGE_DETALHES", nullable=false)
	private String ageDetalhes;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:m")
	@Column(name="AGE_DATA", nullable=false)
	private Date ageData;

	/*
	 * @Lob
	 *
	 * @Basic(fetch=FetchType.LAZY)
	 *
	 * @Column(name="AGE_FTPUBLICIDADE", nullable = false) private byte[]
	 * ageFtPublicidade;
	 */
	@ManyToOne()
	@JoinColumn(name="T_ESTABELECI_EST_CODIGO", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Estabelecimento EstabelecimentoAge;

	@OneToMany(mappedBy = "preAgenda", fetch=FetchType.EAGER) @Fetch(value=FetchMode.SUBSELECT)
	private List<Presenca> AgePresenca;

	public long getAgeCodigo() {
		return ageCodigo;
	}

	public void setAgeCodigo(long ageCodigo) {
		this.ageCodigo = ageCodigo;
	}

	public String getAgeDetalhes() {
		return ageDetalhes;
	}

	public void setAgeDetalhes(String ageDetalhes) {
		this.ageDetalhes = ageDetalhes;
	}

	public Date getAgeData() {
		return ageData;
	}

	public void setAgeData(Date ageData) {
		this.ageData = ageData;
	}

	/*
	 * public byte[] getAgeFtPublicidade() { return ageFtPublicidade; }
	 *
	 * public void setAgeFtPublicidade(byte[] ageFtPublicidade) {
	 * this.ageFtPublicidade = ageFtPublicidade; }
	 */
	public Estabelecimento getEstabelecimentoAge() {
		return EstabelecimentoAge;
	}

	public void setEstabelecimentoAge(Estabelecimento estabelecimentoAge) {
		EstabelecimentoAge = estabelecimentoAge;
	}

	public List<Presenca> getAgePresenca() {
		return AgePresenca;
	}

	public void setAgePresenca(List<Presenca> agePresenca) {
		AgePresenca = agePresenca;
	}

}
