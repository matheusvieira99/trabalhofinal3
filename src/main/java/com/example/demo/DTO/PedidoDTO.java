package com.example.demo.DTO;

import java.time.LocalDate;

import com.example.demo.entities.ClientEntity;

public class PedidoDTO {
	
	
	private Long id;
	
	private Long numeroDoPedido;
	
	private Double valorTotalDoPedido;
	
	private LocalDate dataDoPedido;
	
	private LocalDate dataDaEntrega;
	
	private String status;
	
	private ClientEntity cliente;

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
	
	

}
