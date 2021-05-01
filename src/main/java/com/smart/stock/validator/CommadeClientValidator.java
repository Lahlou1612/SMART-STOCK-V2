package com.smart.stock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.stock.dto.CommandeClientDTO;

public class CommadeClientValidator {
	
	public static List<String> validate(CommandeClientDTO commandeClientDTO) {
		
		List<String> errors = new ArrayList<>();
		
		if (!StringUtils.hasLength(commandeClientDTO.getCode())) {
			errors.add("Veuillez renseigner le Code de la Commande");
		}
		
		if (commandeClientDTO.getDateCommande()==null) {
			errors.add("Veuillez renseigner la date de la Commande");
		}
		
		if (commandeClientDTO.getClient()==null) {
			errors.add("le Client associé a la commande est vide");
		}
		
		return errors;
		
	}

}
