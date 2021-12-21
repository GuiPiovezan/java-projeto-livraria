package br.com.livraria.controller;

import br.com.livraria.model.Juridica;
import br.com.livraria.service.JuridicaService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/juridica")
public class PessoaResource {

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
}
