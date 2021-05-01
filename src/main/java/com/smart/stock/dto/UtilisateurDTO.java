package com.smart.stock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smart.stock.models.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDTO {

	private Integer id;

	private String nom;

	private String prenom;

	private String datenaissance;

	private String mail;

	private String motdepasse;

	private AdresseDTO adresse;

	private String photo;

	private EntrepriseDTO entreprise;

	@JsonIgnore
	private List<RolesDTO> roles;

	public static UtilisateurDTO fromEntity(Utilisateur utilisateur) {

		if (utilisateur == null) {

			return null;
		}

		return UtilisateurDTO.builder().id(utilisateur.getId()).nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom()).datenaissance(utilisateur.getDatenaissance())
				.mail(utilisateur.getMail()).motdepasse(utilisateur.getMotdepasse()).photo(utilisateur.getPhoto())
				.adresse(AdresseDTO.fromEntity(utilisateur.getAdresse()))
				.entreprise(EntrepriseDTO.fromEntity(utilisateur.getEntreprise())).build();
	}

	public static Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {

		if (utilisateurDTO == null) {

			return null;
		}

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setPrenom(utilisateurDTO.getPrenom());
		utilisateur.setDatenaissance(utilisateurDTO.getDatenaissance());
		utilisateur.setMail(utilisateurDTO.getMail());
		utilisateur.setMotdepasse(utilisateurDTO.getMotdepasse());
		utilisateur.setPhoto(utilisateurDTO.getPhoto());
		utilisateur.setAdresse(AdresseDTO.toEntity(utilisateurDTO.getAdresse()));
		utilisateur.setEntreprise(EntrepriseDTO.toEntity(utilisateurDTO.getEntreprise()));
		return utilisateur;

	}
}
