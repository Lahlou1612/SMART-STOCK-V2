package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.EntrepriseDTO;

public class EntrepriseValidator {

	public static List<String> validate(EntrepriseDTO entrepriseDTO) {

		List<String> errors = new ArrayList<>();

		if (entrepriseDTO == null) {
			errors.add("Veuillez renseigner le nom de l'entreprise");
			errors.add("Veuillez renseigner l'email de l'entreprise");
			errors.add("Veuillez renseigner le numero de téléphone de l'entreprise");
			errors.add("Veuillez renseigner le Code fiscale de l'enreprise");
			return errors;

		}

		if (!StringUtils.hasLength(entrepriseDTO.getNom())) {
			errors.add("Veuillez renseigner le nom de l'entreprise");
		}

		if (!StringUtils.hasLength(entrepriseDTO.getEmail())) {
			errors.add("Veuillez renseigner l'email de l'entreprise");
		}

		if (!StringUtils.hasLength(entrepriseDTO.getNumTel())) {
			errors.add("Veuillez renseigner le numero de téléphone de l'entreprise");
		}

		if (!StringUtils.hasLength(entrepriseDTO.getCodeFiscale())) {
			errors.add("Veuillez renseigner le Code fiscale de l'enreprise");
		}

		return errors;
	}

}
