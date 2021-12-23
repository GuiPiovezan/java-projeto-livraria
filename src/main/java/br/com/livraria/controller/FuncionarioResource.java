package br.com.livraria.controller;

import br.com.livraria.model.Funcionario;
import br.com.livraria.service.FuncionarioService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/funcionario")
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

}
