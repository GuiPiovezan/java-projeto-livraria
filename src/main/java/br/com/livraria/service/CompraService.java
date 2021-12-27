package br.com.livraria.service;

import br.com.livraria.controller.ProdutoResource;
import br.com.livraria.model.Cliente;
import br.com.livraria.model.Compra;
import br.com.livraria.model.Produto;
import br.com.livraria.repository.ClienteRepository;
import br.com.livraria.repository.CompraRepository;
import br.com.livraria.repository.FuncionarioRepository;
import br.com.livraria.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CompraService {

    @Inject
    CompraRepository compraRepository;

    public void adiciona(Compra compra) {
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.findById(compra.getCliente().getId());

        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.findById(compra.getFuncionario().getId());

        ProdutoRepository produtoRepository = new ProdutoRepository();

        List<Produto> produtos = compra.getProdutos();
        List<Produto> produtoId = new ArrayList<>(produtos);

        compra.setProdutos(produtoId);


        compraRepository.persist(compra);
    }
}
