package br.com.future_mob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.future_mob.model.Produto;
import br.com.future_mob.projections.ProdutoSubstringProjection;
import br.com.future_mob.repository.ProdutoRepository;

@Service
public class CachingService {
	@Autowired
	private ProdutoRepository rep;

	@Cacheable(value = "TodosProdutosCacheable")
	public List<Produto> findAll() {
		return rep.findAll();
	}
	
	@Cacheable(value = "ProdutosPorSubstring", key = "#substring")
	public List<ProdutoSubstringProjection> buscaPorSubstring(String substring){
		return rep.buscaPorSubstring(substring);
	}

	@CacheEvict(value = { "TodosProdutosCacheable", "ProdutosPorSubstring" }, allEntries = true)
	public void removerCache() {
		System.out.println("Removendo cache!");
	}
}