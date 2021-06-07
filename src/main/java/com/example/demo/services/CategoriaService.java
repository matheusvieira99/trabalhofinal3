package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CategoriaEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	public List<CategoriaEntity> findAll(){
		return repo.findAll();
	}
	
	public CategoriaEntity create(CategoriaEntity catObj) throws IdNotFoundException  {
	
		return repo.save(catObj);
	}

	public Optional<CategoriaEntity> buscarId(Integer id) throws IdNotFoundException {
	Optional<CategoriaEntity> catReturn = repo.findById(id);
		if(catReturn.isEmpty()) {
			throw new IdNotFoundException ("Id não encontrado!");
		}
	
		return catReturn;
	}

	public CategoriaEntity update(Integer id, CategoriaEntity catEnt) throws IdNotFoundException  {
		CategoriaEntity  catNew = catEnt;
		
		CategoriaEntity cat = repo.getById(id);
		
		if(catNew.getNome() != null) {
			cat.setNome(catNew.getNome());
		}
		
		if(catNew.getDescricao()!= null) {
			cat.setDescricao(catNew.getDescricao());
		}
		
		return repo.save(cat);
	}

	public void delete(Integer id) throws IdNotFoundException  {
		repo.deleteById(id);
	}
	
}
