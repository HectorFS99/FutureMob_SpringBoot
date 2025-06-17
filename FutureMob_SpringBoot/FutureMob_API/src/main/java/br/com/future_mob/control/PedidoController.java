package br.com.future_mob.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.future_mob.model.DTO.PedidoDTO;
import br.com.future_mob.repository.PedidoRepository;
import br.com.future_mob.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository rep;
	
	@Autowired
	private ProdutoRepository prodRep;
	
	@GetMapping(value = "/todos")
	public List<PedidoDTO> retornarTodos() {
		List<PedidoDTO> pedidos = rep.retornarPedidos();
		
		for (PedidoDTO pedidoDTO : pedidos) {
			pedidoDTO.setProdutosPorPedido(prodRep.retornarProdutosPorPedido(pedidoDTO.getIdPedido()));
		}

		return pedidos;
	}
}