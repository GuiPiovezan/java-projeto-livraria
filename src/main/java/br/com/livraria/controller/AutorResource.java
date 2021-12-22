package br.com.livraria.controller;

import br.com.livraria.model.Autor;
import br.com.livraria.service.AutorService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/autores")
public class AutorResource {

    @Inject
    AutorService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionar(Autor autor){
        service.adicionar(autor);
        return Response.created(URI.create("/autores")).build();
    }

    @GET
    @Path("{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Autor listarCodigo(@PathParam("codigo") Long codigo){
        return service.listarCodigo(codigo);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Autor> listar(){
        return service.listar();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void deletar(@PathParam("codigo") Long codigo){
        service.deletar(codigo);
    }

    @PUT
    @Path("{codigo}")
    @Transactional
    public Autor delete(@PathParam("codigo") Long codigo, Autor autor){
        return service.alterar(codigo, autor);
    }
}
