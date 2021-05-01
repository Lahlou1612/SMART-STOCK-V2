package com.smart.stock.dto;

import java.math.BigDecimal;

import com.smart.stock.models.LigneVente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDTO {

	private Integer id;

	private VenteDTO vente;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer idEntreprise;
	
	private ArticleDTO article;
	
	
	public static LigneVenteDTO fromEntity (LigneVente ligneVente) {
		
		if (ligneVente==null) {
			
			return null;
		}
		
		return LigneVenteDTO.builder()
				.id(ligneVente.getId())
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.vente(VenteDTO.fromEntity(ligneVente.getVente()))
				.idEntreprise(ligneVente.getIdEntreprise())
				.build();
	}
	
	public static LigneVente toEntiy (LigneVenteDTO ligneVenteDTO) {
		
		if (ligneVenteDTO==null) {
			
			return null;
			
		}
		
		LigneVente ligneVente = new LigneVente();
		ligneVente.setQuantite(ligneVenteDTO.getQuantite());
		ligneVente.setPrixUnitaire(ligneVenteDTO.getPrixUnitaire());
		ligneVente.setVente(VenteDTO.toEntity(ligneVenteDTO.getVente()));
		ligneVente.setIdEntreprise(ligneVenteDTO.getIdEntreprise());
		return ligneVente;
		
	}
}
