package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.ClientDTO;

public interface ClientService {

	ClientDTO save(ClientDTO dto);
	
	ClientDTO findById(Integer id);
	
	ClientDTO findByIdEntreprise(Integer idEntreprise);
	
	ClientDTO finByNom(String nom);
	
	ClientDTO finByPrenom(String prenom);
	
	ClientDTO finByMail(String mail);
	
	ClientDTO finByNumTel(String numTel);
	
	List<ClientDTO> findAll();
	
	void delete(Integer id);
}
