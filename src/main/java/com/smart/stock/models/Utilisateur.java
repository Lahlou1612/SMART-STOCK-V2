package com.smart.stock.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "datenaissance")
	private String datenaissance;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "motdepasse")
	private String motdepasse;
	
	@Embedded
	private Adresse adresse;
	
	@Column(name = "photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy ="utilisateur")
	private List<Roles> roles;

}
