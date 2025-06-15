package br.com.future_mob.model.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PedidoDTO {
    Integer getId_pedido();
    LocalDateTime getDt_pedido();
    BigDecimal getSubtotal();
    BigDecimal getFrete();
    BigDecimal getTotal();
    String getFormaPagamento();
    String getNumeroCartao();
    Integer getParcelas();
    String getEndereco();
    String getEnderecoLoja();
    String getStatusPedido();
    LocalDate getDtEntrega();
    String getNomeCompleto();
    String getEmail();
    String getTelefoneCelular();
}