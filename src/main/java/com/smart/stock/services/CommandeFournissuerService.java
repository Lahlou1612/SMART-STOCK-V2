package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.CommandeFournisseurDTO;

public interface CommandeFournissuerService {
	
	
	CommandeFournisseurDTO save(CommandeFournisseurDTO dto);
	
	CommandeFournisseurDTO findById(Integer id);
	
	CommandeFournisseurDTO findByCode(String code);
	
	List<CommandeFournisseurDTO> findAll();
	
	void delete (Integer id);
	

}
