package br.com.future_mob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.future_mob.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{ }