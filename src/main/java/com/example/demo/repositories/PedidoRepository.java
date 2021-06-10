package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	List<PedidoEntity> findByClienteId(Integer id);

}
