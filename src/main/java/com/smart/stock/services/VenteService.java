package com.smart.stock.services;

import java.util.List;
import com.smart.stock.dto.VenteDTO;

public interface VenteService {
	
	VenteDTO save(VenteDTO dto);
	
	VenteDTO findById(Integer id);
	
	VenteDTO findByCode(String code);
	
	List<VenteDTO> findAll();
	
	void delete (Integer id);
	
	

}
