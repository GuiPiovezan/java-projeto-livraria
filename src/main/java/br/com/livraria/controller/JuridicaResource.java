package br.com.livraria.controller;

import br.com.livraria.model.Juridica;
import br.com.livraria.service.JuridicaService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/juridica")
public class JuridicaResource {

    @Inject
    JuridicaService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Juridica juridica) {
        service.adiciona(juridica);
        return Response.created(URI.create("/juridica")).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Juridica listarId(@PathParam("id") Long id){
        return service.listarId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Juridica> listar(){
        return service.listar();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id){
        service.deletar(id);
    }
}
