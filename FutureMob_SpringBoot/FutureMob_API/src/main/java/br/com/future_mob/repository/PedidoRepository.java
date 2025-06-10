package br.com.future_mob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.future_mob.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{ }