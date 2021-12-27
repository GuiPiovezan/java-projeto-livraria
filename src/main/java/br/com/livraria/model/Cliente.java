package br.com.livraria.model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Fisica{

    private BigDecimal credito;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }
}
