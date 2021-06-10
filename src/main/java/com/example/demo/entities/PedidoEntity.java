package com.example.demo.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class PedidoEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private Long numeroDoPedido;
		
		private Double valorTotalDoPedido;
		
		private LocalDate dataDoPedido;
		
		private LocalDate dataDaEntrega;
		
		private String status;
		
		@ManyToOne
		private ClientEntity cliente;
		
		@OneToMany(mappedBy="pedido")
		private Set<ProdutosPedidos> listaProdutos = new HashSet<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getNumeroDoPedido() {
			return numeroDoPedido;
		}

		public void setNumeroDoPedido(Long numeroDoPedido) {
			this.numeroDoPedido = numeroDoPedido;
		}

		public Double getValorTotalDoPedido() {
			return valorTotalDoPedido;
		}

		public void setValorTotalDoPedido(Double valorTotalDoPedido) {
			this.valorTotalDoPedido = valorTotalDoPedido;
		}

		public LocalDate getDataDoPedido() {
			return dataDoPedido;
		}

		public void setDataDoPedido(LocalDate dataDoPedido) {
			this.dataDoPedido = dataDoPedido;
		}

		public LocalDate getDataDaEntrega() {
			return dataDaEntrega;
		}

		public void setDataDaEntrega(LocalDate dataDaEntrega) {
			this.dataDaEntrega = dataDaEntrega;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public ClientEntity getCliente() {
			return cliente;
		}

		public void setCliente(ClientEntity cliente) {
			this.cliente = cliente;
		}

		public Set<ProdutosPedidos> getListaProdutos() {
			return listaProdutos;
		}

		public void setListaProdutos(Set<ProdutosPedidos> listaProdutos) {
			this.listaProdutos = listaProdutos;
		}

	
		
		
		
}
