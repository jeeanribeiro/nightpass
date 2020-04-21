package br.com.fiap.NightPass.Api.Dao;

import java.lang.reflect.*;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericApiDAOImpl<T, K> implements GenericApiDAO<T,K> {

	private Class<T> clazz;
		
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericApiDAOImpl(EntityManager em) {
		
		this.em = em;
		
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
		
	}
	
	public void cadastrar(T entidade) {
		
		em.persist(entidade);
	}
	
	public void atualizar(T entidade) {
		
		em.merge(entidade);
	}
	
	public T buscar (K chave) {
		
		return em.find(clazz, chave);
		
	}
	
	public void remover(K chave) throws Exception {
		
		T entidade = buscar(chave);
		
		if (entidade == null) {
			
			throw new Exception("Entidade n�o encontrada");
		}
		
		em.remove(entidade);
		
	}

	public List<T> listar(){
		
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
		
	}
	
	public void commit() throws Exception {
		
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch (Exception e) {
			
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new Exception("Erro no commit");
			
		}
		
	}
		
}
