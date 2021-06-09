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

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.entities.CategoriaEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired 
	CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll () {
		return ResponseEntity.ok().header("Method: ", "Find All").body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> create (@RequestBody CategoriaDTO catObj) throws IdNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Method: ", "Create");
		CategoriaDTO body = service.create(catObj);
		
		return new ResponseEntity<CategoriaDTO>(body,headers,HttpStatus.CREATED);
	}
	//return new ResponseEntity<TodoEntity>(body, headers, HttpStatus.OK);
	
	@GetMapping("/{id}")
	public CategoriaDTO getById(@PathVariable Integer id) throws IdNotFoundException{
	 
	
	return	service.buscarId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO catEnt) throws IdNotFoundException {
		return ResponseEntity.ok().header("Method: ", "Update").body(service.update(id, catEnt));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) throws IdNotFoundException {
		service.delete(id);
		return ResponseEntity.ok("Deletado com sucesso!");
	}

	
}
