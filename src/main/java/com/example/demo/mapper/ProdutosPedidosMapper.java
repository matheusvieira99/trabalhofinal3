package com.example.demo.mapper;

import com.example.demo.DTO.ProdutosPedidosDTO;
import com.example.demo.entities.ProdutosPedidos;

public class ProdutosPedidosMapper {
	
	public ProdutosPedidosDTO toDTO(ProdutosPedidos prodPedEnt) {
		ProdutosPedidosDTO dto = new ProdutosPedidosDTO();
		
		dto.setPedido(prodPedEnt.getPedido());
		dto.setProdutoItem(prodPedEnt.getProduto());
		dto.setQuantidade(prodPedEnt.getQuantidade());
		dto.setPreco(prodPedEnt.getPreco());
		return dto;
	}
	
	public ProdutosPedidos toEntity(ProdutosPedidosDTO dto) {
		ProdutosPedidos entity = new ProdutosPedidos();
		
		entity.setPedido(dto.getPedido());
		entity.setProduto(dto.getProdutoItem());
		entity.setQuantidade(dto.getQuantidade());
		entity.setPreco(dto.getPreco());
		return entity;
		
		
	}

}
