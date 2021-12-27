package br.com.livraria.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name="id")
public class Fornecedor extends  Juridica{

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;

}
