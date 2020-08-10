package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

@Repository
public class PFisicaDAOImpl extends GenericDAOImpl<PessoaFisica, Long> implements PFisicaDAO {

	public PFisicaDAOImpl() {
		super();
	}

	public List<PessoaFisica> listarPorNome() {
		return em.createQuery("from PessoaFisica f Order by nome", PessoaFisica.class)
				.getResultList();
	}

	public PessoaFisica buscarPorEmail(String emailUsuario) {
		try {
			return em.createQuery("from PessoaFisica f Where UPPER(f.email)='"
			+ emailUsuario.toUpperCase() +"'", PessoaFisica.class).getSingleResult();
		} catch (NoResultException expected) {
			return null;
		}
	}

	public boolean autenticarUsuario(String emailUsuario, String Senha) {
		try {
			em.createQuery("from PessoaFisica f Where UPPER(f.email)='"
			+ emailUsuario.toUpperCase() +"'" + "AND f.senha='" + Senha + "'",
			PessoaFisica.class).getSingleResult();
			return true;
		} catch (NoResultException expected) {
			return false;
		}
	}

}
