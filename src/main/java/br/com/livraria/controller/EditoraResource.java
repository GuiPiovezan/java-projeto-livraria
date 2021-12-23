package br.com.livraria.controller;

import br.com.livraria.model.Editora;
import br.com.livraria.model.Juridica;
import br.com.livraria.service.EditoraService;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/editoras")
public class EditoraResource {

    @Inject
    EditoraService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adiciona(Editora editora) {
        service.adiciona(editora);
        return Response.created(URI.create("/editoras")).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Editora listarId(@PathParam("id") Long id){
        return service.listarId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Editora> listar(){
        return service.listar();
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("admin")
    @Transactional
    public void deletar(@PathParam("id") Long id){
        service.deletar(id);
    }


    @PUT
    @Transactional
    @Path("{id}")
    public Editora alterar(@PathParam("id") Long id, Editora editora){
       return service.altera(id, editora);
    }
}
