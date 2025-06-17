package br.com.future_mob.model.DTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.future_mob.projections.ProdutoProjection;

public class PedidoDTO {
    private Integer id_pedido;
    private Date dt_pedido;
    private BigDecimal subtotal;
    private BigDecimal frete;
    private BigDecimal total;
    private String formaPagamento;
    private String numeroCartao;
    private Short parcelas;
    private String endereco;
    private String enderecoLoja;
    private String statusPedido;
    private Date dt_entrega;
    private String nome_completo;
    private String email;
    private String telefone_celular;

    private List<ProdutoProjection> produtosPorPedido;

    public PedidoDTO() { }

    public PedidoDTO(
        Integer id_pedido
        , Date dt_pedido
        , BigDecimal subtotal
        , BigDecimal frete
        , BigDecimal total
        , String formaPagamento
        , String numeroCartao
        , Short parcelas
        , String endereco
        , String enderecoLoja
        , String statusPedido
        , Date dt_entrega
        , String nome_completo
        , String email
        , String telefone_celular) {
        this.id_pedido = id_pedido;
        this.dt_pedido = dt_pedido;
        this.subtotal = subtotal;
        this.frete = frete;
        this.total = total;
        this.formaPagamento = formaPagamento;
        this.numeroCartao = numeroCartao;
        this.parcelas = parcelas;
        this.endereco = endereco;
        this.enderecoLoja = enderecoLoja;
        this.statusPedido = statusPedido;
        this.dt_entrega = dt_entrega;
        this.nome_completo = nome_completo;
        this.email = email;
        this.telefone_celular = telefone_celular;
    }

    public Integer getIdPedido() {
        return id_pedido;
    }

    public void setIdPedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getDtPedido() {
        return dt_pedido;
    }

    public void setDtPedido(Date dt_pedido) {
        this.dt_pedido = dt_pedido;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Short getParcelas() {
        return parcelas;
    }

    public void setParcelas(Short parcelas) {
        this.parcelas = parcelas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(String enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Date getDtEntrega() {
        return dt_entrega;
    }

    public void setDtEntrega(Date dt_entrega) {
        this.dt_entrega = dt_entrega;
    }

    public String getNomeCompleto() {
        return nome_completo;
    }

    public void setNomeCompleto(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneCelular() {
        return telefone_celular;
    }

    public void setTelefoneCelular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public List<ProdutoProjection> getProdutosPorPedido() {
        return produtosPorPedido;
    }

    public void setProdutosPorPedido(List<ProdutoProjection> produtosPorPedido) {
        this.produtosPorPedido = produtosPorPedido;
    }
}