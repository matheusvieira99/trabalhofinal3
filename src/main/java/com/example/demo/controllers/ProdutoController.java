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

import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
		
		@Autowired 
		ProdutoService service;
		
		@GetMapping
		public ResponseEntity<List<ProdutoDTO>> findAll () {
			return ResponseEntity.ok().header("Method: ", "Find All").body(service.findAll());
		}
		
		@PostMapping
		public ResponseEntity<ProdutoDTO> create (@RequestBody ProdutoDTO prodObj){
			HttpHeaders headers = new HttpHeaders();
			headers.add("Method: ", "Create");
			ProdutoDTO body = service.create(prodObj);
			
			return new ResponseEntity<ProdutoDTO>(body,headers,HttpStatus.CREATED);
		}

		@GetMapping("/{id}")
		public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) throws IdNotFoundException{
			return ResponseEntity.ok().header("Method: ", "Get By Id").body(service.getById(id));
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id, @RequestBody ProdutoDTO prodEnt) throws IdNotFoundException {
			return ResponseEntity.ok().header("Method: ", "Update").body(service.update(id, prodEnt));
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> delete(@PathVariable Integer id) throws IdNotFoundException {
			service.delete(id);
			return ResponseEntity.ok("Deletado com sucesso!");
		}

}
