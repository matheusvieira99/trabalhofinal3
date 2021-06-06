package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repo;
	
	public List<ClientEntity> findAll(){
		return repo.findAll();
	}
	
	public ClientEntity create(ClientEntity catObj) {
	
		return repo.save(catObj);
	}

	public Optional<ClientEntity> buscarId(Integer id) {
		Optional<ClientEntity> cliReturn = repo.findById(id);
		return cliReturn;
	}

	public ClientEntity update(Integer id, ClientEntity catEnt) {
		ClientEntity  cliNew = catEnt;
		
		ClientEntity cat = repo.getById(id);
		
		if(cliNew.getNome() != null) {
			cat.setNome(cliNew.getNome());
		}
		
		if(cliNew.getTelefone()!= null) {
			cat.setTelefone(cliNew.getTelefone());
		}
		
		if(cliNew.getEmail() != null) {
			cat.setEmail(cliNew.getEmail());
		}
		
		
		return repo.save(cat);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
	
	

}
