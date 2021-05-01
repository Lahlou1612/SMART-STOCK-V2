package com.smart.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.ArticleApi;
import com.smart.stock.dto.ArticleDTO;
import com.smart.stock.services.ArticleService;

@RestController
public class ArticleController implements ArticleApi{
	
//	//Field Injection
//	@Autowired
	private ArticleService articleService;
//	
//	//Setter Injection
//	@Autowired
//	public ArticleService setArticleService(ArticleService articleService) {
//		this.articleService = articleService;
//		return articleService;
//	}
	
	
	//Constructor Injection 
	@Autowired
	public ArticleController(ArticleService articleService) {
		 this.articleService = articleService;
	}
	
	
	@Override
	public ArticleDTO save(ArticleDTO dto) {
		return articleService.save(dto);
	}

	@Override
	public ArticleDTO findById(Integer id) {
		return articleService.findById(id);
	}

	@Override
	public ArticleDTO finByCodeArticle(String codeArticle) {
		return articleService.finByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDTO> findAll() {
		return articleService.findAll();
	}

	@Override
	public void delete(Integer id) {
	 articleService.delete(id);
		
	}
	
 
	
	
	
}
