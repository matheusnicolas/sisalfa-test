package org.ufpb.projetoayla.meuProjetoWeb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ufpb.projetoayla.meuProjetoWeb.model.Desafio;
import org.ufpb.projetoayla.meuProjetoWeb.resources.beans.ContextoFilterBean;
import org.ufpb.projetoayla.meuProjetoWeb.service.DesafioServices;

@Path("/desafios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DesafioResources {

	DesafioServices desafioServices = new DesafioServices();

	@GET
	public List<Desafio> getDesafios(@BeanParam ContextoFilterBean filterBean){
		if(filterBean.getYear() > 0){
			return desafioServices.getAllDesafiosForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0){
			return desafioServices.getAllDesafiosPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return desafioServices.getAllDesafios();
	}
	
	@GET
	@Path("/{desafioId}")
	public Desafio getDesafio(@PathParam("desafioId") long id){
		return desafioServices.getDesafio(id);
	}
	
	@POST
	public Response addDesafio(Desafio palavra, @Context UriInfo uriInfo) throws URISyntaxException{
		
		Desafio newDesafio = desafioServices.addDesafio(palavra);
		String newId = String.valueOf(newDesafio.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newDesafio).build();
		
	}
	
	@PUT
	@Path("/{desafioId}")
	public Desafio updateDesafio(@PathParam("desafioId") long id, Desafio desafio){
		desafio.setId(id);
		return desafioServices.updateDesafio(desafio);
	}
	
	@DELETE
	@Path("/{desafioId}")
	public void deleteDesafio(@PathParam("desafioId") long id){
		desafioServices.removeDesafio(id);
	}
	
}
