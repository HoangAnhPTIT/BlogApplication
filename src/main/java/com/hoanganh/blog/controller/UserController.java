package com.hoanganh.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.blog.DTO.UserDTO;
import com.hoanganh.blog.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/users/new")
	public UserDTO create(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO); 
	}
}
