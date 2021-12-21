package br.com.livraria.service;

import br.com.livraria.model.Juridica;
import br.com.livraria.model.Pessoa;
import br.com.livraria.repository.JuridicaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class JuridicaService {

    @Inject
    JuridicaRepository juridicaRepository;

    public void adiciona(Juridica juridica){
        juridicaRepository.persist(juridica);
    }

    public List<Juridica> listar(){
        return juridicaRepository.listAll();
    }
}
