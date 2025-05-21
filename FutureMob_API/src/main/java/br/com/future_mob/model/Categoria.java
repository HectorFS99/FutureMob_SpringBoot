package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	
	private String nome;
	private String descricao;
	private String caminho_icone;

	public Categoria() { }

	public Categoria(
		Integer id_categoria
		, String nome
		, String descricao
		, String caminho_icone) {
		super();
		
		this.id_categoria = id_categoria;
		this.nome = nome;
		this.descricao = descricao;
		this.caminho_icone = caminho_icone;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminho_icone() {
		return caminho_icone;
	}

	public void setCaminho_icone(String caminho_icone) {
		this.caminho_icone = caminho_icone;
	}	
}