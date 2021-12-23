package br.com.livraria.controller;

import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/livros")
public class LivroResource {

    @Inject
    LivroService service;


    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adiciona(Livro livro){

        service.adiciona(livro);

        return Response.created(URI.create("/livros")).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Livro listarId(@PathParam("id") Long id){
        return service.listarId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livro> listar(){
        return service.listar();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id){
        service.deletar(id);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Livro alterar(@PathParam("id") Long id, Livro livro){
        return service.alterar(id, livro);
    }
}
