package com.smart.stock.controller.api;

import static com.smart.stock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smart.stock.dto.UtilisateurDTO;

public interface UtilisateurApi {

	@PostMapping(value = APP_ROOT
			+ "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDTO save(@RequestBody UtilisateurDTO dto);

	@GetMapping(value = APP_ROOT + "/user/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDTO findById(@PathVariable("idUtilisateur") Integer id);

	@GetMapping(value = APP_ROOT + "/user/firstname/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDTO finByNom(@PathVariable("firstname") String nom);

	@GetMapping(value = APP_ROOT + "/user/lastname/{prenom}", produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDTO finByPrenom(@PathVariable("lastname") String prenom);

	@GetMapping(value = APP_ROOT + "/user/mail/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDTO finByMail(@PathVariable("mail") String mail);

	@GetMapping(value = APP_ROOT + "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<UtilisateurDTO> findAll();

	@DeleteMapping(value = APP_ROOT + "user/delete/{idUtilisateur}")
	void delete(@PathVariable("idUtilisateur") Integer id);

}
