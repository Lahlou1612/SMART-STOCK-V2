package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.ArticleDTO;

public interface ArticleService {

	ArticleDTO save(ArticleDTO dto);
	
	ArticleDTO findById(Integer id);
	
	ArticleDTO finByCodeArticle(String codeArticle);
	
	List<ArticleDTO> findAll();
	
	void delete(Integer id);
}
