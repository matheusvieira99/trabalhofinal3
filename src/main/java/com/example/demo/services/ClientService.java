package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.entities.ClientEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repo;
	
	@Autowired
	ClientMapper mapper;
	
	public List<ClientDTO> findAll(){
		List<ClientEntity> list = new ArrayList<>();
		list.addAll(repo.findAll());
		
		List<ClientDTO> listDTO = new ArrayList<>();

		for (ClientEntity clientEntity : list) {
			listDTO.add(mapper.toDTO(clientEntity));
		}		
		return listDTO;
	}
	
	public ClientDTO create(ClientDTO cliObj) {
	
		ClientEntity cliEnt = new ClientEntity();
		cliEnt = mapper.toEntity(cliObj);
		
		
		
		return mapper.toDTO(repo.save(cliEnt));
		
		
	}

	public ClientDTO buscarId(Integer id) throws IdNotFoundException {
		ClientDTO cliReturn = mapper.toDTO(repo.findById(id).get());
		
		if(repo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Id não encontrado!");
		}
		
		return cliReturn;
	}

	public ClientDTO update(Integer id, ClientDTO catEnt) throws IdNotFoundException {
		ClientDTO  cliNew = catEnt;
		
		ClientEntity cat = mapper.toEntity(buscarId(id));
		
		if(cliNew.getNome() != null) {
			cat.setNome(cliNew.getNome());
		}
		
		if(cliNew.getTelefone()!= null) {
			cat.setTelefone(cliNew.getTelefone());
		}
		
		if(cliNew.getEmail() != null) {
			cat.setEmail(cliNew.getEmail());
		}
		return mapper.toDTO(repo.save(cat));
	}

	public void delete(Integer id) throws IdNotFoundException {
		buscarId(id);
		repo.deleteById(id);
	}
	
	
	
	

}
