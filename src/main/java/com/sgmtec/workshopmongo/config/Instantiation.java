package com.sgmtec.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sgmtec.workshopmongo.DTO.AuthorDTO;
import com.sgmtec.workshopmongo.domain.Post;
import com.sgmtec.workshopmongo.domain.User;
import com.sgmtec.workshopmongo.repository.PostRepository;
import com.sgmtec.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User zelito = new User(null, "Zelito Santos", "zelito173@gmail.com");
		User maysa = new User(null, "Maysa Ramos", "maysa173@gmail.com");
		User leo = new User(null, "Leonardo Ramos", "leo173@gmail.com");
		userRepository.saveAll(Arrays.asList(zelito,maysa,leo));	

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo abraços", new AuthorDTO(maysa));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maysa));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maysa.getPosts().addAll((Arrays.asList(post1,post2)));
		userRepository.save(maysa);
		
	}

}
