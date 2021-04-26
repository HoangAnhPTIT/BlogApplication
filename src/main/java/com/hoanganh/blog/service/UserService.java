package com.hoanganh.blog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.blog.DTO.UserDTO;
import com.hoanganh.blog.entity.UserEntity;
import com.hoanganh.blog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		userEntity = userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserDTO.class);
	}
	
	public UserDTO findByusernameAndpassword(String username, String password) {
		UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password);
		return modelMapper.map(userEntity, UserDTO.class);
	}
	
	public UserDTO findByusername(String username) {
		UserEntity userEntity = userRepository.findByusername(username);
		return modelMapper.map(userEntity, UserDTO.class);
	}
}
