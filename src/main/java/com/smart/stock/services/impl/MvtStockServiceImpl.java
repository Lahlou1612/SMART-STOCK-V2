package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.stock.dto.MvtStockDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.MvtStock;
import com.smart.stock.repository.MvtStkRepository;
import com.smart.stock.services.MvtStockService;
import com.smart.stock.validator.MvtStockValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MvtStockServiceImpl implements MvtStockService {

	@Autowired
	private MvtStkRepository mvtStkRepository;

	@Override
	public MvtStockDTO save(MvtStockDTO dto) {
		List<String> errors = MvtStockValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("MvtStock Not Valid {}", dto);
			throw new InvalidEntityException("le mouvement de stock n'est pas valide", ErrorCodes.MVT_STK_NOT_FOUND,
					errors);
		}
		return MvtStockDTO.fromEntity(mvtStkRepository.save(MvtStockDTO.toEntity(dto)));
	}

	@Override
	public MvtStockDTO findById(Integer id) {
		if (id == null) {
			log.error("ID Article is null");
			return null;
		}
		Optional<MvtStock> mvtStock = mvtStkRepository.findById(id);

		MvtStockDTO dto = MvtStockDTO.fromEntity(mvtStock.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Vente ne correspond à cet ID : " + id + " ",
						ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public List<MvtStockDTO> findAll() {
		return mvtStkRepository.findAll().stream().map(MvtStockDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {

			log.error("Vente ID is null");
			return;
		}
		mvtStkRepository.deleteById(id);

	}

}
