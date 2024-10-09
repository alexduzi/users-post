package com.alexduzi.workshopuserspost.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexduzi.workshopuserspost.domain.Post;
import com.alexduzi.workshopuserspost.repository.PostRepository;
import com.alexduzi.workshopuserspost.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		if (!repository.findById(id).isPresent()) {
			throw new ObjectNotFoundException("Post not found!");
		}
		
		return repository.findById(id).get();
	}
}
