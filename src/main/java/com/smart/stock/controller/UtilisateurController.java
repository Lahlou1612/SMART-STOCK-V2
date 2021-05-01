package com.smart.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.UtilisateurApi;
import com.smart.stock.dto.UtilisateurDTO;
import com.smart.stock.services.UtilisateurService;

@RestController
public class UtilisateurController implements UtilisateurApi {

	private UtilisateurService utilisateurService;

	@Autowired
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	public UtilisateurDTO save(UtilisateurDTO dto) {
		return utilisateurService.save(dto);
	}

	@Override
	public UtilisateurDTO findById(Integer id) {
		return utilisateurService.findById(id);
	}

	@Override
	public UtilisateurDTO finByNom(String nom) {
		return utilisateurService.finByNom(nom);
	}

	@Override
	public UtilisateurDTO finByPrenom(String prenom) {
		return utilisateurService.finByPrenom(prenom);
	}

	@Override
	public UtilisateurDTO finByMail(String mail) {
		return utilisateurService.finByMail(mail);
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		return utilisateurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		utilisateurService.delete(id);
	}

}
