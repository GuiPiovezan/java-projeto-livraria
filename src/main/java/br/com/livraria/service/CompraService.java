package br.com.livraria.service;

import br.com.livraria.model.Cliente;
import br.com.livraria.model.Compra;
import br.com.livraria.repository.CompraRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CompraService {

    @Inject
    CompraRepository compraRepository;

    public void adiciona(Compra compra) {
        compraRepository.persist(compra);
    }
}
