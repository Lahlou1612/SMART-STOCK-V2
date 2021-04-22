package com.smart.stock.models;

import java.time.Instant;

import javax.persistence.Column;
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
@Table(name = "article")
public class Vente extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "datevente")
	private Instant dateVente;

	@Column(name = "commentaire")
	private String Commentaire;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;
}
