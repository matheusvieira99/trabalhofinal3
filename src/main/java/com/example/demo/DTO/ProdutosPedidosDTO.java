package com.example.demo.DTO;

public class ProdutosPedidosDTO {

	private Integer id;

//	private ProdutoEntity produtoItem;
//
//	private PedidoEntity pedido;

	private Integer quantidade;

	private Double preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



//	public ProdutoEntity getProdutoItem() {
//		return produtoItem;
//	}
//
//	public void setProdutoItem(ProdutoEntity produtoItem) {
//		this.produtoItem = produtoItem;
//	}
//
//	public PedidoEntity getPedido() {
//		return pedido;
//	}
//
//	public void setPedido(PedidoEntity pedido) {
//		this.pedido = pedido;
//	}

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
