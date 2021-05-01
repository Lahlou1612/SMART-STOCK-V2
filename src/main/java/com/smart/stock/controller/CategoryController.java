package com.smart.stock.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.CategoryApi;
import com.smart.stock.dto.CategoryDTO;
import com.smart.stock.services.CategoryService;

@RestController
public class CategoryController implements CategoryApi {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		return categoryService.save(dto);
	}

	@Override
	public CategoryDTO findById(Integer id) {
		return categoryService.findById(id);
	}

	@Override
	public CategoryDTO finByCode(String code) {
		return categoryService.finByCode(code);
	}

	@Override
	public List<CategoryDTO> findAll() {
		return categoryService.findAll();
	}

	@Override
	public void delete(Integer id) {
		categoryService.delete(id);

	}

}
