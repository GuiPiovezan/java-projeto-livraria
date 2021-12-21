package br.com.livraria.controller;

import br.com.livraria.model.Pessoa;
import br.com.livraria.service.PessoaService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/pessoas")
public class PessoaResource {

    @Inject
    PessoaService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Pessoa pessoa) {
        service.adiciona(pessoa);
    }
}
