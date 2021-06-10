package com.example.demo.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.PedidoDTO;
import com.example.demo.DTO.ProdutosPedidosDTO;
import com.example.demo.entities.PedidoEntity;
import com.example.demo.entities.ProdutosPedidos;

@Component
public class PedidoMapper {
	
	@Autowired
	ProdutosPedidosMapper mapper;
	
	public PedidoDTO toDTO(PedidoEntity obj) {
		PedidoDTO dto = new PedidoDTO();
		
		dto.setNumeroDoPedido(obj.getNumeroDoPedido());
		dto.setValorTotalDoPedido(obj.getValorTotalDoPedido());
		dto.setDataDoPedido(obj.getDataDoPedido());
		dto.setDataDaEntrega(obj.getDataDaEntrega());
		dto.setStatus(obj.getStatus());
		dto.setCliente(obj.getCliente());
		Set<ProdutosPedidos> listProd = obj.getListaProdutos();
		Set<ProdutosPedidosDTO> listProdDTO = new HashSet<>();
		for (ProdutosPedidos produtosPedidos : listProd) {
			listProdDTO.add(mapper.toDTO(produtosPedidos));
		}
		dto.setListaProdutos(listProdDTO);		
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
		Set<ProdutosPedidosDTO> listDTO = dto.getListaProdutos();
		Set<ProdutosPedidos> list = new HashSet<>();
		for (ProdutosPedidosDTO produtosPedidosDTO : listDTO) {
			list.add(mapper.toEntity(produtosPedidosDTO));
		}
		entity.setListaProdutos(list);
		
		return entity;
	}

}
