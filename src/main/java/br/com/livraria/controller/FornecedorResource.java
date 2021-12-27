package br.com.livraria.controller;

import br.com.livraria.model.Fornecedor;
import br.com.livraria.service.FornecedorService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/fornecedor")
public class  FornecedorResource {

    @Inject
    FornecedorService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Fornecedor fornecedor) {
        service.adiciona(fornecedor);
        return Response.created(URI.create("/fornecedor")).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fornecedor listarId(@PathParam("id") Long id){
        return service.listarId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fornecedor> listar(){
        return service.listar();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id){
        service.deletar(id);
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Fornecedor alterar(@PathParam("id") Long id, Fornecedor fornecedor){
        return service.altera(id, fornecedor);
    }

}
