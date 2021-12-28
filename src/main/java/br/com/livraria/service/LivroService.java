package br.com.livraria.service;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.AutorRepository;
import br.com.livraria.repository.LivroRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class LivroService {

    @Inject
    LivroRepository repository;

    Livro livro;

    public void adiciona(Livro livro) {
        AutorRepository autorRepository = new AutorRepository();
        autorRepository.findById(livro.getAutor().getCodigo());

        livro.setAnoPublicacao(LocalDate.now());
        repository.persist(livro);
    }

    public List<Livro> listar(){
        return repository.listAll();
    }

    public Livro listarId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        livro = repository.findById(id);

        if(livro == null){
            throw new NotFoundException("Livro não encontrado");
        }

        repository.deleteById(id);
    }

    public Livro alterar(Long id, Livro livro) {
        Livro livroAlterar =  repository.findById(id);

        if(livroAlterar == null){
            throw new NotFoundException("Livro não encontrado");
        }

        livroAlterar.setIsbn(livro.getIsbn());
        livroAlterar.setNome(livro.getNome());
        livroAlterar.setAnoPublicacao(livro.getAnoPublicacao());
        livroAlterar.setQtd(livro.getQtd());
        livroAlterar.setPreco(livro.getPreco());

        return  livroAlterar;
    }
}
