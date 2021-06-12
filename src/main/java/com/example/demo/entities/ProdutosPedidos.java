package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ProdutosPedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private ProdutoEntity produtoItem;
	
	@ManyToOne
	private PedidoEntity pedido;
	
	private Integer quantidade;
	
	private Double preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public ProdutoEntity getProduto() {
		return produtoItem;
	}

	public void setProduto(ProdutoEntity produtoItem) {
		this.produtoItem = produtoItem;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "ProdutosPedidos [id=" + id + ", produtoItem=" + produtoItem + ", pedido=" + pedido + ", quantidade="
				+ quantidade + ", preco=" + preco + "]";
	}
	
	

}
