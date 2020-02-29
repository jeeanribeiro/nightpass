package br.com.fiap.NightPassEjb.dao;

import java.lang.reflect.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.FlushMode;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private Class<T> clazz;
	
	//@PersistenceContext
	@PersistenceContext()
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		
		this.em = em;
		
		clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
		
	}
	
	public void cadastrar(T entidade) {
		
		em.persist(entidade);
		em.setFlushMode(FlushModeType.COMMIT);
		
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
			
			throw new Exception("Entidade não encontrada");
		}
		
		em.remove(entidade);
		
	}

	public List<T> listar(){
		
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(T entidade) {
		
		em.refresh(entidade);
		
				
		// TODO Auto-generated method stub
		
	}
	
	
	
}
