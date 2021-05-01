package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.FournisseurDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Fournisseur;
import com.smart.stock.repository.FournisseurRepository;
import com.smart.stock.services.FournisseurService;
import com.smart.stock.validator.FournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository;

	@Override
	public FournisseurDTO save(FournisseurDTO dto) {
		List<String> errors = FournisseurValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Fournissuer Not Valid {}", dto);
			throw new InvalidEntityException("Le Fournisseur n'est pas valide", ErrorCodes.FOURNISSUER_NOT_VALID,
					errors);
		}
		return FournisseurDTO.fromEntity(fournisseurRepository.save(FournisseurDTO.toEntity(dto)));
	}

	@Override
	public FournisseurDTO findById(Integer id) {
		if (id == null) {

			log.error("ID Fournissuer is null");
			return null;
		}
		Optional<Fournisseur> fournissuer = fournisseurRepository.findById(id);

		FournisseurDTO dto = FournisseurDTO.fromEntity(fournissuer.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Fournisseur ne correspond à cet ID : " + id + " ",
						ErrorCodes.FOURNISSUER_NOT_FOUND));
	}

	@Override
	public FournisseurDTO finByNom(String nom) {
		if (!StringUtils.hasLength(nom)) {
			log.error("Name is null");
			return null;
		}
		Optional<Fournisseur> fournisseur = fournisseurRepository.findByNom(nom);

		FournisseurDTO dto = FournisseurDTO.fromEntity(fournisseur.get());

		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException(
				"Aucun Fournissuer ne correspond à ce nom : " + nom + " ", ErrorCodes.FOURNISSUER_NOT_FOUND));
	}

	@Override
	public FournisseurDTO finByPrenom(String prenom) {
		if (!StringUtils.hasLength(prenom)) {
			log.error("First Name is null");
			return null;
		}
		Optional<Fournisseur> fournisseur = fournisseurRepository.findByPrenom(prenom);

		FournisseurDTO dto = FournisseurDTO.fromEntity(fournisseur.get());

		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException(
				"Aucun Fournissuer ne correspond à ce nom : " + prenom + " ", ErrorCodes.FOURNISSUER_NOT_FOUND));
	}

	@Override
	public FournisseurDTO finByMail(String mail) {
		if (!StringUtils.hasLength(mail)) {
			log.error("First Name is null");
			return null;
		}
		Optional<Fournisseur> fournisseur = fournisseurRepository.findByMail(mail);

		FournisseurDTO dto = FournisseurDTO.fromEntity(fournisseur.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Fournissuer ne correspond à cette Adresse Mail : " + mail + " ",
						ErrorCodes.FOURNISSUER_NOT_FOUND));
	}

	@Override
	public FournisseurDTO finByNumTel(String numTel) {
		if (!StringUtils.hasLength(numTel)) {
			log.error("phone Number is null");
			return null;
		}
		Optional<Fournisseur> fournisseur = fournisseurRepository.findByMail(numTel);

		FournisseurDTO dto = FournisseurDTO.fromEntity(fournisseur.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Fournissuer ne correspond à ce numéro de téléphone : " + numTel + " ",
						ErrorCodes.FOURNISSUER_NOT_FOUND));
	}

	@Override
	public List<FournisseurDTO> findAll() {
		return fournisseurRepository.findAll().stream().map(FournisseurDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Fournissuer ID is null");
			return;
		}
		fournisseurRepository.deleteById(id);

	}

}
