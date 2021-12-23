package br.com.livraria.service;

import br.com.livraria.model.Autor;
import br.com.livraria.repository.AutorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class AutorService {

    @Inject
    AutorRepository autorRepository;

    public void adicionar(Autor autor){
        autorRepository.persist(autor);
    }

    public List<Autor> listar(){
        return autorRepository.listAll();
    }

    public Autor listarCodigo(Long codigo){
        return autorRepository.findById(codigo);
    }

    public void deletar(Long codigo){
        Autor autor = autorRepository.findById(codigo);

        if(autor == null){
            throw new NotFoundException();
        }

        autorRepository.deleteById(codigo);
    }

    public Autor alterar(Long codigo, Autor autor){
        Autor autorUp = autorRepository.findById(codigo);

        if(autorUp == null){
            throw new NotFoundException();
        }

        autorUp.setNome(autor.getNome());
        return autorUp;
    }
}
