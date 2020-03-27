package br.com.fiap.NightPassEjb.dao;

import java.util.List;

public interface GenericDAO<T,K> {
	public void cadastrar(T entidade);
	public void atualizar(T entidade);
	public T buscar (K chave);
	public void remover(K chave) throws Exception;
	public List<T> listar();
	public void flush();
	public void refresh(T entidade);
	public T cadastrarRetEntity (T entidade);
}
