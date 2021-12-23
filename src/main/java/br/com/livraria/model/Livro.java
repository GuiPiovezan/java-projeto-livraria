package br.com.livraria.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    private Long isbn;

    private String nome;
    private LocalDate anoPublicacao;
    private Long qtd;
    private BigDecimal preco;

    public Livro(){};

    public Livro(Long isbn, String nome, LocalDate anoPublicacao, Long qtd, BigDecimal preco) {
        this.isbn = isbn;
        this.nome = nome;
        this.anoPublicacao = anoPublicacao;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
