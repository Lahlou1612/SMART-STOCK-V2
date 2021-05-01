package com.smart.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.FournisseurApi;
import com.smart.stock.dto.FournisseurDTO;
import com.smart.stock.services.FournisseurService;

@RestController
public class FournisseurController implements FournisseurApi {

	private FournisseurService fournisseurService;

	@Autowired
	public FournisseurController(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}

	@Override
	public FournisseurDTO save(FournisseurDTO dto) {
		return fournisseurService.save(dto);
	}

	@Override
	public FournisseurDTO findById(Integer id) {
		return fournisseurService.findById(id);
	}

	@Override
	public FournisseurDTO finByNom(String nom) {
		return fournisseurService.finByNom(nom);
	}

	@Override
	public FournisseurDTO finByPrenom(String prenom) {
		return fournisseurService.finByPrenom(prenom);
	}

	@Override
	public FournisseurDTO finByNumTel(String numTel) {
		return fournisseurService.finByNumTel(numTel);
	}

	@Override
	public FournisseurDTO finByMail(String mail) {
		return fournisseurService.finByMail(mail);
	}

	@Override
	public List<FournisseurDTO> findAll() {
		return fournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		fournisseurService.delete(id);

	}

}
