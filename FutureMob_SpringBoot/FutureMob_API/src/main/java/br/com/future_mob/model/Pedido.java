package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int id_pedido;

    private LocalDateTime dt_pedido;

    private float subtotal;
    private float frete;
    private float descontos;
    private float total;

    @ManyToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento id_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco id_endereco;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja id_loja;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status id_status;

    @Column(name = "dt_entrega")
    private LocalDate dt_entrega;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    public Pedido() { }

    public Pedido(
        int id_pedido
        , LocalDateTime dt_pedido
        , float subtotal
        , float frete
        , float descontos
        , float total
        , Pagamento id_pagamento
        , Endereco id_endereco
        , Loja id_loja
        , Status id_status
        , LocalDate dt_entrega
        , Usuario id_usuario
    ) {
        this.id_pedido = id_pedido;
        this.dt_pedido = dt_pedido;
        this.subtotal = subtotal;
        this.frete = frete;
        this.descontos = descontos;
        this.total = total;
        this.id_pagamento = id_pagamento;
        this.id_endereco = id_endereco;
        this.id_loja = id_loja;
        this.id_status = id_status;
        this.dt_entrega = dt_entrega;
        this.id_usuario = id_usuario;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDateTime getDt_pedido() {
        return dt_pedido;
    }

    public void setDt_pedido(LocalDateTime dt_pedido) {
        this.dt_pedido = dt_pedido;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public float getDescontos() {
        return descontos;
    }

    public void setDescontos(float descontos) {
        this.descontos = descontos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Pagamento getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Pagamento id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public Endereco getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Endereco id_endereco) {
        this.id_endereco = id_endereco;
    }

    public Loja getId_loja() {
        return id_loja;
    }

    public void setId_loja(Loja id_loja) {
        this.id_loja = id_loja;
    }

    public Status getId_status() {
        return id_status;
    }

    public void setId_status(Status id_status) {
        this.id_status = id_status;
    }

    public LocalDate getDt_entrega() {
        return dt_entrega;
    }

    public void setDt_entrega(LocalDate dt_entrega) {
        this.dt_entrega = dt_entrega;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
}