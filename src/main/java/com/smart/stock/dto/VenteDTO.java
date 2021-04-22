package com.smart.stock.dto;

import java.time.Instant;

import com.smart.stock.models.Vente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenteDTO {

	private Integer id;

	private String code;
	
	private Instant dateVente;

	private String Commentaire;
	
	public static VenteDTO fromEntity ( Vente vente) {
		if (vente==null) {
			
			return null;
		}
		return VenteDTO.builder()
				.id(vente.getId())
				.code(vente.getCode())
				.dateVente(vente.getDateVente())
				.Commentaire(vente.getCommentaire())
				.build();
	}
	
	public static Vente toEntity (VenteDTO venteDTO) {
		if (venteDTO==null) {
			
			return null;
		}
		Vente vente= new Vente();
		vente.setCode(venteDTO.getCode());
		vente.setDateVente(venteDTO.getDateVente());
		vente.setCommentaire(venteDTO.getCommentaire());
		return vente;
	}
}
