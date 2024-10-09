package com.alexduzi.workshopuserspost.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexduzi.workshopuserspost.domain.Post;
import com.alexduzi.workshopuserspost.resources.util.URL;
import com.alexduzi.workshopuserspost.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		
		Post post = postService.findById(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/titlesearch") // @RequestParam indica que o parametro será um query string
	public ResponseEntity<List<Post>> titlesearch(@RequestParam(value = "text", defaultValue = "") String text) {
		
		text = URL.decodeParam(text);
		
		List<Post> posts = postService.findByTitle(text);
		
		return ResponseEntity.ok().body(posts);
	}
}
