package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
@Table(name = "cartoes_pagamento")
public class CartaoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao_pagamento")
    private int id_cartao_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    private String numero_cartao;
    private String nome_impresso;
    private String dt_expiracao;
    private int codigo_seguranca;
    private String bandeira;
    private LocalDateTime dt_cadastro;
    private String apelido;
    private boolean credito;
    private boolean debito;
    private boolean principal;

    public CartaoPagamento() { }

    public CartaoPagamento(
        int id_cartao_pagamento
        , Usuario id_usuario
        , String numero_cartao
        , String nome_impresso
        , String dt_expiracao
        , int codigo_seguranca
        , String bandeira
        , LocalDateTime dt_cadastro
        , String apelido
        , boolean credito
        , boolean debito
        , boolean principal
    ) {
        this.id_cartao_pagamento = id_cartao_pagamento;
        this.id_usuario = id_usuario;
        this.numero_cartao = numero_cartao;
        this.nome_impresso = nome_impresso;
        this.dt_expiracao = dt_expiracao;
        this.codigo_seguranca = codigo_seguranca;
        this.bandeira = bandeira;
        this.dt_cadastro = dt_cadastro;
        this.apelido = apelido;
        this.credito = credito;
        this.debito = debito;
        this.principal = principal;
    }

    public int getId_cartao_pagamento() {
        return id_cartao_pagamento;
    }

    public void setId_cartao_pagamento(int id_cartao_pagamento) {
        this.id_cartao_pagamento = id_cartao_pagamento;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getNome_impresso() {
        return nome_impresso;
    }

    public void setNome_impresso(String nome_impresso) {
        this.nome_impresso = nome_impresso;
    }

    public String getDt_expiracao() {
        return dt_expiracao;
    }

    public void setDt_expiracao(String dt_expiracao) {
        this.dt_expiracao = dt_expiracao;
    }

    public int getCodigo_seguranca() {
        return codigo_seguranca;
    }

    public void setCodigo_seguranca(int codigo_seguranca) {
        this.codigo_seguranca = codigo_seguranca;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public LocalDateTime getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(LocalDateTime dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
}