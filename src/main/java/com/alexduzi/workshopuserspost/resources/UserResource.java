package com.alexduzi.workshopuserspost.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexduzi.workshopuserspost.domain.User;
import com.alexduzi.workshopuserspost.dto.UserDTO;
import com.alexduzi.workshopuserspost.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> users = userService.findAll();
		
		List<UserDTO> usersDTO = users.stream().map(UserDTO::new).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usersDTO);
	}
}
