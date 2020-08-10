package br.com.fiap.NightPassEjb.testes;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;
import br.com.fiap.NightPassEjb.dao.PFisicaDAOImpl;
import br.com.fiap.NightPassEjb.util.FormatDate;

public class TesteLogin {
	
	public static void main(String[] args) {
		
		/*
		 * PFisicaDAOImpl dao = new PFisicaDAOImpl();
		 * 
		 * PessoaFisica pfisica = new PessoaFisica();
		 * 
		 * List <PessoaFisica> listpfisica = dao.listarPorNome();
		 * 
		 * System.out.println(listpfisica.get(1).getNome());
		 * 
		 * System.out.println(listpfisica.get(1).getPfGestor().get(0).getRgeCodigo());
		 * 
		 * pfisica.getPfGestor();
		 */
		
		System.out.println(FormatDate.getTimefmt(Calendar.getInstance()));
				
	}
		

	
}
