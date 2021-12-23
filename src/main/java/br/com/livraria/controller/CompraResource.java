package br.com.livraria.controller;

import br.com.livraria.model.Cliente;
import br.com.livraria.model.Compra;
import br.com.livraria.service.CompraService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/compra")
public class CompraResource {

    @Inject
    CompraService service;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionar(Compra compra){
        service.adiciona(compra);
        return Response.created(URI.create("/compra")).build();
    }

}
