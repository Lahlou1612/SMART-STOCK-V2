package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.UtilisateurDTO;

public class UtilisateurValidator {

	public static List<String> validate(UtilisateurDTO utilisateurDTO) {

		List<String> errors = new ArrayList<>();

		if (utilisateurDTO == null) {
			errors.add("Veuillez renseigner le nom de l'utilisateur");
			errors.add("Veuillez renseigner le prenom de l'utilisateur");
			errors.add("Veuillez renseigner la date naissance de l'utilisateur");
			errors.add("Veuillez renseigner le Mail de l'utilisateur");
			errors.add("Veuillez renseigner le mor de passe de l'utilisateur");
			errors.add("Veuillez renseigner l'adresse de l'utilisateur");
			return errors;

		}

		if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getNom())) {
			errors.add("Veuillez renseigner le nom de l'utilisateur");
		}

		if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getPrenom())) {
			errors.add("Veuillez renseigner le prenom de l'utilisateur");
		}

		if (utilisateurDTO.getDatenaissance() == null) {

			errors.add("Veuillez renseigner la date naissance de l'utilisateur");
		}

		if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getMail())) {
			errors.add("Veuillez renseigner le Mail de l'utilisateur");
		}

		if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getMotdepasse())) {
			errors.add("Veuillez renseigner le mor de passe de l'utilisateur");
		}

		if (utilisateurDTO.getAdresse() == null) {
			errors.add("Veuillez renseigner l'adresse de l'utilisateur");
		} else {

			if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getAdresse().getAdressePrincipale())) {
				errors.add("Veuillez renseigner l'adresse principale de l'utilisateur");
			}
			if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getAdresse().getCodePostale())) {
				errors.add("Veuillez renseigner le code postale de l'utilisateur");
			}
			if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getAdresse().getPays())) {
				errors.add("Veuillez renseigner le pays de l'utilisateur");
			}
			if (utilisateurDTO == null || !StringUtils.hasLength(utilisateurDTO.getAdresse().getVille())) {
				errors.add("Veuillez renseigner la ville de l'utilisateur");
			}
		}

		return errors;
	}

}
