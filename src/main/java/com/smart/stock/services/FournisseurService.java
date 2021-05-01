package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.FournisseurDTO;

public interface FournisseurService {
	FournisseurDTO save(FournisseurDTO dto);

	FournisseurDTO findById(Integer id);

	FournisseurDTO finByNom(String nom);

	FournisseurDTO finByPrenom(String prenom);

	FournisseurDTO finByMail(String mail);

	FournisseurDTO finByNumTel(String numTel);

	List<FournisseurDTO> findAll();

	void delete(Integer id);
}
