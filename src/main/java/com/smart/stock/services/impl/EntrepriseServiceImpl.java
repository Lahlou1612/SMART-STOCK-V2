package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.EntrepriseDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Entreprise;
import com.smart.stock.repository.EntrepriseRepository;
import com.smart.stock.services.EntrepriseService;
import com.smart.stock.validator.EntrepriseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Override
	public EntrepriseDTO save(EntrepriseDTO dto) {
		List<String> errors = EntrepriseValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Entreprise Not Valid {}", dto);
			throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
		}
		return EntrepriseDTO.fromEntity(entrepriseRepository.save(EntrepriseDTO.toEntity(dto)));
	}

	@Override
	public EntrepriseDTO findById(Integer id) {
		if (id == null) {

			log.error("ID Entreprise is null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

		EntrepriseDTO dto = EntrepriseDTO.fromEntity(entreprise.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Entreprise ne correspond à cet ID : " + id + " ",
						ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public EntrepriseDTO finByDescription(String description) {
		if (!StringUtils.hasLength(description)) {
			log.error("description is null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findByDescription(description);

		EntrepriseDTO dto = EntrepriseDTO.fromEntity(entreprise.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Entreprise ne correspond à cette description : " + description + " ",
						ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public EntrepriseDTO finByCodeFiscale(String codeFiscale) {
		if (!StringUtils.hasLength(codeFiscale)) {
			log.error("code Fiscale is null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findByCodeFiscale(codeFiscale);

		EntrepriseDTO dto = EntrepriseDTO.fromEntity(entreprise.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Entreprise ne correspond à ce code Fiscale : " + codeFiscale + " ",
						ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public EntrepriseDTO finByEmail(String email) {
		if (!StringUtils.hasLength(email)) {
			log.error("email is null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findByEmail(email);

		EntrepriseDTO dto = EntrepriseDTO.fromEntity(entreprise.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Entreprise ne correspond à cette Adresse email : " + email + " ",
						ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public EntrepriseDTO finByNumTel(String numTel) {
		if (!StringUtils.hasLength(numTel)) {
			log.error("phone number is null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findByNumTel(numTel);

		EntrepriseDTO dto = EntrepriseDTO.fromEntity(entreprise.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Entreprise ne correspond à cette numéro de téléphone : " + numTel + " ",
						ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public List<EntrepriseDTO> findAll() {
		return entrepriseRepository.findAll().stream().map(EntrepriseDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {

		if (id == null) {
			log.error("Fournissuer ID is null");
			return;
		}
		entrepriseRepository.deleteById(id);

	}

}
