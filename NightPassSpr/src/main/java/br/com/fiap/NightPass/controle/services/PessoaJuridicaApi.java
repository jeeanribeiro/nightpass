package br.com.fiap.NightPass.controle.services;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.NightPass.Api.Dao.PJuridicaApiDAO;
import br.com.fiap.NightPass.Api.Dao.PJuridicaApiDAOImpl;
import br.com.fiap.NightPass.singleton.EntityManagerFactorySingleton;
import br.com.fiap.NightPassSpr.Entity.PJuridica;


@Path("/pessoajuridicaapi")
@PermitAll
public class PessoaJuridicaApi {

	
	/*
	 * @GET
	 * 
	 * @Path("/ola")
	 * 
	 * @Produces(MediaType.TEXT_HTML) public String testaServico() {
	 * 
	 * return "Olá, o serviço funciona";
	 * 
	 * 
	 * }
	 */
	

	  private PJuridicaApiDAO dao;
	
		public PessoaJuridicaApi() {
			EntityManager em = 
					EntityManagerFactorySingleton.getInstance().createEntityManager();
			dao = new PJuridicaApiDAOImpl(em);
		}
	
	  @GET
	  @RolesAllowed("guest")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<PJuridica> buscarTodas() {
	  
	  return dao.listar();
	  
	  }
	  
	  @GET
	  @RolesAllowed("guest")
	  @Path("/{psjCodigo}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public PJuridica buscaPorChave(@PathParam("psjCodigo") long psjCodigo) {
		  
		  try {
		  return dao.buscar(psjCodigo);
		  }catch (EntityNotFoundException e) {
			  throw new
			  	WebApplicationException(Status.NOT_FOUND);
			  
		  }catch (Exception e) {
			  throw new
			  	WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }
		  
	  }
	
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public PJuridica buscarPJ() {
	 * 
	 * return dao.buscar(84L);
	 * 
	 * }
	 */
	
	
}
