package com.smart.stock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.smart.stock.models.MvtStock;
import com.smart.stock.models.TypeMvtStock;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStockDTO {
	
	private Integer id;

	private Instant dateMvt;
	
	private BigDecimal quantite;
	
	private ArticleDTO article;
	
	private TypeMvtStock mvtStock;
	
	private Integer idEntreprise;
	
	public static MvtStockDTO fromEntity (MvtStock mvtStock) {
		if (mvtStock==null) {
			
			return null;
		}
		return MvtStockDTO.builder()
				.id(mvtStock.getId())
				.dateMvt(mvtStock.getDateMvt())
				.quantite(mvtStock.getQuantite())
				.article(ArticleDTO.fromEntity(mvtStock.getArticle()))
				.mvtStock(MvtStockDTO.fromEntity(mvtStock).getMvtStock())
				.idEntreprise(mvtStock.getIdEntreprise())
				.build();
	}
	
	
	public static MvtStock toEntity (MvtStockDTO mvtStockDTO) {
		if (mvtStockDTO==null) {
			
			return null;
		}
		MvtStock mvtStock = new MvtStock();
		mvtStock.setDateMvt(mvtStockDTO.getDateMvt());
		mvtStock.setQuantite(mvtStockDTO.getQuantite());
		mvtStock.setArticle(ArticleDTO.toEntity(mvtStockDTO.getArticle()));
		mvtStock.setMvtStock(mvtStockDTO.getMvtStock());
		mvtStock.setIdEntreprise(mvtStockDTO.getIdEntreprise());
		return mvtStock;
	}
}
