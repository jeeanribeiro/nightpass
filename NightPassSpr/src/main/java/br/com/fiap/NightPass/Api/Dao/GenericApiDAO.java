package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

public interface GenericApiDAO <T,K> {
	
	public void cadastrar(T entidade);
	
	public void atualizar(T entidade);
	
	public T buscar (K chave);
	
	public void remover(K chave) throws Exception;

	public List<T> listar();
	
	public void commit() throws Exception;
	
	public void close();

}
