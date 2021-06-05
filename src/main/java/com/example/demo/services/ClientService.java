package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public void create (ClientEntity Client) {
		clientRepository.save(Client);
	}

	public List<ClientEntity> getAll() {
		return clientRepository.findAll();
	
	}
	
	
	
	

}
