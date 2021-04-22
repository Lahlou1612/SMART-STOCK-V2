package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.FournisseurDTO;

public class FournisseurValidator {
	
	public static List<String> validate(FournisseurDTO fournisseurDTO) {

		List<String> errors = new ArrayList<>();
		
		if (fournisseurDTO == null) {
			errors.add("Veuillez renseigner le nom du Client");
			errors.add("Veuillez renseigner le prenom du Client");
			errors.add("Veuillez renseigner le numero de téléphone du Client");
			errors.add("Veuillez renseigner le mail du Client");
			return errors;
			
		}
		
		if (!StringUtils.hasLength(fournisseurDTO.getNom())) {
			errors.add("Veuillez renseigner le nom du Fournisseur");
		}
		
		if (!StringUtils.hasLength(fournisseurDTO.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du Fournisseur");
		}
		
		if (!StringUtils.hasLength(fournisseurDTO.getNumTel())) {
			errors.add("Veuillez renseigner le numero de téléphone du Fournisseur");
		}
		
		if (!StringUtils.hasLength(fournisseurDTO.getMail())) {
			errors.add("Veuillez renseigner le mail du Fournisseur");
		}
		
		return errors;
		
	}

}
