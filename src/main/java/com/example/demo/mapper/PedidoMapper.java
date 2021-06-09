package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.PedidoDTO;
import com.example.demo.entities.PedidoEntity;

@Component
public class PedidoMapper {
	
	public PedidoDTO toDTO(PedidoEntity obj) {
		PedidoDTO dto = new PedidoDTO();
		
		dto.setNumeroDoPedido(obj.getNumeroDoPedido());
		dto.setValorTotalDoPedido(obj.getValorTotalDoPedido());
		dto.setDataDoPedido(obj.getDataDoPedido());
		dto.setDataDaEntrega(obj.getDataDaEntrega());
		dto.setStatus(obj.getStatus());
		dto.setCliente(obj.getCliente());
//		dto.set - Lista Produtos -
		
		return dto;
	}
	
	public PedidoEntity toEntity(PedidoDTO dto) {
		PedidoEntity entity = new PedidoEntity();
		
		entity.setNumeroDoPedido(dto.getNumeroDoPedido());
		entity.setValorTotalDoPedido(dto.getValorTotalDoPedido());
		entity.setDataDoPedido(dto.getDataDoPedido());
		entity.setDataDaEntrega(dto.getDataDaEntrega());
		entity.setStatus(dto.getStatus());
		entity.setCliente(dto.getCliente());
//		entity.set - Lista Protudos -
		
		return entity;
	}

}
