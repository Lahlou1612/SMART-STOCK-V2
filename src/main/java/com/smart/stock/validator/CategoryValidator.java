package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.CategoryDTO;

public class CategoryValidator {

	public static List<String> validate(CategoryDTO categoryDTO) {

		List<String> errors = new ArrayList<>();
		if (categoryDTO == null || !StringUtils.hasLength(categoryDTO.getCode())) {
			errors.add("Veuillez renseigner le code categorie");
		}
		return errors;

	}

}
