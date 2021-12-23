package br.com.livraria.controller;

import br.com.livraria.model.Funcionario;
import br.com.livraria.model.Juridica;
import br.com.livraria.service.FuncionarioService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    FuncionarioService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Funcionario funcionario){
        service.adicionar(funcionario);
        return  Response.created(URI.create("/funcionario")).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> listar(){
        return service.listAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario listarId(@PathParam("id") Long id){
        return service.listarId(id);
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Funcionario alterar(@PathParam("id") Long id, Funcionario funcionario){
        return service.alterar(id, funcionario);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id){
        service.deletar(id);
    }
}
