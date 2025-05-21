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
	private MusicaRepository repM;

	@Cacheable(value = "TodasMusicasCacheable")
	public List<Musica> findAll() {
		return repM.findAll();
	}
	
	@Cacheable(value = "MusicasPorSubstring", 
			key = "#substring")
	public List<ProdutoSubstringProjection> 
	buscaPorSubstring(String substring){
		return repM.buscaPorSubstring(substring);
	}

	@CacheEvict(value = { "TodasMusicasCacheable",
			"MusicasPorSubstring"},
			allEntries = true)
	public void removerCache() {
		System.out.println("Removendo cache!");
	}

}
