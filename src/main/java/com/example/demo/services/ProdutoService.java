package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.ProdutoMapper;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	CategoriaRepository repoCategoria;
	
	@Autowired
	ProdutoMapper mapper;
	
	
	public List<ProdutoDTO> findAll(){
		List<ProdutoEntity> list = new ArrayList<>();
		list.addAll(repo.findAll());
		List<ProdutoDTO> listDTO = new ArrayList<>();
		for (ProdutoEntity produtoEntity : list) {
			listDTO.add(mapper.toDTO(produtoEntity));
		}
		return listDTO;
	}
	
	public ProdutoDTO create(ProdutoDTO prodDTO) {
		prodDTO.setCategoria(repoCategoria.getById(prodDTO.getCodigoCategoria()));
		repo.save(mapper.toEntity(prodDTO));
		return prodDTO;
	}

	public ProdutoDTO getById(Integer id) throws IdNotFoundException {
		
		if(repo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Id não encontrado!");
		}
		ProdutoDTO prodReturn = mapper.toDTO(repo.findById(id).get());
		
		return prodReturn;
	}

	public ProdutoDTO update(Integer id, ProdutoDTO prodEnt) throws IdNotFoundException {
		ProdutoDTO  prodNew = prodEnt;
		
		ProdutoEntity prod = mapper.toEntity(getById(id));
		
		if(prodNew.getNome() != null) {
			prod.setNome(prodNew.getNome());
		}
		
		if(prodNew.getDescricao()!= null) {
			prod.setDescricao(prodNew.getDescricao());
		}
		return mapper.toDTO(repo.save(prod));
	}

	public void delete(Integer id) throws IdNotFoundException {
		getById(id);
		repo.deleteById(id);
	}
}
