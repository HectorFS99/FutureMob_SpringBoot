package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_avaliacao;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;
    
    private BigDecimal avaliacao;
    private LocalDate dt_avaliacao;
    private String titulo;
    private String descricao;
    private String imagem;
    private boolean verificado;

    public Avaliacao() { }

    public Avaliacao(
        Integer id_avaliacao,
        Usuario id_usuario,
        Produto id_produto,
        BigDecimal avaliacao,
        LocalDate dt_avaliacao,
        String titulo,
        String descricao,
        String imagem,
        boolean verificado
    ) {
        this.id_avaliacao = id_avaliacao;
        this.id_usuario = id_usuario;
        this.id_produto = id_produto;
        this.avaliacao = avaliacao;
        this.dt_avaliacao = dt_avaliacao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.verificado = verificado;
    }

    public Integer getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(Integer id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
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

    public BigDecimal getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(BigDecimal avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDt_avaliacao() {
        return dt_avaliacao;
    }

    public void setDt_avaliacao(LocalDate dt_avaliacao) {
        this.dt_avaliacao = dt_avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}