package br.com.future_mob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.future_mob.model.Produto;
import br.com.future_mob.model.DTO.ProdutoDTO;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
    @Query(value = """
        SELECT 
            PRD.id_produto
            , PRD.caminho_imagem
            , PRD.nome
            , PRD.preco_atual
            , PRD.preco_anterior
            , PRD.destaque
            , PRD.oferta_relampago
            , CAT.nome AS categoria
        FROM 
            pedidos_produtos AS PP
            INNER JOIN produtos AS PRD ON PRD.id_produto = PP.id_produto
            INNER JOIN categorias AS CAT ON CAT.id_categoria = PRD.id_categoria
        WHERE
            PP.id_pedido = :idPedido
        """, nativeQuery = true)
    List<ProdutoDTO> retornarProdutosPorPedido(Integer idPedido);
}