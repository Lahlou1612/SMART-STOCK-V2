package com.smart.stock.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
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
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;
	
	@Column(name = "datcommande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idfournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany (mappedBy = "commandefournisseur")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;
}
