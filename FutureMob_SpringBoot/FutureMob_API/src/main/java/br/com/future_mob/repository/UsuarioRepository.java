package br.com.future_mob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.future_mob.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}