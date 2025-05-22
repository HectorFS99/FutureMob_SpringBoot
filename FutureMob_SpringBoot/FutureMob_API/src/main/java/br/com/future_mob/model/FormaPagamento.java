package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import jakarta.persistence.Column;

@Entity
@Table(name = "formas_pagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento")
    private byte id_forma_pagamento;

    private String nome;

    public FormaPagamento() { }

    public FormaPagamento(
        byte id_forma_pagamento,
        String nome
    ) {
        this.id_forma_pagamento = id_forma_pagamento;
        this.nome = nome;
    }

    public byte getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(byte id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}