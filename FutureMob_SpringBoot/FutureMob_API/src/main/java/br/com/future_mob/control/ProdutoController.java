package br.com.future_mob.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.future_mob.model.Produto;
import br.com.future_mob.repository.ProdutoRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {	
	@Autowired
	private ProdutoRepository rep;
	
	@GetMapping(value = "/todos")
	public List<Produto> retornarTodos() {
		return rep.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Produto retornarPorID(@PathVariable Integer id) {
		Optional<Produto> op =  rep.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PostMapping(value = "/criar")
	public Produto criar(@RequestBody Produto obj) {
		rep.save(obj);
		return obj;
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Produto atualizar(@PathVariable Integer id, @RequestBody Produto obj_atualizado) {	
		Optional<Produto> op = rep.findById(id);
		
		if(op.isPresent()) {			
			Produto obj_atual = op.get();		
			obj_atual = obj_atualizado;
			
			rep.save(obj_atual);		
			return obj_atual;			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	@DeleteMapping("/{id}")
	public Produto remover(@PathVariable Integer id) {	
		Optional<Produto> op = rep.findById(id);
		
		if(op.isPresent()) {
			Produto obj = op.get();
			rep.deleteById(id);
			
			return obj;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
}