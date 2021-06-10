package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PedidoDTO;
import com.example.demo.DTO.ProdutosPedidosDTO;
import com.example.demo.config.MailConfig;
import com.example.demo.entities.PedidoEntity;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.entities.ProdutosPedidos;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.PedidoMapper;
import com.example.demo.mapper.ProdutoMapper;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.ProdutosPedidosRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	@Autowired
	ProdutosPedidosRepository prodPedRepository;
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	@Autowired
	ProdutoService serviceProduto;
	
	@Autowired
	ProdutoMapper mapperProd;
	

	@Autowired
	PedidoMapper mapper;
	
	@Autowired 
	ProdutoMapper produtoMapper;
	
	@Autowired
	MailConfig send;

	public List<PedidoDTO> findAll() {
		List<PedidoEntity> list = new ArrayList<>();
		list.addAll(repo.findAll());
		List<PedidoDTO> listDTO = new ArrayList<>();
		for (PedidoEntity pedidoEntity : list) {
			listDTO.add(mapper.toDTO(pedidoEntity));
		}
		return listDTO;
	}

	public PedidoDTO createPedido(PedidoDTO pedDTO, Integer id) throws IdNotFoundException {
		pedDTO.setCliente(clientRepo.findById(id).get());
		PedidoEntity pedidoSaved = repo.save(mapper.toEntity(pedDTO));
		
		for (ProdutosPedidosDTO produto : pedDTO.getListaProdutos()) {
			System.out.println(produto.toString());
			//criar metodo para dentro da API getBYid retornando a entidade;
			ProdutoEntity produtoFind =mapperProd.toEntity(serviceProduto.getById(produto.getId()));
			produtoFind.setId(produto.getId());
			ProdutosPedidos prodPed = new ProdutosPedidos();
			prodPed.setPedido(pedidoSaved);
			prodPed.setPreco((double)produtoFind.getPreco());
			prodPed.setProduto(produtoFind);
			prodPed.setQuantidade(produto.getQuantidade());
			System.out.println(produtoFind);
			prodPedRepository.save(prodPed);
		}
		
		send.sendMail("falmeida.1305@gmail.com", "Trabalho", "Pedido cadastrado com sucesso!");
				
			
		
		
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

	public List<PedidoDTO> findAllById(Integer id) {
		List<PedidoEntity> list = repo.findByClienteId(id);
		List<PedidoDTO> listDTO = new ArrayList<>();
		for (PedidoEntity pedidoEntity : list) {
			listDTO.add(mapper.toDTO(pedidoEntity));
		}
		
		
		
		return listDTO;
		
		
	}
}
