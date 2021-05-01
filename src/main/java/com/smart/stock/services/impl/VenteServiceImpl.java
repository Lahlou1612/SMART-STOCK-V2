package com.smart.stock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.LigneVenteDTO;
import com.smart.stock.dto.VenteDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Article;
import com.smart.stock.models.LigneVente;
import com.smart.stock.models.Vente;
import com.smart.stock.repository.ArticleRepository;
import com.smart.stock.repository.LigneVenteRepository;
import com.smart.stock.repository.VenteRepository;
import com.smart.stock.services.VenteService;
import com.smart.stock.validator.VenteValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {

	private ArticleRepository articleRepository;
	private VenteRepository venteRepository;
	private LigneVenteRepository ligneVenteRepository;

	@Autowired
	public VenteServiceImpl(ArticleRepository articleRepository, VenteRepository venteRepository,
			LigneVenteRepository ligneVenteRepository) {
		this.articleRepository = articleRepository;
		this.venteRepository = venteRepository;
		this.ligneVenteRepository = ligneVenteRepository;
	}

	@Override
	public VenteDTO save(VenteDTO dto) {
		List<String> errors = VenteValidator.validate(dto);

		if (!errors.isEmpty()) {

			log.error("Vente n'est Valide");
			throw new InvalidEntityException("l'objet Vente n'est pas valide", ErrorCodes.VENTE_NOT_FOUND, errors);
		}

		List<String> articleErrors = new ArrayList<>();

		dto.getLigneVentes().forEach(ligneVenteDTO -> {

			Optional<Article> article = articleRepository.findById(ligneVenteDTO.getArticle().getId());
			if (article.isEmpty()) {

				articleErrors.add(
						"Aucun article avec l'ID" + ligneVenteDTO.getArticle().getId() + "n'a été trouvé dans la BD");
			}
		});

		if (!articleErrors.isEmpty()) {

			log.error("one or more article was not found in the DB", errors);
			throw new InvalidEntityException("un ou plusieur articles n'ont pas trouver au niveau de la BD",
					ErrorCodes.VENTE_NOT_VALID, errors);
		}

		Vente savedVentes = venteRepository.save(VenteDTO.toEntity(dto));

		dto.getLigneVentes().forEach(ligneVenteDTO -> {

			LigneVente ligneVente = LigneVenteDTO.toEntiy(ligneVenteDTO);
			ligneVente.setVente(savedVentes);
			ligneVenteRepository.save(ligneVente);
		}

		);

		return VenteDTO.fromEntity(savedVentes);
	}

	@Override
	public VenteDTO findById(Integer id) {
		if (id == null) {
			log.error("Vente ID is null");
			return null;
		}
		return venteRepository.findById(id).map(VenteDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Vente n'a été trouver au niveau de la BD",
						ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public VenteDTO findByCode(String code) {
		if (!StringUtils.hasLength(code)) {

			log.error("Commade Client CODE est Vide");
			return null;
		}

		return venteRepository.findByCode(code).map(VenteDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucune Vente n'a ete touvé avec le Code" + code,
						ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public List<VenteDTO> findAll() {
		return venteRepository.findAll().stream().map(VenteDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {

			log.error("Vente Id est NULL");
			return;
		}
		venteRepository.deleteById(id);

	}

}
