package br.com.future_mob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.future_mob.model.Usuario;
import br.com.future_mob.projections.UsuarioProjection;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

    @Query(value = """
        SELECT 
            id_usuario
            , nome_completo
            , cpf
            , rg
            , dt_nascimento
            , sexo
            , telefone_celular
            , email
            , admin
            , caminho_img_perfil
        FROM 
            usuarios
        WHERE
            email = :email
            AND senha = :senha
        """, nativeQuery = true)
    UsuarioProjection autenticar(String email, String senha);
}