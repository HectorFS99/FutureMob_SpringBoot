package br.com.future_mob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.future_mob.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{ }