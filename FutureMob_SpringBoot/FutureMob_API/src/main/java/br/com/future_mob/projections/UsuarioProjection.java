package br.com.future_mob.projections;

import java.time.LocalDate;

public interface UsuarioProjection {
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