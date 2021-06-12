package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;
@Service
public class AuthService implements UserDetailsService {

	@Autowired ClientRepository repoClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		ClientEntity cli = repoClient.findByUsername(username);
		System.out.println(cli);
		if(cli==null) {
			return null;
		}
		
		
		return new UserSS(cli.getId(),cli.getUsername(),cli.getSenha());
	}

}
