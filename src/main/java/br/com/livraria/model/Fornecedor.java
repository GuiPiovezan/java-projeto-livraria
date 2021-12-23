package br.com.livraria.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name="id")
public class Fornecedor extends  Juridica{

}
