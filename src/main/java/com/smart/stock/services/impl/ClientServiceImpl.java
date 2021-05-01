package com.smart.stock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.smart.stock.dto.ClientDTO;
import com.smart.stock.exception.EntityNotFoundException;
import com.smart.stock.exception.ErrorCodes;
import com.smart.stock.exception.InvalidEntityException;
import com.smart.stock.models.Client;
import com.smart.stock.repository.ClientRepository;
import com.smart.stock.services.ClientService;
import com.smart.stock.validator.ClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientDTO save(ClientDTO dto) {
		List<String> errors = ClientValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Customer Not Valid {}", dto);
			throw new InvalidEntityException("Le Client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
		}
		return ClientDTO.fromEntity(clientRepository.save(ClientDTO.toEntity(dto)));
	}

	@Override
	public ClientDTO findById(Integer id) {
		if (id == null) {

			log.error("ID Customer is null");
			return null;
		}
		Optional<Client> client = clientRepository.findById(id);

		ClientDTO dto = ClientDTO.fromEntity(client.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Client ne correspond à cet ID : " + id + " ",
						ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDTO findByIdEntreprise(Integer idEntreprise) {
		if (idEntreprise == null) {
			log.error("ID Entreprise is null");
			return null;
		}
		Optional<Client> client = clientRepository.findByIdEntreprise(idEntreprise);

		ClientDTO dto = ClientDTO.fromEntity(client.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Client ne correspond à cette entreprise : " + idEntreprise + " ",
						ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDTO finByNom(String nom) {
		if (!StringUtils.hasLength(nom)) {
			log.error("Name is null");
			return null;
		}
		Optional<Client> client = clientRepository.findByNom(nom);

		ClientDTO dto = ClientDTO.fromEntity(client.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException("Aucun Client ne correspond à ce nom : " + nom + " ",
						ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDTO finByPrenom(String prenom) {
		if (!StringUtils.hasLength(prenom)) {
			log.error("Last Name is null");
			return null;
		}
		Optional<Client> client = clientRepository.findByPrenom(prenom);

		ClientDTO dto = ClientDTO.fromEntity(client.get());

		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException(
				"Aucun Client ne correspond à ce prénom : " + prenom + " ", ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDTO finByMail(String mail) {
		if (!StringUtils.hasLength(mail)) {
			log.error("Mail is null");
			return null;
		}
		Optional<Client> client = clientRepository.findByMail(mail);

		ClientDTO dto = ClientDTO.fromEntity(client.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Client ne correspond à cette adresse mail : " + mail + " ",
						ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDTO finByNumTel(String numTel) {
		if (!StringUtils.hasLength(numTel)) {
			log.error("Numero is null");
			return null;
		}
		Optional<Client> client = clientRepository.findByNumTel(numTel);

		ClientDTO dto = ClientDTO.fromEntity(client.get());

		return Optional.of(dto)
				.orElseThrow(() -> new EntityNotFoundException(
						"Aucun Client ne correspond à ce numéro de téléphone : " + numTel + " ",
						ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public List<ClientDTO> findAll() {
		return clientRepository.findAll().stream().map(ClientDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Client ID is null");
			return;
		}
		clientRepository.deleteById(id);
	}

}
