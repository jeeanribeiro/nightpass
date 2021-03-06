package br.com.fiap.NightPassSpr.Dao;

import java.lang.reflect.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private Class<T> clazz;

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
	}

	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	public T atualizarRetEntity(T entidade) {
		em.merge(entidade);
		return entidade;
	}

	public T buscar (K chave) {
		return em.find(clazz, chave);
	}

	public void detach (T entidade) {
		em.detach(entidade);
	}

	public void remover(K chave) throws Exception {
		T entidade = buscar(chave);
		if (entidade == null) {
			throw new Exception("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public void refresh(T entidade) {
		em.refresh(entidade);
	}

	public T cadastrarRetEntity (T entidade) {
		em.persist(entidade);
		return entidade;
	}

}
