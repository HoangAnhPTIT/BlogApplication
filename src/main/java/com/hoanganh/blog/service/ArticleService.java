package com.hoanganh.blog.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hoanganh.blog.DTO.ArticleDTO;
import com.hoanganh.blog.DTO.MyUser;
import com.hoanganh.blog.entity.ArticleEntity;
import com.hoanganh.blog.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<ArticleDTO> findAll(){
		List<ArticleEntity> articles = articleRepository.findAll();
		List<ArticleDTO> articlesDTO = new ArrayList<>();
		for(ArticleEntity article:articles) {
			articlesDTO.add(modelMapper.map(article, ArticleDTO.class));
		}
		return articlesDTO;
	}
	
	public ArticleDTO show(Long id) {
		ArticleEntity articleEntity = articleRepository.findById(id).get();
		return modelMapper.map(articleEntity, ArticleDTO.class);
	}
	
	public ArticleDTO save(ArticleDTO articleDTO) {
		MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ArticleEntity articleEntity = modelMapper.map(articleDTO, ArticleEntity.class);
		articleEntity.setUserId(myUser.getId());
		articleEntity = articleRepository.save(articleEntity);
		return modelMapper.map(articleEntity, ArticleDTO.class);
	}
	
	public ArticleDTO update(Long id, ArticleDTO articleDTO) {
		ArticleEntity articleDB = articleRepository.findById(id).get();
		if(articleDTO.getContent() != null)
			articleDB.setContent(articleDTO.getContent());
		if(articleDTO.getDescription() != null)
			articleDB.setDescription(articleDTO.getDescription());
		articleDB = articleRepository.save(articleDB);
		return modelMapper.map(articleDB, ArticleDTO.class);
	}
	
	public String delete(Long[] ids) {
		String message = "Delete successfully";
		for(Long id:ids) {
			try {
				articleRepository.deleteById(id);	
			} catch (Exception e) {
				message = e.toString();
			}
		}
		return message;
	}
	
	
	
	
	
	
}
