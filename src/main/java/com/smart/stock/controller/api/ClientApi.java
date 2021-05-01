package com.smart.stock.controller.api;

import static com.smart.stock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smart.stock.dto.ClientDTO;

public interface ClientApi {
	
	@PostMapping(value = APP_ROOT + "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	ClientDTO save(@RequestBody ClientDTO dto);
	
	@GetMapping(value = APP_ROOT + "/client/{idCleint}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDTO findById(@PathVariable("idCleint") Integer id);
	
	@GetMapping(value = APP_ROOT + "/client/code/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDTO findByIdEntreprise(@PathVariable("idEntreprise") Integer idEntreprise);
	
	@GetMapping(value = APP_ROOT + "/client/UserName/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDTO finByNom(@PathVariable("UserName") String nom);
	
	@GetMapping(value = APP_ROOT + "/client/lastname/{prenom}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDTO finByPrenom(@PathVariable("lastname") String prenom);
	
	@GetMapping(value = APP_ROOT + "/client/mail/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDTO finByMail(@PathVariable("mail") String mail);
	
	@GetMapping(value = APP_ROOT + "/client/phone/{numtel}", produces = MediaType.APPLICATION_JSON_VALUE)
	ClientDTO finByNumTel(@PathVariable("phone") String numTel);
	
	@GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ClientDTO> findAll();
	
	@DeleteMapping(value = APP_ROOT + "client/delete/{idCleint}")
	void delete(@PathVariable("idCleint") Integer id);

}
