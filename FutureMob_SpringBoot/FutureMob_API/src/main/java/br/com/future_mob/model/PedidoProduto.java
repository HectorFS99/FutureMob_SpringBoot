package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "pedidos_produtos")
public class PedidoProduto {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido id_pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;

    private int quantidade;

    public PedidoProduto() { }

    public PedidoProduto(
        Pedido id_pedido
        , Produto id_produto
        , int quantidade
    ) {
        this.id_pedido = id_pedido;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}