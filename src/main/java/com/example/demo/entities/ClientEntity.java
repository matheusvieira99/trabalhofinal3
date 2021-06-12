package com.example.demo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Email
	private String email;
	
	private String username;
	
	private String senha;
	
	private String nome;
	
	@CPF
	private String cpf;
	
	private Integer telefone;
	@DateTimeFormat
	private LocalDate dataNascimento;
	
	
	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<EnderecoEntity> enderecoId = new ArrayList<>();
	

	@JsonBackReference
	@OneToMany(mappedBy = "cliente")
	private List<PedidoEntity> pedidos = new ArrayList<>();

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
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

	public List<EnderecoEntity> getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(List<EnderecoEntity> enderecoId) {
		this.enderecoId = enderecoId;
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", email=" + email + ", username=" + username + ", senha=" + senha + ", nome="
				+ nome + ", cpf=" + cpf + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento
				+ ", enderecoId=" + ", pedidos=" + "]";
	}

	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}


	

	
	

}
