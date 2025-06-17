package br.com.future_mob.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.future_mob.model.Pedido;
import br.com.future_mob.model.DTO.PedidoDTO;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query(value = """
        SELECT 
            ped.id_pedido, 
            ped.dt_pedido, 
            ped.subtotal, 
            ped.frete, 
            ped.total, 
            fpag.nome AS formaPagamento, 
            cpag.numero_cartao AS numeroCartao, 
            pag.parcelas, 
            CONCAT(
                ender.logradouro, ', '
                , ender.numero, ' - '
                , ender.complemento, ', '
                , ender.bairro, ' - '
                , ender.cidade, ', '
                , ender.uf) AS endereco, 
            loj.endereco_completo AS enderecoLoja, 
            stt.nome AS statusPedido, 
            ped.dt_entrega, 
            usr.nome_completo, 
            usr.email, 
            usr.telefone_celular
        FROM 
            pedidos AS ped 
            INNER JOIN pagamentos AS pag ON pag.id_pagamento = ped.id_pagamento 
            INNER JOIN formas_pagamento AS fpag ON fpag.id_forma_pagamento = pag.id_forma_pagamento 
            LEFT JOIN cartoes_pagamento AS cpag ON cpag.id_cartao_pagamento = pag.id_cartao_pagamento 
            LEFT JOIN enderecos AS ender ON ender.id_endereco = ped.id_endereco 
            LEFT JOIN lojas AS loj ON loj.id_loja = ped.id_loja 
            INNER JOIN status AS stt ON stt.id_status = ped.id_status 
            INNER JOIN usuarios AS usr ON usr.id_usuario = ped.id_usuario 
        ORDER BY 
            ped.id_pedido DESC
        """, nativeQuery = true)
    List<PedidoDTO> retornarPedidos();
}