package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private byte id_status;

    private String nome;

    private String descricao;

    public Status() { }

    public Status(
        byte id_status,
        String nome,
        String descricao
    ) {
        this.id_status = id_status;
        this.nome = nome;
        this.descricao = descricao;
    }

    public byte getId_status() {
        return id_status;
    }

    public void setId_status(byte id_status) {
        this.id_status = id_status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}