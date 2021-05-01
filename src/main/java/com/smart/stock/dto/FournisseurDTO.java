package com.smart.stock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smart.stock.models.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDTO {

	private Integer id;

	private String nom;

	private String prenom;
	
	private AdresseDTO adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	private Integer idEntreprise;
	
	@JsonIgnore
	private List<CommandeFournisseurDTO> commandeFournisseurs;
	
	public static FournisseurDTO fromEntity(Fournisseur fournisseur)
	{
		if(fournisseur == null)
		{
			return null;
		}
		
		return FournisseurDTO.builder()
				.id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.photo(fournisseur.getPhoto())
				.adresse(AdresseDTO.fromEntity(fournisseur.getAdresse()))
				.mail(fournisseur.getMail())
				.numTel(fournisseur.getNumTel())
				.idEntreprise(fournisseur.getIdEntreprise())
				.build();
	}
	
	public static Fournisseur toEntity(FournisseurDTO fournisseurDTO) {
		if(fournisseurDTO == null)
		{
			return null;
		}
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom(fournisseurDTO.getNom());
		fournisseur.setPrenom(fournisseurDTO.getPrenom());
		fournisseur.setAdresse(AdresseDTO.toEntity(fournisseurDTO.getAdresse()));
		fournisseur.setPhoto(fournisseurDTO.getPhoto());
		fournisseur.setMail(fournisseurDTO.getMail());
		fournisseur.setNumTel(fournisseurDTO.getNumTel());
		fournisseur.setIdEntreprise(fournisseurDTO.getIdEntreprise());
		return fournisseur;
		
	}
}
