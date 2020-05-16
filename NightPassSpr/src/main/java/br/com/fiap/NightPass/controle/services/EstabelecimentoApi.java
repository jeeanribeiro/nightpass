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

import br.com.fiap.NightPass.Api.Dao.EstabelecimentoApiDAO;
import br.com.fiap.NightPass.Api.Dao.EstabelecimentoApiDAOImpl;
import br.com.fiap.NightPass.singleton.EntityManagerFactorySingleton;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;

@Path("/estabelecimentoapi")
@PermitAll
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class EstabelecimentoApi {

	  private EstabelecimentoApiDAO dao;

		public EstabelecimentoApi() {
			EntityManager em =
					EntityManagerFactorySingleton.getInstance().createEntityManager();

			dao = new EstabelecimentoApiDAOImpl(em);
		}

		@GET
		@RolesAllowed("guest")
		public List<Estabelecimento> buscarTodas() {
			return dao.listar();
		}

		@GET
		@RolesAllowed("guest")
		@Path("/{estcodigo}")
		public Estabelecimento buscaPorChave(@PathParam("estcodigo") long estcodigo) {

			try {
				return dao.buscar(estcodigo);
			} catch (EntityNotFoundException e) {
				throw new
				WebApplicationException(Status.NOT_FOUND);
			} catch (Exception e) {
				throw new
				WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}

		}

		@RolesAllowed("user")
		@POST
		@Path("cadastrarNovo")
		public Response cadastrarNovoEst (Estabelecimento establecimentoNovo) {

			try {
				dao.cadastrar(establecimentoNovo);
				dao.commit();
				URI uri = UriBuilder.fromPath("/{estcodigo}").build(establecimentoNovo.getEstcodigo());
				return Response.created(uri).entity(establecimentoNovo).build();
			} catch(Exception e) {
				throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			}

		}

		  @RolesAllowed("user")
		  @DELETE
		  @Path("deletar/{estcodigo}")
		  public void deletarEst (@PathParam("estcodigo") long estcodigo) {

			  try {
				  dao.remover(estcodigo);
				  dao.commit();

			  } catch (Exception e) {
				  throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			  }

		  }

		  @RolesAllowed("user")
		  @PUT
		  @Path("atualizar/{estcodigo}")
		  public Estabelecimento atualizarPJ (@PathParam("estcodigo") long estcodigo, Estabelecimento estabelecimentoAtu) {

			  try {
				  estabelecimentoAtu.setEstcodigo(estcodigo);
				  dao.atualizar(estabelecimentoAtu);
				  dao.commit();
				  return estabelecimentoAtu;

			  } catch (Exception e) {
				  throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
			  }

		  }

}
