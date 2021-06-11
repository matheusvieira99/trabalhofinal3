package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.CategoriaEntity;


public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

	@Transactional
	@Query("SELECT DISTINCT obj FROM CategoriaEntity obj WHERE obj.nome LIKE %:nome%")
	Page<CategoriaEntity> search (@Param("nome") String nome,Pageable pageRequest);

}
