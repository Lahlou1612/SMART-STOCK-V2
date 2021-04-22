package com.smart.stock.dto;

import java.math.BigDecimal;

import com.smart.stock.models.Article;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDTO {

	private Integer id;

	private String codeArticle;

	private String designation;

	private BigDecimal prixUnitaireHt;

	private BigDecimal tauxTva;

	private BigDecimal prixUnitaireTtc;

	private String photo;

	private CategoryDTO category;
	
	
	public static ArticleDTO fromEntity(Article article) {
		if(article == null) {
			return null;
		}
		return ArticleDTO.builder()
				.id(article.getId())
				.codeArticle(article.getCodeArticle())
				.designation(article.getDesignation())
				.prixUnitaireHt(article.getPrixUnitaireHt())
				.prixUnitaireTtc(article.getPrixUnitaireTtc())
				.tauxTva(article.getTauxTva())
				.photo(article.getPhoto())
				.category(CategoryDTO.fromEntity(article.getCategory()))
				.build();
	}
	
	public static Article toEntity(ArticleDTO articleDTO) {
		if(articleDTO == null) {
			return null;
		}
		
		Article article = new Article();
		article.setCodeArticle(articleDTO.getCodeArticle());
		article.setDesignation(articleDTO.getDesignation());
		article.setPrixUnitaireHt(articleDTO.getPrixUnitaireHt());
		article.setTauxTva(articleDTO.getTauxTva());
		article.setPrixUnitaireTtc(articleDTO.getPrixUnitaireTtc());
		article.setPhoto(articleDTO.getPhoto());
		article.setCategory(CategoryDTO.toEntity(articleDTO.getCategory()));
		return article;
}
}
