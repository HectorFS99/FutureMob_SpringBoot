package br.com.future_mob.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.future_mob.model.Produto;
import br.com.future_mob.projections.ProdutoSubstringProjection;
import br.com.future_mob.repository.ProdutoRepository;
import br.com.future_mob.service.CachingService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {	
	@Autowired
	private ProdutoRepository rep;

	@Autowired
	private CachingService cache;
	
	@GetMapping(value = "/todos")
	public List<Produto> retornarTodos(){
		return rep.retornarTodos();
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
			Produto Produto = op.get();
			rep.deleteById(id);
			return Produto;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}

	@GetMapping("/substring")
	public List<ProdutoSubstringProjection> buscaPorSubstring(@RequestParam(value = "substring") String substring) {
		return cache.buscaPorSubstring(substring);
	}
}