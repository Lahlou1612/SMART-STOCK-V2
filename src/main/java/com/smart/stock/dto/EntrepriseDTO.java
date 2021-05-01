package com.smart.stock.dto;

import com.smart.stock.models.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDTO {

	private Integer id;

	private String nom;
	
	private String description;
	
	private String codeFiscale;
	
	private String email;
	
	private String photo;
	
	private String numTel;
		
	private AdresseDTO adresse;
	
	public static EntrepriseDTO fromEntity (Entreprise entreprise) {
		
		if (entreprise==null) {
			
			return null;
		}
		
		return EntrepriseDTO.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
				.codeFiscale(entreprise.getCodeFiscale())
				.email(entreprise.getEmail())
				.photo(entreprise.getPhoto())
				.numTel(entreprise.getNumTel())
				.adresse(AdresseDTO.fromEntity(entreprise.getAdresse()))
				.build();
	}
	
	public static Entreprise toEntity (EntrepriseDTO entrepriseDTO) {
		
		if (entrepriseDTO==null) {
			
			return null;
		}
		
		Entreprise entreprise = new Entreprise();
		entreprise.setNom(entrepriseDTO.getNom());
		entreprise.setDescription(entrepriseDTO.getDescription());
		entreprise.setCodeFiscale(entreprise.getCodeFiscale());
		entreprise.setEmail(entrepriseDTO.getEmail());
		entreprise.setPhoto(entrepriseDTO.getPhoto());
		entreprise.setNumTel(entrepriseDTO.getNumTel());
		entreprise.setAdresse(AdresseDTO.toEntity(entrepriseDTO.getAdresse()));
		return entreprise;
	}
}
