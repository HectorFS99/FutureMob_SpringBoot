package br.com.future_mob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.future_mob.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{	

}