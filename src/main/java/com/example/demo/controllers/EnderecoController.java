package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnderecoEntity;
import com.example.demo.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired 
	EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<EnderecoEntity>> findAll () {
		return ResponseEntity.ok().header("Method: ", "Find All").body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<EnderecoEntity> create (@RequestBody EnderecoEntity catObj){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Method: ", "Create");
		EnderecoEntity body = service.create(catObj);
		
		return new ResponseEntity<EnderecoEntity>(body,headers,HttpStatus.CREATED);
	}
	//return new ResponseEntity<TodoEntity>(body, headers, HttpStatus.OK);
	
	@GetMapping("/{id}")
	public Optional<EnderecoEntity> getById(@PathVariable Integer id){
	 
	
	return	service.buscarId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoEntity> update(@PathVariable Integer id, @RequestBody EnderecoEntity catEnt) {
		return ResponseEntity.ok().header("Method: ", "Update").body(service.update(id, catEnt));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok("Deletado com sucesso!");
	}
	
}
