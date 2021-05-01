package com.smart.stock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.CommandeFournisseurDTO;
import com.smart.stock.dto.LigneCommandeFournisseurDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Article;
import com.smart.stock.models.CommandeFournisseur;
import com.smart.stock.models.Fournisseur;
import com.smart.stock.models.LigneCommandeFournisseur;
import com.smart.stock.repository.ArticleRepository;
import com.smart.stock.repository.CommandeFournisseurRepository;
import com.smart.stock.repository.FournisseurRepository;
import com.smart.stock.repository.LigneCommandeFournisseurRepository;
import com.smart.stock.services.CommandeFournissuerService;
import com.smart.stock.validator.CommandeFournissuerValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournissuerService {

	private CommandeFournisseurRepository commandeFournisseurRepository;
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
	private FournisseurRepository fournisseurRepository;
	private ArticleRepository articleRepository;

	@Autowired
	public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
			LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
			FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.articleRepository = articleRepository;
	}

	@Override
	public CommandeFournisseurDTO save(CommandeFournisseurDTO dto) {

		List<String> errors = CommandeFournissuerValidator.validate(dto);

		if (!errors.isEmpty()) {

			log.error("Commande Fournisseur n'est pas valide");
			throw new InvalidEntityException("La commade Fournisseur n'est pas valide",
					ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
		}
		
		Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
		if (fournisseur.isEmpty()) {

			log.warn("Fournisseur avec ID n'est trouver dans la base de donnée", dto.getFournisseur().getId());
			throw new EntityNotFoundException(
					"Aucun fournisseur avec ID " + dto.getFournisseur().getId() + " ne trouve pas dans la base de donnée",
					ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
		}

		List<String> articleErrors = new ArrayList<>();

		if (dto.getLigneCommandeFournisseurs() != null) {

			dto.getLigneCommandeFournisseurs().forEach(ligCmdFournisseur -> {
				if (ligCmdFournisseur.getArticle() != null) {

					Optional<Article> article = articleRepository.findById(ligCmdFournisseur.getArticle().getId());
					if (article.isEmpty()) {

						articleErrors
								.add("L'article avec ID :" + ligCmdFournisseur.getArticle().getId() + "n'existe pas");
					} else {

						articleErrors.add("Impossible d'enregistrer une Commande avec un article NULL");
					}
				}
			});
		}

		if (!articleErrors.isEmpty()) {
			log.warn("");
			throw new InvalidEntityException("Article n'existe pas dans la BD", ErrorCodes.ARTICLE_NOT_FOUND,
					articleErrors);
		}

		CommandeFournisseur saveCmdFournisseur = commandeFournisseurRepository
				.save(CommandeFournisseurDTO.toEntity(dto));

		if (dto.getLigneCommandeFournisseurs() != null) {

			dto.getLigneCommandeFournisseurs().forEach(ligCmdFournisseur -> {

				LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDTO
						.toEntity(ligCmdFournisseur);
				ligneCommandeFournisseur.setCommandefournisseur(saveCmdFournisseur);
				ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
			}

			);
		}

		return CommandeFournisseurDTO.fromEntity(saveCmdFournisseur);
	}

	@Override
	public CommandeFournisseurDTO findById(Integer id) {
		if (id == null) {

			log.error("Commande Fournisseur ID is NULL");
			return null;
		}
		return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucune Commande Fournisseur n'a ete touvé avec ID" + id,
						ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public CommandeFournisseurDTO findByCode(String code) {
		if (!StringUtils.hasLength(code)) {

			log.error("Commade fournisseur CODE est Vide");
			return null;
		}
		return commandeFournisseurRepository.findByCode(code).map(CommandeFournisseurDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucune Commande Fournisseur n'a ete touvé avec le Code" + code,
						ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public List<CommandeFournisseurDTO> findAll() {
		return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDTO::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {

			log.error("Commande Fournisseur Id est NULL");
			return;
		}
		commandeFournisseurRepository.deleteById(id);
	}

}
