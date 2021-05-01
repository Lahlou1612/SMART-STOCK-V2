package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.CategoryDTO;

public interface CategoryService {

	CategoryDTO save(CategoryDTO dto);

	CategoryDTO findById(Integer id);

	CategoryDTO finByCode(String code);

	List<CategoryDTO> findAll();

	void delete(Integer id);

}
