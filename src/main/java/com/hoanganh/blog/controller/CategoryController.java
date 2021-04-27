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

import com.hoanganh.blog.DTO.CategoryDTO;
import com.hoanganh.blog.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/api/categories")
	public List<CategoryDTO> index(){
		return categoryService.findAll();
	}
	
	@GetMapping("/api/categories/{id}")
	public CategoryDTO show(@PathVariable Long id) {
		return categoryService.show(id);
	}
	
	@PostMapping("/api/categories")
	public CategoryDTO create(CategoryDTO categoryDTO) {
		return categoryService.save(categoryDTO);
	}
	
	@PatchMapping("/api/categories/{id}")
	public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
		return categoryService.update(id, categoryDTO);
	}
	
	@DeleteMapping("/api/categories")
	public String delete(@RequestBody CategoryDTO categoryDTO) {
		Long[] ids = categoryDTO.getIds();
		return categoryService.delete(ids);
	}
	
	
	
	
}
