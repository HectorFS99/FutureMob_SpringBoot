package br.com.future_mob.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.future_mob.model.Usuario;
import br.com.future_mob.model.DTO.AutenticacaoDTO;
import br.com.future_mob.projections.UsuarioProjection;
import br.com.future_mob.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {	
	@Autowired
	private UsuarioRepository rep;
	
	@GetMapping(value = "/todos") 
	public List<Usuario> retornarTodos() {
		return rep.findAll();
	}
	
    @PostMapping(
        value = "/autenticar",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> autenticar(@RequestBody AutenticacaoDTO dto) {
        try {
            UsuarioProjection usr = rep.autenticar(dto.getEmail(), dto.getSenha());

            if (usr == null) {
                return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Usuário não encontrado.");
            } else if (!usr.getAdmin()) {
                return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Você não tem permissão para acessar o painel administrativo.");
            }

            return ResponseEntity.ok(usr);
        } catch (Exception ex) {
            return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body("Ocorreu um erro ao autenticar você: " + ex.getMessage());
        }
    }
	
    @GetMapping("/{id}")
	public Usuario retornarPorID(@PathVariable Integer id) {
		Optional<Usuario> op =  rep.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PostMapping(value = "/criar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> criar(@ModelAttribute Usuario obj) {
		try {
			if (rep.existsByCpf(obj.getCpf())) {
				return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Já existe um usuário com o CPF informado.");
			}

			if (rep.existsByEmail(obj.getEmail())) {
				return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("Já existe um usuário com o e-mail informado.");
			}

			rep.save(obj);
			return ResponseEntity.ok(obj);
		} catch (Exception ex) {
			return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body("Erro ao salvar o registro: " + ex.getMessage());
		}
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