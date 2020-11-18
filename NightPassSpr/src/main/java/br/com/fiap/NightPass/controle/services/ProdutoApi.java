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
import br.com.fiap.NightPass.Api.Dao.ProdutoApiDAO;
import br.com.fiap.NightPass.Api.Dao.ProdutoApiDAOImpl;
import br.com.fiap.NightPass.singleton.EntityManagerFactorySingleton;
import br.com.fiap.NightPassSpr.Entity.PJuridica;
import br.com.fiap.NightPassSpr.Entity.Produto;


@Path("/produtoapi")
@PermitAll
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ProdutoApi {

	  private ProdutoApiDAO dao;

		public ProdutoApi() {
			EntityManager em =
					EntityManagerFactorySingleton.getInstance().createEntityManager();
			dao = new ProdutoApiDAOImpl(em);
		}

	  @GET
	  @RolesAllowed("guest")
	  public List<Produto> buscarTodas() {
	  return dao.listar();

	  }

	  @GET
	  @Path("Est/{EstCodigo}")
	  public List<Produto> buscaPorEstabelecimento(@PathParam("EstCodigo") long EstCodigo) {

		  try {
		  return dao.listarPorEst(EstCodigo);
		   }catch (EntityNotFoundException e) {
			  throw new
			  	WebApplicationException(Status.NOT_FOUND);
		  } catch (Exception e) {
			  throw new
			  	WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }

	  }


	  
	  
	  
	  @GET
	  @RolesAllowed("guest")
	  @Path("/{prdCodigo}")
	  public Produto buscaPorChave(@PathParam("prdCodigo") long prdCodigo) {

		  try {
		  return dao.buscar(prdCodigo);
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
	  public Response cadastrarNovaPJ (Produto produto) {

		  try {
			  dao.cadastrar(produto);
			  dao.commit();
			  URI uri = UriBuilder.fromPath("/{prd_codigo}").build(produto.getPrd_Codigo());
			  return Response.created(uri).entity(produto).build();
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
	  @Path("atualizar/{prd_Codigo}")
	  public Produto atualizarPJ (@PathParam("prd_Codigo") long prd_Codigo, Produto produto) {

		  try {
			  produto.setPrd_Codigo(prd_Codigo);;
			  dao.atualizar(produto);
			  dao.commit();
			  return produto;
		  } catch (Exception e) {
			  throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		  }

	  }

}
