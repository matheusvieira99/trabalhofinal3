package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTO.EnderecoDTO;
import com.example.demo.DTO.ViaCepDTO;
import com.example.demo.entities.EnderecoEntity;
import com.example.demo.mapper.EnderecoMapper;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository repo;
	
	@Autowired
	ClientRepository repoClient;
	
	@Autowired
	EnderecoMapper mapper;
	
	@Value("${address.baseUrl}")
	String baseUrl;
	
	@Autowired
	RestTemplate restTemplate;
	

	
	public List<EnderecoDTO> findAll(){
		List<EnderecoEntity> list = new ArrayList<>();
		list.addAll(repo.findAll());
		
		List<EnderecoDTO> listDTO = new ArrayList<>();

		for (EnderecoEntity endEnt : list) {
			listDTO.add(mapper.toDTO(endEnt));
		}
		return listDTO;
		
		
	}
	
	public EnderecoDTO create(String cep, EnderecoDTO catObj) throws HttpClientErrorException {
		
		ViaCepDTO viaCep = restTemplate.getForObject(baseUrl + cep + "/json", ViaCepDTO.class);
		

	
		EnderecoEntity endEnt = new EnderecoEntity();
		
		endEnt.setBairro(viaCep.getBairro());
		endEnt.setCidade(viaCep.getLocalidade());
		endEnt.setRua(viaCep.getLogradouro());
		endEnt.setEstado(viaCep.getUf());
		endEnt.setCep(viaCep.getCep());
		endEnt.setComplemento(catObj.getComplemento());
		endEnt.setCep(catObj.getCep());
		endEnt.setCliente(repoClient.getById(catObj.getCodigoCliente()));
		endEnt.setNumero(catObj.getNumero());
		
		
		repo.save(endEnt);
		
		
		EnderecoDTO dto = mapper.toDTO(repo.getById(endEnt.getId()));
		
		return dto;
		
	}

	public EnderecoDTO buscarId(Integer id) {
		
		EnderecoEntity cliReturn = repo.getById(id);
		EnderecoDTO dto = mapper.toDTO(cliReturn);
		
		return dto;
	}

//	public EnderecoDTO update(Integer id, EnderecoDTO endDTO) {
//		EnderecoDTO  endDTONew = endDTO;
//		
//		EnderecoDTO end = mapper.toDTO(repo.getById(id));
//		
//		
//		if(endDTONew.getRua() != null) {
//			end.setRua(endDTONew.getRua());
//		}
//		
//		if(endDTONew.getBairro()!= null) {
//			end.setBairro(endDTONew.getRua());
//		}
//		
//		if(endDTONew.getCidade() != null) {
//			end.setCidade(endDTONew.getCidade());
//		}
//		
//		if(endDTONew.getComplemento() != null) {
//			end.setComplemento(endDTONew.getComplemento());
//		}
//		if(endDTONew.getCep() != null) {
//			end.setCep(endDTONew.getCep());
//		}
//		if(endDTONew.getEstado() != null) {
//			end.setEstado(endDTONew.getEstado());
//		}
//		
//		repo.save(mapper.toEntity(end));		
//		
//		return end;
//	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
