package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.CommandeClientDTO;

public interface CommandeClientService {
	
	CommandeClientDTO save(CommandeClientDTO dto);
	
	CommandeClientDTO findById(Integer id);
	
	CommandeClientDTO findByCode(String code);
	
	List<CommandeClientDTO> findAll();
	
	void delete(Integer id);

}
