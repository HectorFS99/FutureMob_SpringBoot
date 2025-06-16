package br.com.future_mob.control;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
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

	@PostMapping(value = "/criar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> criar(@ModelAttribute Produto obj) {
		try {
			rep.save(obj);
			return ResponseEntity.ok(obj);
		} catch (Exception ex) {
			return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body("Erro ao salvar o registro: " + ex.getMessage());
		}
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

		if (op.isPresent()) {
			Produto obj = op.get();
			try {
				rep.deleteById(id);
				return obj;
			} catch (org.springframework.dao.DataIntegrityViolationException e) {
				throw new org.springframework.web.server.ResponseStatusException(
					HttpStatus.CONFLICT,
					"Não é possível excluir: produto vinculado a pedidos."
				);
			}
		} else {
			throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}