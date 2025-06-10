package br.com.future_mob.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loja")
    private Short idLoja;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "endereco_completo", length = 100, nullable = false)
    private String enderecoCompleto;

    public Loja() { }

    public Loja(String nome, String enderecoCompleto) {
        this.nome = nome;
        this.enderecoCompleto = enderecoCompleto;
    }

    public Short getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Short idLoja) {
        this.idLoja = idLoja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }
}