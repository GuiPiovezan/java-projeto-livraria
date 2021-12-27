package br.com.livraria.service;

import br.com.livraria.model.Cliente;
import br.com.livraria.model.Compra;
import br.com.livraria.repository.ClienteRepository;
import br.com.livraria.repository.CompraRepository;
import br.com.livraria.repository.FuncionarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CompraService {

    @Inject
    CompraRepository compraRepository;

    public void adiciona(Compra compra) {
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.findById(compra.getCliente().getId());

        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.findById(compra.getFuncionario().getId());

        compraRepository.persist(compra);
    }
}
