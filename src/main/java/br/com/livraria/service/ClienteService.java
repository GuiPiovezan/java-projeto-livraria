package br.com.livraria.service;


import br.com.livraria.model.Cliente;
import br.com.livraria.model.Pessoa;
import br.com.livraria.repository.ClienteRepository;
import io.quarkus.panache.hibernate.common.runtime.PanacheJpaUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    EntityManager entityManager;

    public void inserir(Cliente cliente){
        clienteRepository.persist(cliente);
    }

    public List<Cliente> listAll(){
        return clienteRepository.listAll();
    }

    public Cliente getCliente(long id){
        return clienteRepository.findById(id);
    }

    public void deletarCliente(long id) {
        Cliente cliente = clienteRepository.findById(id);
        if(cliente == null){
            throw new NotFoundException("O cliente não existe na base de dados ou já foi excluído");
        }

        clienteRepository.delete(cliente);
    }

    public void alterarCliente(long id, Cliente cliente) {
        Cliente clientePesquisado = clienteRepository.findById(id);

        if(cliente == null){
            throw new NotFoundException("Não existe esse cliente");
        }

        clientePesquisado.setNome(cliente.getNome());
        clientePesquisado.setLogradouro(cliente.getLogradouro());
        clientePesquisado.setBairro(cliente.getBairro());
        clientePesquisado.setNumero(cliente.getNumero());

    }

    public Cliente searchClientePorNome(String nome) {
        String nomeAlterado = nome.replace("-", " ");
        return (Cliente) entityManager.createQuery("FROM Pessoa WHERE nome = :nome", Pessoa.class).setParameter("nome", nomeAlterado).getSingleResult();
    }
}
