package br.com.livraria.service;

import br.com.livraria.model.Funcionario;
import br.com.livraria.model.Juridica;
import br.com.livraria.repository.FuncionarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class FuncionarioService {

    @Inject
    FuncionarioRepository funcionarioRepository;

    Funcionario funcionario;

    public void adicionar(Funcionario funcionario){
        funcionarioRepository.persist(funcionario);
    }

    public List<Funcionario> listar(){
        return funcionarioRepository.listAll();
    }

    public Funcionario listarId(Long id){
        return funcionarioRepository.findById(id);
    }

    public void deletar(Long id){
        funcionario = funcionarioRepository.findById(id);

        if(funcionario == null){
            throw new NotFoundException();
        }

        funcionarioRepository.deleteById(id);
    }

    /*public void alterar(Long id, Funcionario funcionario){
        funcionario = funcionarioRepository.findById(id);

        if(funcionario == null){
            throw new NotFoundException();
        }


        funcionarioRepository.update(id);
    }*/
}
