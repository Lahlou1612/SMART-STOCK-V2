package com.smart.stock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smart.stock.models.Client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
	
	private Integer id;

	private String nom;

	private String prenom;
	
	private AdresseDTO adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	@JsonIgnore
	private List<CommandeClientDTO> commandeClients;
	
	public static ClientDTO fromEntity(Client Client) {
		if(Client == null) {
			return null;
		}
		return ClientDTO.builder()
				.id(Client.getId())
				.nom(Client.getNom())
				.prenom(Client.getPrenom())
				.photo(Client.getPhoto())
				.mail(Client.getMail())
				.numTel(Client.getNumTel())
				.adresse(AdresseDTO.fromEntity(Client.getAdresse()))
				.build();
	}
	
	public static Client toEntity(ClientDTO ClientDTO) {
		if(ClientDTO == null) {
			return null;
		}
		
		Client Client = new Client();
		Client.setNom(ClientDTO.getNom());
		Client.setPrenom(ClientDTO.getPrenom());
		Client.setPhoto(ClientDTO.getPhoto());
		Client.setMail(ClientDTO.getMail());
		Client.setNumTel(ClientDTO.getNumTel());
		Client.setAdresse(AdresseDTO.toEntity(ClientDTO.getAdresse()));
		return Client;
}
	
}
