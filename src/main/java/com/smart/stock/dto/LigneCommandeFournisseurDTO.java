package com.smart.stock.dto;

import java.math.BigDecimal;

import com.smart.stock.models.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDTO {

	private Integer id;

	private ArticleDTO article;

	private BigDecimal quantite;

	private BigDecimal prixUnitaire;

	private Integer idEntreprise;

	private CommandeFournisseurDTO commandefournisseur;

	public static LigneCommandeFournisseurDTO fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {

		if (ligneCommandeFournisseur == null) {

			return null;
		}

		return LigneCommandeFournisseurDTO.builder().id(ligneCommandeFournisseur.getId())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.article(ArticleDTO.fromEntity(ligneCommandeFournisseur.getArticle()))
				.idEntreprise(ligneCommandeFournisseur.getIdEntreprise()).commandefournisseur(
						CommandeFournisseurDTO.fromEntity(ligneCommandeFournisseur.getCommandefournisseur()))
				.build();

	}

	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDTO ligneCommandeFournisseurDTO) {

		if (ligneCommandeFournisseurDTO == null) {

			return null;
		}

		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDTO.getQuantite());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDTO.getPrixUnitaire());
		ligneCommandeFournisseur.setArticle(ArticleDTO.toEntity(ligneCommandeFournisseurDTO.getArticle()));
		ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDTO.getIdEntreprise());
		ligneCommandeFournisseur.setCommandefournisseur(
				CommandeFournisseurDTO.toEntity(ligneCommandeFournisseurDTO.getCommandefournisseur()));
		return ligneCommandeFournisseur;
	}
}
