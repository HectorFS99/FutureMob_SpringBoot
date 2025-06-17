package br.com.future_mob.model.DTO;

import java.time.LocalDate;

public interface UsuarioDTO {
    Integer getIdUsuario();
    String getNomeCompleto();
    String getCpf();
    String getRg();
    LocalDate getDataNascimento();
    String getSexo();
    String getTelefoneCelular();
    String getEmail();
    Boolean getAdmin();
    String getCaminhoImgPerfil();
}