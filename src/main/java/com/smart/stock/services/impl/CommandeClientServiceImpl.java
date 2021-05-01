package com.smart.stock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.CommandeClientDTO;
import com.smart.stock.dto.LigneCommandeClientDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Article;
import com.smart.stock.models.Client;
import com.smart.stock.models.CommandeClient;
import com.smart.stock.models.LigneCommandeClient;
import com.smart.stock.repository.ArticleRepository;
import com.smart.stock.repository.ClientRepository;
import com.smart.stock.repository.CommandeClientRepository;
import com.smart.stock.repository.LigneCommandeClientRepository;
import com.smart.stock.services.CommandeClientService;
import com.smart.stock.validator.CommadeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

	private CommandeClientRepository commandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;

	@Autowired
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
			ClientRepository clientRepository, ArticleRepository articleRepository,
			LigneCommandeClientRepository ligneCommandeClientRepository) {
		this.commandeClientRepository = commandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
	}

	@Override
	public CommandeClientDTO save(CommandeClientDTO dto) {
		List<String> errors = CommadeClientValidator.validate(dto);
		if (!errors.isEmpty()) {

			log.error("Commade Client n'est valide");
			throw new InvalidEntityException("La Commade Client n'est Valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,
					errors);
		}

		Optional<Client> client = clientRepository.findById(dto.getClient().getId());
		if (client.isEmpty()) {

			log.warn("Client avec ID n'est trouver dans la base de donnée", dto.getClient().getId());
			throw new EntityNotFoundException(
					"Aucun client avec ID " + dto.getClient().getId() + " ne trouve pas dans la base de donnée",
					ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
		}

		List<String> articleErrors = new ArrayList<>();

		if (dto.getLigneCommandeClient() != null) {
			dto.getLigneCommandeClient().forEach(ligCmdClt -> {

				if (ligCmdClt.getArticle() != null) {

					Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
					if (article.isEmpty()) {
						articleErrors.add("l'article avec ID " + ligCmdClt.getArticle().getId() + "n'exsite pas");

					}

				} else {
					articleErrors.add("Impossible d'enregister une commade avec un article NULL");
				}
			});

		}

		if (!articleErrors.isEmpty()) {
			log.warn("");
			throw new InvalidEntityException("Article n'exsite pas deans la Base de donneé",
					ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);

		}

		CommandeClient saveCmdClt = commandeClientRepository.save(CommandeClientDTO.toEntity(dto));

		if (dto.getLigneCommandeClient() != null) {
			dto.getLigneCommandeClient().forEach(ligCmdClt -> {
				LigneCommandeClient ligneCommandeClient = LigneCommandeClientDTO.toEntity(ligCmdClt);
				ligneCommandeClient.setCommandeClient(saveCmdClt);
				ligneCommandeClientRepository.save(ligneCommandeClient);
			});
		}

		return CommandeClientDTO.fromEntity(saveCmdClt);
	}

	@Override
	public CommandeClientDTO findById(Integer id) {
		if (id == null) {

			log.error("Commande Client ID is NULL");
			return null;
		}
		return commandeClientRepository.findById(id).map(CommandeClientDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucune Commande Fournisseur n'a ete touvé avec ID" + id,
						ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDTO findByCode(String code) {
		if (!StringUtils.hasLength(code)) {

			log.error("Commade Client CODE est Vide");
			return null;
		}

		return commandeClientRepository.findByCode(code).map(CommandeClientDTO::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException("Aucune Commande Client n'a ete touvé avec le Code" + code,
						ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDTO> findAll() {
		return commandeClientRepository.findAll().stream().map(CommandeClientDTO::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {

			log.error("Commande Client Id est NULL");
			return;
		}
		commandeClientRepository.deleteById(id);

	}

}
