package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CategoriaEntity;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	CategoriaRepository repoCategoria;
	
	
	public List<ProdutoEntity> findAll(){
		return repo.findAll();
	}
	
	public ProdutoEntity create(ProdutoEntity prodObj) {
		prodObj.setCategoria(repoCategoria.getById(prodObj.getCodigoCategoria()));
		
		
		
		return repo.save(prodObj);
	}

	public Optional<ProdutoEntity> getById(Integer id) {
		Optional<ProdutoEntity> prodReturn = repo.findById(id);
		return prodReturn;
	}

	public ProdutoEntity update(Integer id, ProdutoEntity catEnt) {
		ProdutoEntity  catNew = catEnt;
		
		ProdutoEntity cat = repo.getById(id);
		
		if(catNew.getNome() != null) {
			cat.setNome(catNew.getNome());
		}
		
		if(catNew.getDescricao()!= null) {
			cat.setDescricao(catNew.getDescricao());
		}
		
		return repo.save(cat);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
