package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTO.ClientDTO;
import com.example.demo.entities.ClientEntity;
import com.example.demo.entities.EnderecoEntity;
import com.example.demo.exceptions.IdNotFoundException;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.EnderecoRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repo;
	
	@Autowired
	ClientMapper mapper;
	
	@Autowired
	EnderecoRepository enderecoRepo;
	
	@Value("${address.baseUrl}")
	String baseUrl;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	EnderecoService enderecoService;
	

	
	public List<ClientDTO> findAll(){
		List<ClientEntity> list = new ArrayList<>();
		list.addAll(repo.findAll());
		
		List<ClientDTO> listDTO = new ArrayList<>();

		for (ClientEntity clientEntity : list) {
			listDTO.add(mapper.toDTO(clientEntity));
		}		
		return listDTO;
	}
	
	public ClientDTO create(ClientDTO cliObj) {
	
		ClientEntity cliEnt = new ClientEntity();
		
		
	
		
		cliEnt = mapper.toEntity(cliObj);
		
		
		
		
		return mapper.toDTO(repo.save(cliEnt));
		
		
	}

	public ClientDTO buscarId(Integer id) throws IdNotFoundException {
		ClientDTO cliReturn = mapper.toDTO(repo.findById(id).get());
		
		if(repo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Id não encontrado!");
		}
		
		return cliReturn;
	}

	public ClientDTO update(Integer id, ClientDTO catDTO) throws IdNotFoundException {
		buscarId(id);
		
	

		if(catDTO.getTelefone()!= null) {
//			cat.setTelefone(catEnt.getTelefone());
			repo.findById(id).get().setTelefone(catDTO.getTelefone());
			repo.save(repo.findById(id).get());
		}
		
		if(catDTO.getNome()!=null) {
			repo.findById(id).get().setNome(catDTO.getNome());
			repo.save(repo.findById(id).get());
		}
		if(catDTO.getEmail()!=null) {
			repo.findById(id).get().setEmail(catDTO.getEmail());
			repo.save(repo.findById(id).get());
		}
		
		if(catDTO.getUsername()!=null) {
			repo.findById(id).get().setUsername(catDTO.getUsername());
			repo.save(repo.findById(id).get());
		}
		
		if(catDTO.getSenha()!=null) {
			repo.findById(id).get().setSenha(catDTO.getSenha());
			repo.save(repo.findById(id).get());
		}
		
		if(catDTO.getDataNascimento()!=null) {
			repo.findById(id).get().setDataNascimento(catDTO.getDataNascimento());
			repo.save(repo.findById(id).get());
		}
//		if(catDTO.getEnderecoId() != null) {
//			ViaCepDTO viaCEP =  restTemplate.getForObject(baseUrl + catDTO.getEnderecoId().get(0).getCep() + "/json", ViaCepDTO.class);
//			
//			enderecoRepo.findById(id).get().setCidade(viaCEP.getLocalidade());
//			enderecoRepo.findById(id).get().setBairro(viaCEP.getBairro());
//			enderecoRepo.findById(id).get().setEstado(viaCEP.getUf());
//			enderecoRepo.findById(id).get().setRua(viaCEP.getLogradouro());
//			enderecoRepo.findById(id).get().setCep(viaCEP.getCep());
//			
//			enderecoRepo.findById(id).get().setComplemento(catDTO.getEnderecoId().get(0).getComplemento());
//			enderecoRepo.findById(id).get().setNumero(catDTO.getEnderecoId().get(0).getNumero());
//		
//			
//			enderecoRepo.save(enderecoRepo.findById(id).get());
//			
//			List<EnderecoEntity> list = new ArrayList<>();
//			list.add(enderecoRepo.findById(id).get());
//			
//			repo.findById(id).get().setEnderecoId(list);
//			repo.save(repo.findById(id).get()); 
//		}
		
		return mapper.toDTO(repo.findById(id).get());
	}

	public void delete(Integer id) throws IdNotFoundException {
		buscarId(id);
	List<EnderecoEntity> list =	enderecoRepo.findByClientId(id);
	
	for (EnderecoEntity enderecoEntity : list) {
		enderecoRepo.delete(enderecoEntity);
	}
	
		repo.deleteById(id);
	}
	
	
	
	
	
	

}
