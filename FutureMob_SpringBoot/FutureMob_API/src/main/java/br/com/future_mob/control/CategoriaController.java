package br.com.future_mob.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.future_mob.model.Categoria;
import br.com.future_mob.repository.CategoriaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository rep;

	@GetMapping(value = "/todos")
	public List<Categoria> retornarTodos() {
		return rep.findAll();
	}

	@GetMapping(value = "/{id}")
	public Categoria retornarPorID(@PathVariable Integer id) {
		Optional<Categoria> op = rep.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/criar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> criar(@ModelAttribute Categoria obj) {
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
	public Categoria atualizar(@PathVariable Integer id, @RequestBody Categoria obj_atualizado) {
		Optional<Categoria> op = rep.findById(id);

		if (op.isPresent()) {
			Categoria obj_atual = op.get();
			obj_atual = obj_atualizado;

			rep.save(obj_atual);
			return obj_atual;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public Categoria remover(@PathVariable Integer id) {
		Optional<Categoria> op = rep.findById(id);

		if (op.isPresent()) {
			Categoria obj = op.get();
			rep.deleteById(id);

			return obj;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}