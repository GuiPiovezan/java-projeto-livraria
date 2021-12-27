package br.com.livraria.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Fisica{
    private String cargo;
    private BigDecimal salario;

    @OneToMany(mappedBy = "funcionario")
    private List<Compra> compras;


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
