package br.com.fiap.NightPass.controle.services;

import java.net.URI;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.NightPass.Api.Dao.PJuridicaApiDAO;
import br.com.fiap.NightPass.Api.Dao.PJuridicaApiDAOImpl;
import br.com.fiap.NightPass.singleton.EntityManagerFactorySingleton;
import br.com.fiap.NightPassSpr.Entity.PJuridica;


@Path("/pessoajuridicaapi")
@PermitAll
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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

	  public List<PJuridica> buscarTodas() {

	  return dao.listar();

	  }

	  @GET
	  @RolesAllowed("guest")
	  @Path("/{psjCodigo}")
	  public PJuridica buscaPorChave(@PathParam("psjCodigo") long psjCodigo) {

		  try {
		  return dao.buscar(psjCodigo);
		   }catch (EntityNotFoundException e) {
			  throw new
			  	WebApplicationException(Status.NOT_FOUND);
		  } catch (Exception e) {
			  throw new
			  	WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }

	  }


	  @RolesAllowed("user")
	  @POST
	  @Path("cadastrarNova")
	  public Response cadastrarNovaPJ (PJuridica pJuridicaNova) {

		  try {
			  dao.cadastrar(pJuridicaNova);
			  dao.commit();
			  URI uri = UriBuilder.fromPath("/{psjCodigo}").build(pJuridicaNova.getPsjCodigo());
			  return Response.created(uri).entity(pJuridicaNova).build();
		  } catch(Exception e) {
			  throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }

	  }

	  @RolesAllowed("user")
	  @DELETE
	  @Path("deletar/{psjCodigo}")
	  public void deletarPJ (@PathParam("psjCodigo") long psjCodigo) {

		  try {
			  dao.remover(psjCodigo);
			  dao.commit();
		  } catch (Exception e) {
			  throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }

	  }

	  @RolesAllowed("user")
	  @PUT
	  @Path("atualizar/{psjCodigo}")
	  public PJuridica atualizarPJ (@PathParam("psjCodigo") long psjCodigo, PJuridica pJuridicaAtu) {

		  try {
			  pJuridicaAtu.setPsjCodigo(psjCodigo);
			  dao.atualizar(pJuridicaAtu);
			  dao.commit();
			  return pJuridicaAtu;
		  } catch (Exception e) {
			  throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }

	  }

}
