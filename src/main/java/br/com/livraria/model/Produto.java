package br.com.livraria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private BigDecimal preco;

    private String tipo;

    private int quantidade;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "produto_compra",
            joinColumns = {
                    @JoinColumn(name = "produto_id")
            },
            inverseJoinColumns = {
                    @JoinColumn( name = "compra_id")
            }
    )
    private List<Compra> compras;


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
