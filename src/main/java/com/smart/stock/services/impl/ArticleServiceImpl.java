package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.ArticleDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Article;
import com.smart.stock.repository.ArticleRepository;
import com.smart.stock.services.ArticleService;
import com.smart.stock.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public ArticleDTO save(ArticleDTO dto) {
		List<String> errors = ArticleValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Article Not Valid {}", dto);
			throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_FOUND, errors);
		}
		return ArticleDTO.fromEntity(articleRepository.save(ArticleDTO.toEntity(dto)));

	}

	@Override
	public ArticleDTO findById(Integer id) {
		if (id == null) {
			log.error("ID Article is null");
			return null;
		}
		Optional<Article> article = articleRepository.findById(id);

		ArticleDTO dto = ArticleDTO.fromEntity(article.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun article ne correspond à cet ID : " + id + " ",
						ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDTO finByCodeArticle(String codeArticle) {
		if (!StringUtils.hasLength(codeArticle)) {
			log.error("Code Article is null");
			return null;
		}
		Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);

		ArticleDTO dto = ArticleDTO.fromEntity(article.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun article ne correspond à ce Code Article : " + codeArticle + " ",
						ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDTO> findAll() {
		return articleRepository.findAll().stream().map(ArticleDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			
			log.error("Article ID is null");
			return;
		}
		articleRepository.deleteById(id);

	}

}
