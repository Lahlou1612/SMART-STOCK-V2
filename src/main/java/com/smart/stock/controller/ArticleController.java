package com.smart.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.ArticleApi;
import com.smart.stock.dto.ArticleDTO;
import com.smart.stock.services.ArticleService;

@RestController
public class ArticleController implements ArticleApi{
	
	//Field Injection
	@Autowired
	private ArticleService articleService;
	
	//Getter Injection
	@Autowired
	public ArticleService getArticleService() {
		
		return articleService;
	}
	
	
	//Constructor Injection 
	@Autowired
	public ArticleController(ArticleService articleService) {
		 this.articleService = articleService;
	}
	
	
	@Override
	public ArticleDTO save(ArticleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDTO finByCodeArticle(String codeArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
 
	
	
	
}
