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
	
	private CommandeClientDTO commandeClient;
	
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	
	public static LigneCommandeClientDTO fromEntity (LigneCommandeClient ligneCommandeClient) {
		
		if (ligneCommandeClient==null) {
			
			return null;
		}
		
		return LigneCommandeClientDTO.builder()
				.id(ligneCommandeClient.getId())
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.article(ArticleDTO.fromEntity(ligneCommandeClient.getArticle()))
				.commandeClient(CommandeClientDTO.fromEntity(ligneCommandeClient.getCommandeClient()))
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
		ligneCommandeClient.setCommandeClient(CommandeClientDTO.toEntity(ligneCommandeClientDTO.getCommandeClient()));
		return ligneCommandeClient;
	}
}
