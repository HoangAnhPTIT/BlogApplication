package com.hoanganh.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganh.blog.DTO.CategoryDTO;
import com.hoanganh.blog.entity.CategoryEntity;
import com.hoanganh.blog.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CategoryDTO show(Long id) {
		CategoryEntity categoryEntity = categoryRepository.findById(id).get();
		return modelMapper.map(categoryEntity, CategoryDTO.class);
	}
	
	public List<CategoryDTO> findAll(){
		List<CategoryEntity> categories = categoryRepository.findAll();
		List<CategoryDTO> categoriesDTO = new ArrayList<>();
		for(CategoryEntity category:categories) {
			categoriesDTO.add(modelMapper.map(category, CategoryDTO.class));
		}
		return categoriesDTO;
	}
	
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);
		categoryEntity = categoryRepository.save(categoryEntity);
		return modelMapper.map(categoryEntity, CategoryDTO.class);
	}
	
	public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
		CategoryEntity categoryDB = categoryRepository.findById(id).get();
		if(categoryDTO.getCode() != null)
			categoryDB.setCode(categoryDTO.getCode());
		if(categoryDTO.getDescription() != null)
			categoryDB.setDescription(categoryDTO.getDescription());
		if(categoryDTO.getName() != null)
			categoryDB.setName(categoryDTO.getName());
		categoryDB = categoryRepository.save(categoryDB);
		return modelMapper.map(categoryDB, CategoryDTO.class);
	}
	
	public String delete(Long[] ids) {
		String message = "Delete successfully";
		for(Long id:ids) {
			try {
				categoryRepository.deleteById(id);
			} catch (IllegalArgumentException e) {
				message = e.getMessage();
			}
		}
		return message;
	}
	
	
	
	
	
	
	
	
	
}
