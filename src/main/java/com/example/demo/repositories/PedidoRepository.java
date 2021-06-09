package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
