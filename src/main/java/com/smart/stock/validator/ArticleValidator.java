package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.ArticleDTO;

public class ArticleValidator {

	public static List<String> validate(ArticleDTO articleDTO) {

		List<String> errors = new ArrayList<>();
		
		
		if (articleDTO == null) {
			errors.add("Veuillez renseigner le code article");
			errors.add("Veuillez renseigner la designation de article");
			errors.add("Veuillez renseigner le prix unitaire de l'article");
			errors.add("Veuillez renseigner le taux TVA de l'article");
			errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
			errors.add("Veuillez renseigner la categorie de l'article");
			return errors;
			
		}

		if (!StringUtils.hasLength(articleDTO.getCodeArticle())) {
			errors.add("Veuillez renseigner le code article");
		}

		if (!StringUtils.hasLength(articleDTO.getDesignation())) {
			errors.add("Veuillez renseigner la designation de article");
		}

		if (articleDTO.getPrixUnitaireHt() == null) {
			errors.add("Veuillez renseigner le prix unitaire de l'article");
		}

		if (articleDTO.getTauxTva() == null) {
			errors.add("Veuillez renseigner le taux TVA de l'article");
		}

		if (articleDTO.getPrixUnitaireTtc() == null) {
			errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
		}
		
		if (articleDTO.getCategory() == null) {
			errors.add("Veuillez renseigner la categorie de l'article");
		}

		return errors;
	}
}
