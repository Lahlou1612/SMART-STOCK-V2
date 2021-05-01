package com.smart.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smart.stock.controller.api.ClientApi;
import com.smart.stock.dto.ClientDTO;
import com.smart.stock.services.ClientService;

@RestController
public class ClientController implements ClientApi {

	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ClientDTO save(ClientDTO dto) {
		return clientService.save(dto);
	}

	@Override
	public ClientDTO findById(Integer id) {
		return clientService.findById(id);
	}

	@Override
	public ClientDTO findByIdEntreprise(Integer idEntreprise) {
		return clientService.findByIdEntreprise(idEntreprise);
	}

	@Override
	public ClientDTO finByNom(String nom) {
		return clientService.finByNom(nom);
	}

	@Override
	public ClientDTO finByPrenom(String prenom) {
		return clientService.finByPrenom(prenom);
	}

	@Override
	public ClientDTO finByMail(String mail) {
		return clientService.finByMail(mail);
	}

	@Override
	public ClientDTO finByNumTel(String numTel) {
		return clientService.finByNumTel(numTel);
	}

	@Override
	public List<ClientDTO> findAll() {
		return clientService.findAll();
	}

	@Override
	public void delete(Integer id) {
		clientService.delete(id);

	}

}
