package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

public interface PFisicaDAO extends GenericDAO<PessoaFisica, Long> {
	public List<PessoaFisica> listarPorNome();
	public PessoaFisica buscarPorEmail(String emailUsuario);
	public boolean autenticarUsuario(String emailUsuario, String Senha);
}
