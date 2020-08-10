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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="T_TipoEst")
public class TipoEstabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tipoEst",sequenceName="sq_t_TipoEst",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tipoEst")

	@Column(name="tes_codigo")
	private long codigo;

	@Column(name="tes_nome", length=60)
	private String nome;

	@OneToMany(mappedBy = "tes_codigo")

	//é necessária para impedir o loop infinito
	//Permite a Exibição
	@JsonIgnore()
	private List<Estabelecimento> estabelecimentos;

	public TipoEstabelecimento() {
		super();
	}

	public TipoEstabelecimento(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

}
