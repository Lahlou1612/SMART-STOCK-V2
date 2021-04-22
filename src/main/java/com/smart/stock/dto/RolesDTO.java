package com.smart.stock.dto;

import com.smart.stock.models.Roles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDTO {

	private Integer id;

	private String roleName;
	
	private UtilisateurDTO utilisateur;
	
	public static RolesDTO toEntity (Roles roles) {
		
		if (roles==null) {
			
			return null;
		}
		
		return RolesDTO.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.utilisateur(UtilisateurDTO.fromEntity(roles.getUtilisateur()))
				.build();
	}
	
	public static Roles fromEntity (RolesDTO rolesDTO) {
		
		if (rolesDTO==null) {
			
			return null;
		}
		
		Roles roles = new Roles();
		roles.setRoleName(rolesDTO.getRoleName());
		roles.setUtilisateur(UtilisateurDTO.toEntity(rolesDTO.getUtilisateur()));
		return roles;
	}
}
