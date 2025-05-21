package br.com.future_mob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.future_mob.model.Produto;
import br.com.future_mob.projections.ProdutoSubstringProjection;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{	
	@Query("FROM produtos prod")
	public List<Produto> retornarTodos();

	@Query(nativeQuery = true, value = 
	"select mus.nome nome_musica, band.nome nome_banda, mus.genero genero_musica, mus.duracao duracao_musica "
	+ "from musica mus inner join banda band on (mus.fk_banda = band.id) "
	+ "where (mus.nome ilike concat('%',:sub,'%')) or (band.nome ilike concat('%',:sub,'%'))")
	public List<ProdutoSubstringProjection> 
	buscaPorSubstring(String sub);
}