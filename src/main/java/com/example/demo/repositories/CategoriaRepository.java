package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CategoriaEntity;


public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

}
