package com.smart.stock.models;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "mvtstock")
public class MvtStock extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "datemvt")
	private Instant dateMvt;
	
	@Column(name = "quantite")
	private BigDecimal quantite;
	
	@ManyToOne
	@JoinColumn(name ="idarticle")
	private Article article;
	
	@Column(name = "typeMvtStock")
	private TypeMvtStock mvtStock;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;
	
}
