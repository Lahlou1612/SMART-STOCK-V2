package com.smart.stock.controller.api;

import static com.smart.stock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smart.stock.dto.EntrepriseDTO;

public interface EntrepriseApi {
	
	@PostMapping(value = APP_ROOT + "/entreprises/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	EntrepriseDTO save(@RequestBody EntrepriseDTO dto);
	
	@GetMapping(value = APP_ROOT + "/entreprises/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDTO findById(@PathVariable("idEntreprise") Integer id);
	
	@GetMapping(value = APP_ROOT + "/entreprises/code/{codeFiscale}", produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDTO finByCodeFiscale(@PathVariable("codeFiscale") String codeFiscale);
	
	@GetMapping(value = APP_ROOT + "/entreprises/mail/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDTO finByEmail(@PathVariable("mail") String email);
	
	@GetMapping(value = APP_ROOT + "/entreprises/phone/{numTel}", produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDTO finByNumTel(@PathVariable("numTel") String numTel);
	
	@GetMapping(value = APP_ROOT + "/entreprises/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<EntrepriseDTO> findAll();
	
	@DeleteMapping(value = APP_ROOT + "entreprises/delete/{idEntreprise}")
	void delete(@PathVariable("idEntreprise") Integer id);

}
