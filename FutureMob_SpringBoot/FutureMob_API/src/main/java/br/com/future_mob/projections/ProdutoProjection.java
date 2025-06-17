package br.com.future_mob.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ProdutoProjection {
    Integer getIdProduto();
    String getNome();
    String getDescricao();
    BigDecimal getPrecoAnterior();
    BigDecimal getPrecoAtual();
    BigDecimal getAltura();
    BigDecimal getLargura();
    BigDecimal getProfundidade();
    BigDecimal getPeso();
    Boolean getDestaque();
    Boolean getOfertaRelampago();
    String getCategoriaNome();
    String getCaminhoImagem();
    Boolean getAtivo();
    LocalDateTime getDataCadastro();
}