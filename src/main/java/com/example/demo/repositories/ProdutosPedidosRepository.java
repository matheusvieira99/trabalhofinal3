package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ProdutosPedidos;

public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos, Long>{

}
