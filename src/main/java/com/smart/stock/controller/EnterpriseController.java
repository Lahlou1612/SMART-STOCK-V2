package com.smart.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.EntrepriseApi;
import com.smart.stock.dto.EntrepriseDTO;
import com.smart.stock.services.EntrepriseService;

@RestController
public class EnterpriseController implements EntrepriseApi {

	private EntrepriseService entrepriseService;

	@Autowired
	public EnterpriseController(EntrepriseService entrepriseService) {
		this.entrepriseService = entrepriseService;
	}

	@Override
	public EntrepriseDTO save(EntrepriseDTO dto) {
		return entrepriseService.save(dto);
	}

	@Override
	public EntrepriseDTO findById(Integer id) {
		return entrepriseService.findById(id);
	}

	@Override
	public EntrepriseDTO finByCodeFiscale(String codeFiscale) {
		return entrepriseService.finByCodeFiscale(codeFiscale);
	}

	@Override
	public EntrepriseDTO finByEmail(String email) {
		return entrepriseService.finByEmail(email);
	}

	@Override
	public EntrepriseDTO finByNumTel(String numTel) {
		return entrepriseService.finByNumTel(numTel);
	}

	@Override
	public List<EntrepriseDTO> findAll() {
		return entrepriseService.findAll();
	}

	@Override
	public void delete(Integer id) {
		entrepriseService.delete(id);

	}

}
