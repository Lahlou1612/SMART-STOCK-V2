package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.ClientDTO;

public class ClientValidator {
	
	public static List<String> validate(ClientDTO clientDTO) {

		List<String> errors = new ArrayList<>();
		
		if (clientDTO == null) {
			errors.add("Veuillez renseigner le nom du Client");
			errors.add("Veuillez renseigner le prenom du Client");
			errors.add("Veuillez renseigner le numero de téléphone du Client");
			errors.add("Veuillez renseigner le mail du Client");
			return errors;
			
		}
		
		if (!StringUtils.hasLength(clientDTO.getNom())) {
			errors.add("Veuillez renseigner le nom du Client");
		}
		
		if (!StringUtils.hasLength(clientDTO.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du Client");
		}
		
		if (!StringUtils.hasLength(clientDTO.getNumTel())) {
			errors.add("Veuillez renseigner le numero de téléphone du Client");
		}
		
		if (!StringUtils.hasLength(clientDTO.getMail())) {
			errors.add("Veuillez renseigner le mail du Client");
		}
		
		return errors;
		
	}

}
