package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.UtilisateurDTO;

public interface UtilisateurService {
	UtilisateurDTO save(UtilisateurDTO dto);

	UtilisateurDTO findById(Integer id);

	UtilisateurDTO finByNom(String nom);

	UtilisateurDTO finByPrenom(String prenom);
	
	UtilisateurDTO finByDatenaissance(String datenaissance);

	UtilisateurDTO finByMail(String mail);

	List<UtilisateurDTO> findAll();

	void delete(Integer id);
}
