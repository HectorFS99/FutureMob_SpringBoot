package br.com.future_mob.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "preco_anterior", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoAnterior;

    @Column(name = "preco_atual", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoAtual;

    @Column(name = "altura", nullable = false, precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(name = "largura", nullable = false, precision = 5, scale = 2)
    private BigDecimal largura;

    @Column(name = "profundidade", nullable = false, precision = 5, scale = 2)
    private BigDecimal profundidade;

    @Column(name = "peso", nullable = false, precision = 6, scale = 2)
    private BigDecimal peso;

    @Column(name = "destaque", nullable = false)
    private Boolean destaque;

    @Column(name = "oferta_relampago", nullable = false)
    private Boolean ofertaRelampago;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "caminho_imagem", length = 255)
    private String caminhoImagem;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "dt_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    public Produto() {
        this.dataCadastro = LocalDateTime.now();
    }

    public Produto(
		String nome
		, String descricao
		, BigDecimal precoAnterior
		, BigDecimal precoAtual
		, BigDecimal altura
		, BigDecimal largura
		, BigDecimal profundidade
		, BigDecimal peso
		, Boolean destaque
		, Boolean ofertaRelampago
		, Categoria categoria
		, String caminhoImagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoAnterior = precoAnterior;
        this.precoAtual = precoAtual;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.peso = peso;
        this.destaque = destaque;
        this.ofertaRelampago = ofertaRelampago;
        this.categoria = categoria;
        this.caminhoImagem = caminhoImagem;
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoAnterior(BigDecimal precoAnterior) {
        this.precoAnterior = precoAnterior;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(BigDecimal profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }

    public Boolean getOfertaRelampago() {
        return ofertaRelampago;
    }

    public void setOfertaRelampago(Boolean ofertaRelampago) {
        this.ofertaRelampago = ofertaRelampago;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}