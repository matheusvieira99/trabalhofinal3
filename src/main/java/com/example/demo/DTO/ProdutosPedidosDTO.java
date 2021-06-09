package com.example.demo.DTO;

import com.example.demo.entities.PedidoEntity;
import com.example.demo.entities.ProdutoEntity;

public class ProdutosPedidosDTO {

	private Long id;

	private ProdutoEntity produtoItem;

	private PedidoEntity pedido;

	private Integer quantidade;

	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public ProdutoEntity getProdutoItem() {
		return produtoItem;
	}

	public void setProdutoItem(ProdutoEntity produtoItem) {
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

}
