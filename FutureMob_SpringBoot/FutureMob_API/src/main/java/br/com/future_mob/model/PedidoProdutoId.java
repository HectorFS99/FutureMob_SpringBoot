package br.com.future_mob.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PedidoProdutoId implements Serializable {

    private Integer idPedido;
    private Integer idProduto;

    public PedidoProdutoId() { }

    public PedidoProdutoId(Integer idPedido, Integer idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}