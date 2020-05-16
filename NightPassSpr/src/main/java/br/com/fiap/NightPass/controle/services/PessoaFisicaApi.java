package br.com.fiap.NightPass.controle.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.NightPass.Api.Dao.PFisicaApiDAO;
import br.com.fiap.NightPass.Api.Dao.PFisicaApiDAOImpl;
import br.com.fiap.NightPass.singleton.EntityManagerFactorySingleton;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;


@Path("/pessoafisicaapi")
public class PessoaFisicaApi {

	private PFisicaApiDAO dao;

	public PessoaFisicaApi() {
		EntityManager em =
				EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PFisicaApiDAOImpl(em);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON) public List<PessoaFisica> buscarTodas() {
		return dao.listar();
	}

}
