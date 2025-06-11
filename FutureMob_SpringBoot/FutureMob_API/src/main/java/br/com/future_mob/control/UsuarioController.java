package br.com.future_mob.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.future_mob.model.Usuario;
import br.com.future_mob.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/Usuarios")
@Tag(name = "Usuários", description = "Operações relacionadas a usuários")
public class UsuarioController {	
	@Autowired
	private UsuarioRepository rep;
	
	@GetMapping(value = "/todos")
	public List<Usuario> retornarTodos() {
		return rep.findAll();
	}
	
    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por ID", 
               description = "Retorna um usuário com base no ID fornecido")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	public Usuario retornarPorID(@PathVariable Integer id) {
		Optional<Usuario> op =  rep.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PostMapping(value = "/criar")
	public Usuario criar(@RequestBody Usuario obj) {
		rep.save(obj);
		return obj;
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario obj_atualizado) {	
		Optional<Usuario> op = rep.findById(id);
		
		if(op.isPresent()) {			
			Usuario obj_atual = op.get();		
			obj_atual = obj_atualizado;
			
			rep.save(obj_atual);		
			return obj_atual;			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	@DeleteMapping("/{id}")
	public Usuario remover(@PathVariable Integer id) {	
		Optional<Usuario> op = rep.findById(id);
		
		if(op.isPresent()) {
			Usuario obj = op.get();
			rep.deleteById(id);
			
			return obj;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
}