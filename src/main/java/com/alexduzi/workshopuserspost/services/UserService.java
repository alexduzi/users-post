package com.alexduzi.workshopuserspost.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexduzi.workshopuserspost.domain.User;
import com.alexduzi.workshopuserspost.dto.UserDTO;
import com.alexduzi.workshopuserspost.repository.UserRepository;
import com.alexduzi.workshopuserspost.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		if (!repository.findById(id).isPresent()) {
			throw new ObjectNotFoundException("User not found!");
		}
		
		return repository.findById(id).get();
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
