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

import com.hoanganh.blog.DTO.ArticleDTO;
import com.hoanganh.blog.service.ArticleService;

@RestController
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping("/api/articles/{id}")
	public ArticleDTO show(@PathVariable Long id) {
		return articleService.show(id);
	}
	
	@GetMapping("/api/articles")
	public List<ArticleDTO> index(){
		return articleService.findAll();
	}
	
	@PostMapping("/api/articles/new")
	public ArticleDTO create(@RequestBody ArticleDTO articleDTO) {
		return articleService.save(articleDTO);
	}
	
	@PatchMapping("/api/articles/{id}")
	public ArticleDTO update(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
		return articleService.update(id, articleDTO);
	}
	
	@DeleteMapping("/api/articles")
	public String delete(@RequestBody ArticleDTO articleDTO) {
		Long[] ids = articleDTO.getIds();
		return articleService.delete(ids);
	}
	
}
