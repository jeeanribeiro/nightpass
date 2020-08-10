package br.com.fiap.NightPass.Api.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.PessoaFisica;

public interface PFisicaApiDAO extends GenericApiDAO<PessoaFisica, Long> {
	public List<PessoaFisica> listarPorNome();
	public PessoaFisica buscarPorEmail(String emailUsuario);
	public boolean autenticarUsuario(String emailUsuario, String Senha);
}
