package br.com.livraria.controller;

import br.com.livraria.model.Cliente;
import br.com.livraria.service.ClienteService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/clientes")
public class ClienteController {

    @Inject
    ClienteService service;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarCliente(Cliente cliente){
        service.inserir(cliente);
        return Response.created(URI.create("/clientes")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getAllClientes(){
        return service.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getSingleCliente(@PathParam("id") long id){
        return service.getCliente(id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletar(@PathParam("id") long id){
        service.deletarCliente(id);
        return Response.ok().build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente alterar(@PathParam("id") long id, Cliente cliente){
        service.alterarCliente(id, cliente);
        return cliente;
    }

    @GET
    @Path("/search/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente searchClientePorNome(@PathParam("nome") String nome){
        return service.searchClientePorNome(nome);
    }

}
