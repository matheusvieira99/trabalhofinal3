package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

	@Transactional
	@Query("SELECT DISTINCT obj FROM ProdutoEntity obj WHERE obj.nome LIKE %:nome%")
	Page<ProdutoEntity> search (@Param("nome") String nome,Pageable pageRequest);
	

}