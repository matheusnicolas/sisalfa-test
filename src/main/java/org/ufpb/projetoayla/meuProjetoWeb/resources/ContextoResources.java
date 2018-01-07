package org.ufpb.projetoayla.meuProjetoWeb.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

import org.ufpb.projetoayla.meuProjetoWeb.service.ContextoServices;
import org.ufpb.projetoayla.meuProjetoWeb.model.Contexto;

@Path("/contextos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContextoResources {

	ContextoServices contextoServices = new ContextoServices();
	
	@GET
	public List<Contexto> getContextos(){
		return contextoServices.getAllContextos();
	}
	
	@GET
	@Path("/{contextoId}")
	public Contexto getContexto(@PathParam("contextoId") long id){
		return contextoServices.getContexto(id);
	}
	
	@POST
	public Response addContexto(Contexto contexto, @Context UriInfo uriInfo) throws URISyntaxException {
		Contexto newContexto = contextoServices.addContexto(contexto);
		String newId = String.valueOf(newContexto.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newContexto).build();
	}
	
	@PUT
	@Path("/{contextoId}")
	public Contexto updateContexto(@PathParam("contextoId") long id, Contexto contexto) {
		contexto.setId(id);
		return contextoServices.updateContexto(contexto);
	}
	
	@DELETE
	@Path("/{contextoId}")
	public void deleteDesafio(@PathParam("contextoId") long id) {
		contextoServices.removeContexto(id);
		
	}
	
	
	
	
}
