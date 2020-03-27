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

@Entity
@Table(name="T_TipoEst")

public class TipoEstabelecimento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipoEst",sequenceName="sq_t_TipoEst",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tipoEst")
	
	@Column(name="tes_codigo")
	private Integer codigo;
	
	@Column(name="tes_nome", length=60)
	private String nome;

	@OneToMany(mappedBy = "tes_codigo")
	private List<Estabelecimento> estabelecimentos;
	
	public TipoEstabelecimento() {
		super();
	}
	
	public TipoEstabelecimento(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}
	
}
