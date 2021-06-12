package com.example.demo.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Integer preco;
	
	private Integer quantidadeEmEstoque;
	
	private LocalDate dataCadastro;
	
	private byte[] imagem;
	
	@JsonBackReference
	private Integer codigoCategoria;
	
//	@JsonIgnore
	@OneToMany(mappedBy="produtoItem")
	private Set<ProdutosPedidos> itemPedido = new HashSet<>();
	
//	@GeneratedValue(strategy=GenerationType.TABLE)

	@ManyToOne
	@JsonIgnore
	private CategoriaEntity categoria;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] bs) {
		this.imagem = bs;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Set<ProdutosPedidos> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(Set<ProdutosPedidos> itemPedido) {
		this.itemPedido = itemPedido;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n Preco=" + preco;
	}




	
	
}
