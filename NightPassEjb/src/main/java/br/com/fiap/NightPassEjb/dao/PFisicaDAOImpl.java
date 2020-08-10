package br.com.fiap.NightPassEjb.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;

@Stateless
@Remote
public class PFisicaDAOImpl extends GenericDAOImpl<PessoaFisica, Integer> implements PFisicaDAO {

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
