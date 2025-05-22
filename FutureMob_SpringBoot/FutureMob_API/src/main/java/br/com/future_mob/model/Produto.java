package br.com.future_mob.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;
	
	private String nome;	
	private String descricao;
	private float preco_anterior;	
	private float preco_atual;
	private float altura;
	private float largura;
	private float profundidade;
	private float peso;	
	private boolean destaque;
	private boolean oferta_relampago;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;
	
	private String caminho_imagem;		
	private boolean ativo;

	public Produto() { }

	public Produto(
		Integer id_produto
		, String nome
		, String descricao
		, float preco_anterior
		, float preco_atual
		, float altura
		, float largura
		, float profundidade
		, float peso
		, boolean destaque
		, boolean oferta_relampago
		, Categoria id_categoria
		, String caminho_imagem
		, boolean ativo) {
		super();
		
		this.id_produto = id_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.preco_anterior = preco_anterior;
		this.preco_atual = preco_atual;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
		this.peso = peso;
		this.destaque = destaque;
		this.oferta_relampago = oferta_relampago;
		this.id_categoria = id_categoria;
		this.caminho_imagem = caminho_imagem;
		this.ativo = ativo;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
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

	public float getPreco_anterior() {
		return preco_anterior;
	}

	public void setPreco_anterior(float preco_anterior) {
		this.preco_anterior = preco_anterior;
	}

	public float getPreco_atual() {
		return preco_atual;
	}

	public void setPreco_atual(float preco_atual) {
		this.preco_atual = preco_atual;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(float profundidade) {
		this.profundidade = profundidade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isDestaque() {
		return destaque;
	}

	public void setDestaque(boolean destaque) {
		this.destaque = destaque;
	}

	public boolean isOferta_relampago() {
		return oferta_relampago;
	}

	public void setOferta_relampago(boolean oferta_relampago) {
		this.oferta_relampago = oferta_relampago;
	}

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCaminho_imagem() {
		return caminho_imagem;
	}

	public void setCaminho_imagem(String caminho_imagem) {
		this.caminho_imagem = caminho_imagem;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
}