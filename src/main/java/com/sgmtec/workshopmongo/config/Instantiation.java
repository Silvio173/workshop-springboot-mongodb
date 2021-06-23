package com.sgmtec.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sgmtec.workshopmongo.domain.User;
import com.sgmtec.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User zelito = new User(null, "Zelito Santos", "zelito173@gmail.com");
		User maysa = new User(null, "Maysa Ramos", "maysa173@gmail.com");
		User leo = new User(null, "Leonardo Ramos", "leo173@gmail.com");
			
		userRepository.saveAll(Arrays.asList(zelito,maysa,leo));	
	}

}
