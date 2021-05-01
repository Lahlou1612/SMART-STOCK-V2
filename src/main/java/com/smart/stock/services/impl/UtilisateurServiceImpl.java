package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.UtilisateurDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Utilisateur;
import com.smart.stock.repository.UtilisateurRepository;
import com.smart.stock.services.UtilisateurService;
import com.smart.stock.validator.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public UtilisateurDTO save(UtilisateurDTO dto) {
		List<String> errors = UtilisateurValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Utilisateur Not Valid {}", dto);
			throw new InvalidEntityException("L'uitilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID,
					errors);
		}
		return UtilisateurDTO.fromEntity(utilisateurRepository.save(UtilisateurDTO.toEntity(dto)));

	}

	@Override
	public UtilisateurDTO findById(Integer id) {
		if (id == null) {

			log.error("ID User is null");
			return null;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

		UtilisateurDTO dto = UtilisateurDTO.fromEntity(utilisateur.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Utilisateur ne correspond à cet ID : " + id + " ",
						ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDTO finByNom(String nom) {
		if (!StringUtils.hasLength(nom)) {
			log.error("Name User is null");
			return null;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByNom(nom);

		UtilisateurDTO dto = UtilisateurDTO.fromEntity(utilisateur.get());

		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException(
				"Aucun Utilisateur ne correspond à ce nom : " + nom + " ", ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDTO finByPrenom(String prenom) {
		if (!StringUtils.hasLength(prenom)) {
			log.error("Name User is null");
			return null;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByPrenom(prenom);

		UtilisateurDTO dto = UtilisateurDTO.fromEntity(utilisateur.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Utilisateur ne correspond à ce prenom : " + prenom + " ",
						ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDTO finByDatenaissance(String datenaissance) {
		if (!StringUtils.hasLength(datenaissance)) {
			log.error("Birthday User is null");
			return null;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByDatenaissance(datenaissance);

		UtilisateurDTO dto = UtilisateurDTO.fromEntity(utilisateur.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Utilisateur ne correspond à cette date de naissance : " + datenaissance + " ",
						ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDTO finByMail(String mail) {
		if (!StringUtils.hasLength(mail)) {
			log.error("User Mail is null");
			return null;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);

		UtilisateurDTO dto = UtilisateurDTO.fromEntity(utilisateur.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Utilisateur ne correspond à cette adresse mail : " + mail + " ",
						ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		return utilisateurRepository.findAll().stream().map(UtilisateurDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("User ID is null");
			return;
		}
		utilisateurRepository.deleteById(id);
	}

}
