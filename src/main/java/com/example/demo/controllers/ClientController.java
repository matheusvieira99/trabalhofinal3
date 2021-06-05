package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ClientEntity;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/cliente")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping
	public void create (@RequestBody ClientEntity cliente) {
		clientService.create(cliente);
	}
	
	@GetMapping
	public List<ClientEntity> getAll(){
		return clientService.getAll();
	}
	

	
	
	
	

}
