package com.smart.stock.dto;

import java.math.BigDecimal;

import com.smart.stock.models.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDTO {

	private Integer id;

	private ArticleDTO article;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer idEntreprise;
	
	private CommandeClientDTO commandeClient;
	
	public static LigneCommandeClientDTO fromEntity (LigneCommandeClient ligneCommandeClient) {
		
		if (ligneCommandeClient==null) {
			
			return null;
		}
		
		return LigneCommandeClientDTO.builder()
				.id(ligneCommandeClient.getId())
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.article(ArticleDTO.fromEntity(ligneCommandeClient.getArticle()))
				.idEntreprise(ligneCommandeClient.getIdEntreprise())
				.build();
	}
	
	public static LigneCommandeClient toEntity(LigneCommandeClientDTO ligneCommandeClientDTO) {
		
		if (ligneCommandeClientDTO==null) {
			
			return null;
		}
		
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		ligneCommandeClient.setQuantite(ligneCommandeClientDTO.getQuantite());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDTO.getPrixUnitaire());
		ligneCommandeClient.setArticle(ArticleDTO.toEntity(ligneCommandeClientDTO.getArticle()));
		ligneCommandeClient.setIdEntreprise(ligneCommandeClientDTO.getIdEntreprise());
		return ligneCommandeClient;
	}
}
