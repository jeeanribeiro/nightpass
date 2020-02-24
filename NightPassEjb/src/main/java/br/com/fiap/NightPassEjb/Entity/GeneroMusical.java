package br.com.fiap.NightPassEjb.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_GenMusical")
public class GeneroMusical implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="genMusical",sequenceName="sq_t_GenMusical",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="genMusical")
	@Column(name="gmu_codigo")
	private Integer codigo;
	
	@Column(name="gmu_nome", length=60)
	private String nome;

	
	
	@ManyToMany(mappedBy="generoMusical")
	private List<Estabelecimento> estabelecimentos;

	public GeneroMusical() {
		super();
	}

	public GeneroMusical(Integer codigo, String nome) {
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
