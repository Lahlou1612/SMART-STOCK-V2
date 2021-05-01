package com.smart.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

	Optional<Article> findByCodeArticle(String codeArticle);
	
}
