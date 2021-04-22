package com.smart.stock.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "codefiscale")
	private String codeFiscale;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "numtel")
	private String numTel;
	
	@Embedded
	private Adresse adresse;

}
