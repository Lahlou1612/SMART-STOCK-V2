package com.smart.stock.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {
	
	@Column(name ="adresseprincipale")
	private String adressePrincipale;
	
	@Column(name ="adressesecondaire")
	private String adresseSecondaire;
	
	@Column(name ="ville")
	private String ville;
	
	@Column(name ="codepostale")
	private String codePostale;
	
	@Column(name ="pays")
	private String pays;
	
}
