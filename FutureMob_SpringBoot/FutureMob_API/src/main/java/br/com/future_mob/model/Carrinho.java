package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;
    
    private int quantidade;

    public Carrinho() { }

    public Carrinho(
        Usuario id_usuario
        , Produto id_produto
        , int quantidade
    ) {
        this.id_usuario = id_usuario;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
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