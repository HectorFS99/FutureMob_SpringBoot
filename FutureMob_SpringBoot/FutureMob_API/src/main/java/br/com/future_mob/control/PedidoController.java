package br.com.future_mob.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.future_mob.model.DTO.PedidoDTO;
import br.com.future_mob.service.CachingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private CachingService cacheService;
	
	@GetMapping(value = "/todos")
	public List<PedidoDTO> retornarTodos() {
		return cacheService.retornarPedidos();
	}
}