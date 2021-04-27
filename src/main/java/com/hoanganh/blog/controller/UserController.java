package com.hoanganh.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoanganh.blog.DTO.UserDTO;
import com.hoanganh.blog.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users")
	private List<UserDTO> index() {
		return userService.findAll();
	}
	
	@PostMapping("/api/users/new")
	public UserDTO create(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO); 
	}
	
	@GetMapping("/api/users/{id}")
	public UserDTO show(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PatchMapping("/api/users/{id}")
	public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return userService.update(id, userDTO);
	}
	
	@DeleteMapping("/api/users")
	public String delete(@RequestBody UserDTO userDTO) {
		Long[] ids = userDTO.getIds();
		return userService.delete(ids);
	}
}
