package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "lojas")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja")
    private short id_loja;

    private String nome;

    private String endereco_completo;

    public Loja() { }

    public Loja(
        short id_loja
        , String nome
        , String endereco_completo
    ) {
        this.id_loja = id_loja;
        this.nome = nome;
        this.endereco_completo = endereco_completo;
    }

    public short getId_loja() {
        return id_loja;
    }

    public void setId_loja(short id_loja) {
        this.id_loja = id_loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco_completo() {
        return endereco_completo;
    }

    public void setEndereco_completo(String endereco_completo) {
        this.endereco_completo = endereco_completo;
    }
}