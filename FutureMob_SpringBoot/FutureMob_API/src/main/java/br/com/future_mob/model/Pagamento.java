package br.com.future_mob.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer idPagamento;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_cartao_pagamento")
    private CartaoPagamento cartaoPagamento;

    @Column(name = "parcelas")
    private Short parcelas;

    public Pagamento() { }

    public Pagamento(FormaPagamento formaPagamento, CartaoPagamento cartaoPagamento, Short parcelas) {
        this.formaPagamento = formaPagamento;
        this.cartaoPagamento = cartaoPagamento;
        this.parcelas = parcelas;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public CartaoPagamento getCartaoPagamento() {
        return cartaoPagamento;
    }

    public void setCartaoPagamento(CartaoPagamento cartaoPagamento) {
        this.cartaoPagamento = cartaoPagamento;
    }

    public Short getParcelas() {
        return parcelas;
    }

    public void setParcelas(Short parcelas) {
        this.parcelas = parcelas;
    }
}
