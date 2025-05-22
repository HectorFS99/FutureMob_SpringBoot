package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    
    private String nome_completo;    
    private String cpf;
    private String rg;
    private LocalDate dt_nascimento;
    private String sexo;
    private String telefone_celular;
    private String email;
    private String senha;
    private boolean admin;
    private String caminho_img_perfil;

    public Usuario() { }

    public Usuario(
        Integer id_usuario
        , String nome_completo
        , String cpf
        , String rg
        , LocalDate dt_nascimento
        , String sexo
        , String telefone_celular
        , String email
        , String senha
        , boolean admin
        , String caminho_img_perfil
    ) {
        this.id_usuario = id_usuario;
        this.nome_completo = nome_completo;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.sexo = sexo;
        this.telefone_celular = telefone_celular;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
        this.caminho_img_perfil = caminho_img_perfil;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone_celular() {
        return telefone_celular;
    }

    public void setTelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getCaminho_img_perfil() {
        return caminho_img_perfil;
    }

    public void setCaminho_img_perfil(String caminho_img_perfil) {
        this.caminho_img_perfil = caminho_img_perfil;
    }
}