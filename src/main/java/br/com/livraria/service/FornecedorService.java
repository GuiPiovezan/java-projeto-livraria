package br.com.livraria.service;

import br.com.livraria.model.Fornecedor;
import br.com.livraria.repository.FornecedorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class FornecedorService {

    @Inject
    FornecedorRepository fornecedorRepository;

    Fornecedor fornecedor;

    public void adiciona(Fornecedor fornecedor) {
        fornecedorRepository.persist(fornecedor);
    }

    public List<Fornecedor> listar() {
        return fornecedorRepository.listAll();
    }

    public Fornecedor listarId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deletar(Long id) {
        fornecedor = fornecedorRepository.findById(id);

        if( fornecedor == null){
            throw new NotFoundException(" Sem id");
        }
        fornecedorRepository.deleteById(id);
    }


    public Fornecedor altera(Long id, Fornecedor fornecedor) {

        Fornecedor upFornecedor = fornecedorRepository.findById(id);

        if( fornecedor == null){
            throw new NotFoundException(" Fornecedor não encontrado");
        }

        upFornecedor.setNome(fornecedor.getNome());
        upFornecedor.setBairro(fornecedor.getBairro());
        upFornecedor.setCnpj(fornecedor.getCnpj());
        upFornecedor.setLogradouro(fornecedor.getLogradouro());
        upFornecedor.setNumero(fornecedor.getNumero());

        return upFornecedor;
    }
}
