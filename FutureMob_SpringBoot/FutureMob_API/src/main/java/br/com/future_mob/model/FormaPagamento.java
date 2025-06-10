package br.com.future_mob.model;

import jakarta.persistence.*;

@Entity
@Table(name = "formas_pagamento")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento", columnDefinition = "TINYINT")
    private Short idFormaPagamento;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    public FormaPagamento() { }

    public FormaPagamento(String nome) {
        this.nome = nome;
    }

    public Short getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Short idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}