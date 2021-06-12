package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.DTO.EnderecoDTO;
import com.example.demo.entities.ClientEntity;
import com.example.demo.entities.EnderecoEntity;



@Component
public class ClientMapper {
	
	@Autowired EnderecoMapper mapper;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	public ClientDTO toDTO (ClientEntity entity) {
		ClientDTO dto = new ClientDTO();
		
		dto.setNome(entity.getNome());
		dto.setUsername(entity.getUsername());
		dto.setSenha(entity.getSenha());
		dto.setTelefone(entity.getTelefone());
		List<EnderecoEntity> listEnt = entity.getEnderecoId();
		List<EnderecoDTO> listDTO = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : listEnt) {
			listDTO.add(mapper.toDTO(enderecoEntity));
		}
		dto.setEnderecoId(listDTO);
		
		dto.setDataNascimento(entity.getDataNascimento());
		dto.setCpf(entity.getCpf());
		dto.setEmail(entity.getEmail());
		return dto;
		
	}
	
	public ClientEntity toEntity (ClientDTO dto) {
		ClientEntity entity = new ClientEntity();
		
		entity.setNome(dto.getNome());
		entity.setUsername(dto.getUsername());
		entity.setSenha(bCrypt.encode(dto.getSenha()));
		entity.setTelefone(dto.getTelefone());
		
		
//		entity.setEnderecoId(dto.getEnderecoId());
		/*
		 * List<EnderecoDTO> listDTO = ;
		List<EnderecoDTO> listDTO = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : listEnt) {
			listDTO.add(mapper.toDTO(enderecoEntity));
		}
		dto.setEnderecoId(listDTO);*/
		
		
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}

}
