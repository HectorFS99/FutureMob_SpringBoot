package br.com.future_mob.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "cartoes_pagamento")
public class CartaoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao_pagamento")
    private Integer idCartaoPagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "numero_cartao", length = 16, nullable = false)
    private String numeroCartao;

    @Column(name = "nome_impresso", length = 20, nullable = false)
    private String nomeImpresso;

    @Column(name = "dt_expiracao", nullable = false)
    private String dataExpiracao;

    @Column(name = "codigo_seguranca", nullable = false)
    private Integer codigoSeguranca;

    @Column(name = "bandeira", length = 20, nullable = false)
    private String bandeira;

    @Column(name = "dt_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "apelido", length = 30)
    private String apelido;

    @Column(name = "credito", nullable = false)
    private Boolean credito = false;

    @Column(name = "debito", nullable = false)
    private Boolean debito = false;

    @Column(name = "principal", nullable = false)
    private Boolean principal;

    public CartaoPagamento() { }

    public CartaoPagamento(
        Usuario usuario
        , String numeroCartao
        , String nomeImpresso
        , String dataExpiracao
        , Integer codigoSeguranca
        , String bandeira
        , LocalDateTime dataCadastro
        , String apelido
        , Boolean credito
        , Boolean debito
        , Boolean principal) {
        this.usuario = usuario;
        this.numeroCartao = numeroCartao;
        this.nomeImpresso = nomeImpresso;
        this.dataExpiracao = dataExpiracao;
        this.codigoSeguranca = codigoSeguranca;
        this.bandeira = bandeira;
        this.dataCadastro = dataCadastro != null ? dataCadastro : LocalDateTime.now();
        this.apelido = apelido;
        this.credito = credito != null ? credito : false;
        this.debito = debito != null ? debito : false;
        this.principal = principal;
    }

    public Integer getIdCartaoPagamento() {
        return idCartaoPagamento;
    }

    public void setIdCartaoPagamento(Integer idCartaoPagamento) {
        this.idCartaoPagamento = idCartaoPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Integer getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(Integer codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Boolean getCredito() {
        return credito;
    }

    public void setCredito(Boolean credito) {
        this.credito = credito;
    }

    public Boolean getDebito() {
        return debito;
    }

    public void setDebito(Boolean debito) {
        this.debito = debito;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
}