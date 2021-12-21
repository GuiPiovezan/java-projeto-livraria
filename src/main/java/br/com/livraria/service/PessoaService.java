package br.com.livraria.service;

import br.com.livraria.model.Pessoa;
import br.com.livraria.repository.PessoaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @Inject
    PessoaRepository pessoaRepository;

    public void adiciona(Pessoa pessoa){
        pessoaRepository.persist(pessoa);
    }

    public List<Pessoa> listar(){
        return pessoaRepository.listAll();
    }
}
