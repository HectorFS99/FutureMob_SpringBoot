package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private int id_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento")
    private FormaPagamento id_forma_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_cartao_pagamento")
    private CartaoPagamento id_cartao_pagamento;

    private Byte parcelas;

    public Pagamento() { }

    public Pagamento(
        int id_pagamento,
        FormaPagamento id_forma_pagamento,
        CartaoPagamento id_cartao_pagamento,
        Byte parcelas
    ) {
        this.id_pagamento = id_pagamento;
        this.id_forma_pagamento = id_forma_pagamento;
        this.id_cartao_pagamento = id_cartao_pagamento;
        this.parcelas = parcelas;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public FormaPagamento getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(FormaPagamento id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public CartaoPagamento getId_cartao_pagamento() {
        return id_cartao_pagamento;
    }

    public void setId_cartao_pagamento(CartaoPagamento id_cartao_pagamento) {
        this.id_cartao_pagamento = id_cartao_pagamento;
    }

    public Byte getParcelas() {
        return parcelas;
    }

    public void setParcelas(Byte parcelas) {
        this.parcelas = parcelas;
    }
}