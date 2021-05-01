package com.smart.stock.services;

import java.util.List;

import com.smart.stock.dto.MvtStockDTO;

public interface MvtStockService {

	MvtStockDTO save(MvtStockDTO dto);

	MvtStockDTO findById(Integer id);

	List<MvtStockDTO> findAll();

	void delete(Integer id);

}
