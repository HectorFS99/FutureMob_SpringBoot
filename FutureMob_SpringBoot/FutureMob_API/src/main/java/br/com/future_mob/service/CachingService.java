package br.com.future_mob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.future_mob.model.*;
import br.com.future_mob.repository.*;

@Service
public class CachingService {
	@Autowired
	private CategoriaRepository catRep;

	@Cacheable(value = "TodasCategoriasCacheable")
	public List<Categoria> retornarCategorias() {
		return catRep.findAll();
	}

	@CacheEvict(value = { "TodasCategoriasCacheable"
		/* COLOCAR AQUI, SEPARADO POR VÍRGULA, VALORES DE CACHE A SEREM LIMPOS */ }, allEntries = true)
	public void removerCache() {
		System.out.println("Removendo cache!");
	}
}