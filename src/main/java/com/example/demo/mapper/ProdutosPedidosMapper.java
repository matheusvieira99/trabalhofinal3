package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ProdutosPedidosDTO;
import com.example.demo.entities.ProdutosPedidos;

@Component
public class ProdutosPedidosMapper {
	
	public ProdutosPedidosDTO toDTO(ProdutosPedidos prodPedEnt) {
		ProdutosPedidosDTO dto = new ProdutosPedidosDTO();
		
//		dto.setPedido(prodPedEnt.getPedido());
//		dto.setProdutoItem(prodPedEnt.getProduto());
		dto.setId(prodPedEnt.getId());
		dto.setQuantidade(prodPedEnt.getQuantidade());
		dto.setPreco(prodPedEnt.getPreco());
		return dto;
	}
	
	public ProdutosPedidos toEntity(ProdutosPedidosDTO dto) {
		ProdutosPedidos entity = new ProdutosPedidos();
		
//		entity.setPedido(dto.getPedido());
//		entity.setProduto(dto.getProdutoItem());
		entity.setId(dto.getId());
		entity.setQuantidade(dto.getQuantidade());
		entity.setPreco(dto.getPreco());
		return entity;
		
		
	}

}
