package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.EntrepriseDTO;

public interface EntrepriseService {
	EntrepriseDTO save(EntrepriseDTO dto);
	
	EntrepriseDTO findById(Integer id);
	
	EntrepriseDTO finByDescription(String description);
	
	EntrepriseDTO finByCodeFiscale(String codeFiscale);
	
	EntrepriseDTO finByEmail(String email);
	
	EntrepriseDTO finByNumTel(String numTel);
	
	List<EntrepriseDTO> findAll();
	
	void delete(Integer id);
}
