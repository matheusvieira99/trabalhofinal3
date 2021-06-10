package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.entities.EnderecoEntity;

public class ClientDTO {


	
	private String email;
	
	private String username;
	
	private Integer senha;
	
	private String nome;
	
	private String cpf;
	
	private Integer telefone;
	
	private LocalDate dataNascimento;
	
	
	
	
	private List<EnderecoDTO> enderecoId = new ArrayList<>();





	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getSenha() {
		return senha;
	}


	public void setSenha(Integer senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getTelefone() {
		return telefone;
	}


	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<EnderecoDTO> getEnderecoId() {
		return enderecoId;
	}


	public void setEnderecoId(List<EnderecoDTO> enderecoId) {
		this.enderecoId = enderecoId;
	}
	
	
}
