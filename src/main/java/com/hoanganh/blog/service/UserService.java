package com.hoanganh.blog.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<UserDTO> findAll() {
		List<UserEntity> users = userRepository.findAll();
		List<UserDTO> usersDTO = new ArrayList<>();
		for(UserEntity user:users) {
			usersDTO.add(modelMapper.map(user, UserDTO.class));
		}
		return usersDTO;
	}
	
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
	
	public UserDTO findById(Long id) {
		UserEntity userEntity = userRepository.findById(id).get();
		return modelMapper.map(userEntity, UserDTO.class);
	}
	
	public UserDTO update(Long id, UserDTO userDTO) {
		UserEntity userDB = userRepository.findById(id).get();
		if(userDTO.getUsername() != null)
			userDB.setUsername(userDTO.getUsername());
		if(userDTO.getPassword() != null)
			userDB.setPassword(userDTO.getPassword());
		if(userDTO.getFullname() != null)
			userDB.setFullname(userDTO.getFullname());
		if(userDTO.getAddress() != null)
			userDB.setAddress(userDTO.getAddress());
		if(userDTO.getAge() != null)
			userDB.setAge(userDTO.getAge());
		if(userDTO.getGender() != null)
			userDB.setGender(userDTO.getGender());
		userDB = userRepository.save(userDB);
		return modelMapper.map(userDB, UserDTO.class);
	}
	
	
	public String delete(Long[] ids) {
		String message = "Delete successfully";
		for(Long id:ids) {
			try {
				userRepository.deleteById(id);	
			} catch (Exception e) {
				message = e.toString();
			}
			
		}
		return message;
	}
	
	
	
	
	
	
	
	
	
}
