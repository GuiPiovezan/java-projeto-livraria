package br.com.livraria.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
@UserDefinition
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String logradouro;
    private String numero;
    private String bairro;

    @Username
    private String usuario;
    @Password
    private String senha;
    @Roles
    private String role;

    public Pessoa(){};

    public Pessoa(String nome, String logradouro, String numero, String bairro, String usuario) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionar(Pessoa pessoa){
        pessoa.senha = BcryptUtil.bcryptHash(pessoa.senha);
        pessoa.role = validarUsuario(pessoa.usuario);
    }

    private static String validarUsuario(String usuario){
        if(usuario.equalsIgnoreCase("Shift")){
            return "admin";
        }
        return "user";
    }
}
