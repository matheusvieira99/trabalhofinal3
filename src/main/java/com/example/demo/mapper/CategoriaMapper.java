package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.entities.CategoriaEntity;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.repositories.ProdutoRepository;

@Component
public class CategoriaMapper {
	
	@Autowired 
	ProdutoRepository produtoRepo;
	
	@Autowired
	ProdutoMapper mapper;
	
	
	public CategoriaDTO toDTO(CategoriaEntity catEnt) {
		CategoriaDTO dto = new CategoriaDTO();
		
		dto.setNome(catEnt.getNome());
		dto.setDescricao(catEnt.getDescricao());
		
		List<ProdutoEntity> listEnt = produtoRepo.findAll();
		List<ProdutoDTO> listDTO = new ArrayList<>();
		for (ProdutoEntity prodEnt : listEnt) {
			listDTO.add(mapper.toDTO(prodEnt));
		}
		dto.setProdutos(listDTO);
		return dto;
	}
	
	public CategoriaEntity toEntity(CategoriaDTO dto) {
		CategoriaEntity entity = new CategoriaEntity();
		
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
	
		
		return entity;
		
	}

}
