package br.com.livraria.service;

import br.com.livraria.model.Juridica;
import br.com.livraria.model.Pessoa;
import br.com.livraria.repository.JuridicaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class JuridicaService {

    @Inject
    JuridicaRepository juridicaRepository;

    Juridica juridica;

    public void adiciona(Juridica juridica){
        juridicaRepository.persist(juridica);
    }

    public List<Juridica> listar(){
        return juridicaRepository.listAll();
    }

    public Juridica listarId(Long id){
        return juridicaRepository.findById(id);
    }


    public void deletar(Long id){
        juridica = juridicaRepository.findById(id);

        if(juridica == null){
            throw new NotFoundException();
        }

        juridicaRepository.deleteById(id);
    }

    public void alterar(){

    }
}
