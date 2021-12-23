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
        Funcionario funcionario = funcionarioRepository.findById(id);

        if(funcionario == null){
            throw new NotFoundException();
        }

        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> listAll() {
        return funcionarioRepository.listAll();

    }

    public Funcionario alterar(Long id, Funcionario funcionario){
        Funcionario funcionarioPesquisado = funcionarioRepository.findById(id);

        if(funcionario == null){
            throw new NotFoundException("Funcionario não existe");
        }

        funcionarioPesquisado.setNome(funcionario.getNome());
        funcionarioPesquisado.setLogradouro(funcionario.getLogradouro());
        funcionarioPesquisado.setNumero(funcionario.getNumero());
        funcionarioPesquisado.setBairro(funcionario.getBairro());
        funcionarioPesquisado.setCpf(funcionario.getCpf());
        funcionarioPesquisado.setCargo(funcionario.getCargo());
        funcionarioPesquisado.setSalario(funcionario.getSalario());

        return funcionarioPesquisado;
    }
}