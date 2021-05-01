package com.smart.stock.controller.api;

import static com.smart.stock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smart.stock.dto.FournisseurDTO;

public interface FournisseurApi {
	
	@PostMapping(value = APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	FournisseurDTO save(@RequestBody FournisseurDTO dto);
	
	@GetMapping(value = APP_ROOT + "/fournisseur/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDTO findById(@PathVariable("idFournisseur") Integer id);
	
	@GetMapping(value = APP_ROOT + "/fournisseur/firstname/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDTO finByNom(@PathVariable("firstname") String nom);
	
	@GetMapping(value = APP_ROOT + "/fournisseur/lastname/{prenom}", produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDTO finByPrenom(@PathVariable("lastname") String prenom);
	
	@GetMapping(value = APP_ROOT + "/fournisseur/phone/{numTel}", produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDTO finByNumTel(@PathVariable("numTel") String numTel);
	
	@GetMapping(value = APP_ROOT + "/fournisseur/mail/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDTO finByMail(@PathVariable("mail") String mail);
	
	@GetMapping(value = APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<FournisseurDTO> findAll();
	
	@DeleteMapping(value = APP_ROOT + "fournisseur/delete/{idFournisseur}")
	void delete(@PathVariable("idFournisseur") Integer id);

}
