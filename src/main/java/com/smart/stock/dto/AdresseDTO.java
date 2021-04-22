package com.smart.stock.dto;

import com.smart.stock.models.Adresse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDTO {
	
	private Integer id;

	private String adressePrincipale;
	
	private String adresseSecondaire;
	
	private String ville;
	
	private String codePostale;
	
	private String pays;
	
	public static AdresseDTO fromEntity(Adresse adresse) {
		if(adresse == null) {
			return null;
		}
		return AdresseDTO.builder()
				.adressePrincipale(adresse.getAdressePrincipale())
				.adresseSecondaire(adresse.getAdresseSecondaire())
				.codePostale(adresse.getCodePostale())
				.ville(adresse.getVille())
				.pays(adresse.getPays())
				.build();
	}
	
	public static Adresse toEntity(AdresseDTO adresseDTO) {
		if(adresseDTO == null) {
			return null;
		}
		Adresse adresse = new Adresse();
		adresse.setAdressePrincipale(adresseDTO.getAdressePrincipale());
		adresse.setAdresseSecondaire(adresseDTO.getAdresseSecondaire());
		adresse.setCodePostale(adresseDTO.getCodePostale());
		adresse.setVille(adresseDTO.getVille());
		adresse.setPays(adresseDTO.getPays());
		return adresse;
		
	}
}
