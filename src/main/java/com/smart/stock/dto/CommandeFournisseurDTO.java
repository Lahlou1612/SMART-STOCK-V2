package com.smart.stock.dto;

import java.time.Instant;
import java.util.List;

import com.smart.stock.models.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDTO {

	private Integer id;

	private String code;
	
	private Instant dateCommande;
	
	private FournisseurDTO fournisseur;
	
	private Integer idEntreprise;
	
	
	private List<LigneCommandeFournisseurDTO> ligneCommandeFournisseurs;
	
	public static CommandeFournisseurDTO fromEntity(CommandeFournisseur commandeFournisseur) {
		if (commandeFournisseur==null) {
			 return null;
		}
		
		return CommandeFournisseurDTO.builder()
				.id(commandeFournisseur.getId())
				.code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDTO.fromEntity(commandeFournisseur.getFournisseur()))
				.idEntreprise(commandeFournisseur.getIdEntreprise())
				.build();	
	}
	
	public static CommandeFournisseur toEntity(CommandeFournisseurDTO commandeFournisseurDTO) {
		if (commandeFournisseurDTO==null) {
			return null;
		}
		
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
		commandeFournisseur.setCode(commandeFournisseurDTO.getCode());
		commandeFournisseur.setDateCommande(commandeFournisseurDTO.getDateCommande());
		commandeFournisseur.setFournisseur(FournisseurDTO.toEntity(commandeFournisseurDTO.getFournisseur()));
		commandeFournisseur.setIdEntreprise(commandeFournisseurDTO.getIdEntreprise());
		return commandeFournisseur;
	}
}
