package br.com.fiap.NightPassEjb.testes;

import java.util.List;

import javax.ejb.EJB;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;
import br.com.fiap.NightPassEjb.dao.PFisicaDAOImpl;


public class TesteLogin {
	
	
	public static void main(String[] args) {
		
		
		PFisicaDAOImpl dao = new PFisicaDAOImpl();
		

		PessoaFisica pfisica = new PessoaFisica(); 
		
		//pfisica = dao.buscarPorEmail("lexduarte@yahoo.cOm.br");
		
		List <PessoaFisica> listpfisica = dao.listarPorNome();
		
		
		System.out.println(listpfisica.get(1).getNome());
		
		
		
		
		
		
		
	}
	

}
