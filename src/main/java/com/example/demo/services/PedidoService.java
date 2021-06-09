package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PedidoDTO;
import com.example.demo.entities.PedidoEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.PedidoMapper;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutosPedidosRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	@Autowired
	ProdutosPedidosRepository prodPedRepository;

	@Autowired
	PedidoMapper mapper;

	public List<PedidoDTO> findAll() {
		List<PedidoEntity> list = new ArrayList<>();
		list.addAll(repo.findAll());
		List<PedidoDTO> listDTO = new ArrayList<>();
		for (PedidoEntity pedidoEntity : list) {
			listDTO.add(mapper.toDTO(pedidoEntity));
		}
		return listDTO;
	}

	public PedidoDTO create(PedidoDTO pedDTO) {

		repo.save(mapper.toEntity(pedDTO));
		return pedDTO;
	}

	public PedidoDTO getById(Long id) throws IdNotFoundException {

		if (repo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Id não encontrado!");
		}
		PedidoDTO pedReturn = mapper.toDTO(repo.findById(id).get());

		return pedReturn;
	}

//	public PedidoDTO update(Integer id, PedidoDTO pedEnt) throws IdNotFoundException {
//		PedidoDTO  pedNew = pedEnt;
//		
//		PedidoEntity ped = mapper.toEntity(getById(id));
//		return mapper.toDTO(repo.save(prod));
//	}

	public void delete(Long id) throws IdNotFoundException {
		getById(id);
		repo.deleteById(id);
	}
}
