package br.com.future_mob.model;

import jakarta.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Byte idStatus;

    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 100)
    private String descricao;

    public Status() { }

    public Status(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Byte getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Byte idStatus) {
        this.idStatus = idStatus;
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