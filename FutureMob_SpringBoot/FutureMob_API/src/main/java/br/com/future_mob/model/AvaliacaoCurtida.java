package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes_curtidas")
public class AvaliacaoCurtida {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_avaliacao")
    private Avaliacao id_avaliacao;
    
    private boolean curtiu;
    private boolean descurtiu;
    private LocalDateTime dt_interacao;

    public AvaliacaoCurtida() { }

    public AvaliacaoCurtida(
        Usuario id_usuario
        , Avaliacao id_avaliacao
        , boolean curtiu
        , boolean descurtiu
        , LocalDateTime dt_interacao
    ) {
        this.id_usuario = id_usuario;
        this.id_avaliacao = id_avaliacao;
        this.curtiu = curtiu;
        this.descurtiu = descurtiu;
        this.dt_interacao = dt_interacao;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Avaliacao getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(Avaliacao id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public boolean isCurtiu() {
        return curtiu;
    }

    public void setCurtiu(boolean curtiu) {
        this.curtiu = curtiu;
    }

    public boolean isDescurtiu() {
        return descurtiu;
    }

    public void setDescurtiu(boolean descurtiu) {
        this.descurtiu = descurtiu;
    }

    public LocalDateTime getDt_interacao() {
        return dt_interacao;
    }

    public void setDt_interacao(LocalDateTime dt_interacao) {
        this.dt_interacao = dt_interacao;
    }
}