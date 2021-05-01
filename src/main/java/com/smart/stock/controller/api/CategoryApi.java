package com.smart.stock.controller.api;

import static com.smart.stock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smart.stock.dto.CategoryDTO;

public interface CategoryApi {
	
	@PostMapping(value = APP_ROOT + "/categorys/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	CategoryDTO save(@RequestBody CategoryDTO dto);
	
	@GetMapping(value = APP_ROOT + "/categorys/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	CategoryDTO findById(@PathVariable("idCategory") Integer id);
	
	@GetMapping(value = APP_ROOT + "/categorys/code/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	CategoryDTO finByCode(@PathVariable("codeCategory") String code);
	
	@GetMapping(value = APP_ROOT + "/categorys/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<CategoryDTO> findAll();
	
	@DeleteMapping(value = APP_ROOT + "categorys/delete/{idCategory}")
	void delete(@PathVariable("idCategory") Integer id);

}
