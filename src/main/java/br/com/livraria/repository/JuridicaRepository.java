package br.com.livraria.repository;


import br.com.livraria.model.Juridica;
import br.com.livraria.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JuridicaRepository implements PanacheRepository<Juridica> {
}
