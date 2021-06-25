package com.sgmtec.workshopmongo.resource;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgmtec.workshopmongo.domain.Post;
import com.sgmtec.workshopmongo.resource.util.URL;
import com.sgmtec.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/Posts")
public class PostResource {
	@Autowired
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/titleSearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String Text) {
		Text = URL.decodeParam(Text);
		List<Post> list = service.findByTitle(Text);
		return ResponseEntity.ok().body(list);
	}
}
