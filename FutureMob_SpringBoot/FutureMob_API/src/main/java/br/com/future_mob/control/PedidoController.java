package br.com.future_mob.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.future_mob.model.Pedido;
import br.com.future_mob.repository.PedidoRepository;
import br.com.future_mob.service.CachingService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {	
	@Autowired
	private PedidoRepository rep;

	@Autowired
	private CachingService cache;
	
	@GetMapping(value = "/todos")
	public List<Pedido> retornarTodos() {
		return rep.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Pedido retornarPorID(@PathVariable Integer id) {
		Optional<Pedido> op =  rep.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Pedido atualizar(@PathVariable Integer id, @RequestBody Pedido obj_atualizado) {	
		Optional<Pedido> op = rep.findById(id);
		
		if(op.isPresent()) {			
			Pedido obj_atual = op.get();		
			obj_atual = obj_atualizado;
			
			rep.save(obj_atual);		
			return obj_atual;			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
}