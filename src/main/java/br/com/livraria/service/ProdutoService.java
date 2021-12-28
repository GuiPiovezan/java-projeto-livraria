package br.com.livraria.service;

import br.com.livraria.model.Produto;
import br.com.livraria.repository.FornecedorRepository;
import br.com.livraria.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    EntityManager entityManager;

    public void adicionar(Produto produto){
        FornecedorRepository fornecedorRepository = new FornecedorRepository();
        fornecedorRepository.findById(produto.getFornecedor().getId());
        produtoRepository.persist(produto);
    }

    public Produto listarId(long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> listar(){
        return produtoRepository.listAll();
    }

    public List<Produto> listarTipo(String tipo){
        return produtoRepository.list("tipo", tipo);
    }

    public Produto listarNomeProduto(String descricao){
        String descricaoAlt = descricao.replace("-"," ");
        return entityManager.createQuery("SELECT P FROM Produto AS P WHERE descricao = :descricao", Produto.class).setParameter("descricao", descricaoAlt).getSingleResult();
    }

    public void deletar(long id){
        Produto produto = produtoRepository.findById(id);
        if(produto == null){
            throw new NotFoundException("O produto não existe!");
        }

        produtoRepository.deleteById(id);
    }

    public Produto alterar(long id, Produto produto){
        Produto produtoUp = produtoRepository.findById(id);

        if(produto == null){
            throw new NotFoundException("O produto não existe!");
        }

        produtoUp.setDescricao(produto.getDescricao());
        produtoUp.setQuantidade(produto.getQuantidade());
        produtoUp.setTipo(produto.getTipo());
        produtoUp.setPreco(produto.getPreco());

        return produtoUp;
    }


}
