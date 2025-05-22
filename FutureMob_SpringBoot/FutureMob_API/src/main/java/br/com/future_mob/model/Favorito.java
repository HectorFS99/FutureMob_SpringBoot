package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
@Table(name = "favoritos")
public class Favorito {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;

    private LocalDateTime dt_inclusao;

    public Favorito() { }

    public Favorito(
        Usuario id_usuario
        , Produto id_produto
        , LocalDateTime dt_inclusao
    ) {
        this.id_usuario = id_usuario;
        this.id_produto = id_produto;
        this.dt_inclusao = dt_inclusao;
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

    public LocalDateTime getDt_inclusao() {
        return dt_inclusao;
    }

    public void setDt_inclusao(LocalDateTime dt_inclusao) {
        this.dt_inclusao = dt_inclusao;
    }
}
