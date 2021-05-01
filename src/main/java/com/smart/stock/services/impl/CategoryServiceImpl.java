package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.CategoryDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Category;
import com.smart.stock.repository.CategoryRepository;
import com.smart.stock.services.CategoryService;
import com.smart.stock.validator.CategoryValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		List<String> errors = CategoryValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Category Not Valid {}", dto);
			throw new InvalidEntityException("La catégorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
		}
		return CategoryDTO.fromEntity(categoryRepository.save(CategoryDTO.toEntity(dto)));
	}

	@Override
	public CategoryDTO findById(Integer id) {
		if (id == null) {

			log.error("ID Category is null");
			return null;
		}
		Optional<Category> category = categoryRepository.findById(id);

		CategoryDTO dto = CategoryDTO.fromEntity(category.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucune catégorie ne corresponde à cet ID : " + id + " ",
						ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public CategoryDTO finByCode(String code) {
		if (!StringUtils.hasLength(code)) {
			log.error("Code Category is null");
			return null;
		}
		Optional<Category> category = categoryRepository.findByCode(code);

		CategoryDTO dto = CategoryDTO.fromEntity(category.get());

		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException(
				"Aucune catégorie ne corresponde à ce Code : " + code + " ", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public List<CategoryDTO> findAll() {
		return categoryRepository.findAll().stream().map(CategoryDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Category ID is null");
			return;
		}
		categoryRepository.deleteById(id);
	}
}
