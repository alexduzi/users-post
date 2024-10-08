package com.alexduzi.workshopuserspost.services;

import java.time.LocalDate;
import java.util.List;

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
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
		maxDate = maxDate.plusDays(1);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
