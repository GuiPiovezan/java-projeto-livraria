package br.com.livraria.service;

import br.com.livraria.model.Editora;
import br.com.livraria.repository.EditoraRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@ApplicationScoped
public class EditoraService {

    @Inject
    EditoraRepository editoraRepository;

    Editora editora;

    public void adiciona(Editora editora){
        editoraRepository.persist(editora);
    }

    public List<Editora> listar(){
        return editoraRepository.listAll();
    }

    public Editora listarId(Long id){
        return editoraRepository.findById(id);
    }

    public void deletar(Long id){
        editora = editoraRepository.findById(id);

        if(editora == null){
            throw new NotFoundException();
        }
        editoraRepository.deleteById(id);
    }

    public Editora altera(Long id, Editora editora){

        Editora upEditora = editoraRepository.findById(id);

        if(editora == null){
            throw new NotFoundException("Editora não encontrada");
        }

        upEditora.setNome(editora.getNome());
        upEditora.setLogradouro(editora.getLogradouro());
        upEditora.setNumero(editora.getNumero());
        upEditora.setBairro(editora.getBairro());
        upEditora.setCnpj(editora.getCnpj());

        return upEditora;
    }
}
