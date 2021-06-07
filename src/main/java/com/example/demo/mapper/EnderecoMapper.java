package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.EnderecoDTO;
import com.example.demo.entities.EnderecoEntity;

@Component
public class EnderecoMapper {
	
	public EnderecoDTO toDTO (EnderecoEntity entity) {
		EnderecoDTO dto = new EnderecoDTO();
		
		dto.setRua(entity.getRua());
		dto.setBairro(entity.getBairro());
		dto.setNumero(entity.getNumero());
		dto.setCidade(entity.getCidade());
		dto.setComplemento(entity.getComplemento());
		dto.setEstado(entity.getEstado());
		dto.setClient(entity.getCliente());
		dto.setCep(entity.getCep());
		return dto;
	}
	
	public EnderecoEntity toEntity(EnderecoDTO dto) {
		EnderecoEntity entity = new EnderecoEntity();
		
		entity.setNumero(dto.getNumero());
		entity.setComplemento(dto.getComplemento());
		entity.setCliente(dto.getClient());
		return entity;
	}

}
