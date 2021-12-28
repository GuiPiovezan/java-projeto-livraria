package br.com.livraria.controller;

import br.com.livraria.model.Produto;
import br.com.livraria.service.ProdutoService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/produtos")
public class ProdutoResource {

    @Inject
    ProdutoService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionar(Produto produto){
        service.adicionar(produto);
        return Response.created(URI.create("/produtos")).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto listarId(@PathParam("id") long id){
        return service.listarId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar(){
        return service.listar();
    }

    @GET
    @Path("/search/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarTipo(@PathParam("tipo") String tipo){
        return service.listarTipo(tipo);
    }

    @GET
    @Path("/searchName/{descricao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto listarNomeProduto(@PathParam("descricao") String descricao){
        return service.listarNomeProduto(descricao);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") long id){
        service.deletar(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto alterar(@PathParam("id") long id, Produto produto){
        return service.alterar(id, produto);
    }

}
