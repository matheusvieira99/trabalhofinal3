package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.EnderecoEntity;
import com.example.demo.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository repo;
	
	public List<EnderecoEntity> findAll(){
		return repo.findAll();
	}
	
	public EnderecoEntity create(EnderecoEntity catObj) {
	
		return repo.save(catObj);
	}

	public Optional<EnderecoEntity> buscarId(Integer id) {
		Optional<EnderecoEntity> cliReturn = repo.findById(id);
		return cliReturn;
	}

	public EnderecoEntity update(Integer id, EnderecoEntity endEnt) {
		EnderecoEntity  endNew = endEnt;
		
		EnderecoEntity end = repo.getById(id);
		
		if(endNew.getRua() != null) {
			end.setRua(endNew.getRua());
		}
		
		if(endNew.getBairro()!= null) {
			end.setBairro(endNew.getRua());
		}
		
		if(endNew.getCidade() != null) {
			end.setCidade(endNew.getCidade());
		}
		
		if(endNew.getComplemento() != null) {
			end.setComplemento(endNew.getComplemento());
		}
		if(endNew.getCep() != null) {
			end.setCep(endNew.getCep());
		}
		if(endNew.getEstado() != null) {
			end.setEstado(endNew.getEstado());
		}
		
		
		
		return repo.save(end);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
