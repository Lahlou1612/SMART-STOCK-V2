package com.smart.stock.dto;

import java.time.Instant;
import java.util.List;

import com.smart.stock.models.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDTO {
	
	private Integer id;

	private String code;
	
	private Instant dateCommande;
	
	private ClientDTO client;
	
	private Integer idEntreprise;
	
	
	private List<LigneCommandeClientDTO> ligneCommandeClient;
	
	
	public static CommandeClientDTO fromEntity(CommandeClient commandeClient) {
		
		if(commandeClient==null) {
				
				return null;
		}
		
		return CommandeClientDTO.builder()
				.id(commandeClient.getId())
				.code(commandeClient.getCode())
				.dateCommande(commandeClient.getDateCommande())
				.client(ClientDTO.fromEntity(commandeClient.getClient()))
				.idEntreprise(commandeClient.getIdEntreprise())
				.build();
	}
	
	public static CommandeClient toEntity(CommandeClientDTO commandeClientDTO) {
		
		if (commandeClientDTO==null) {
			
			return null;
		}
		
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setCode(commandeClientDTO.getCode());
		commandeClient.setCreationDate(commandeClientDTO.getDateCommande());
		commandeClient.setClient(ClientDTO.toEntity(commandeClientDTO.getClient()));
		commandeClient.setIdEntreprise(commandeClientDTO.getIdEntreprise());
		return commandeClient;
	}
	
	
}
