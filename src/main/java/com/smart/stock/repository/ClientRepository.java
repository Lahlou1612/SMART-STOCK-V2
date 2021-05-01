package com.smart.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	Optional<Client> findByIdEntreprise(Integer idEntreprise);
	Optional<Client> findByNom(String nom);
	Optional<Client> findByPrenom(String prenom);
	Optional<Client> findByMail(String mail);
	Optional<Client> findByNumTel(String numTel);
	
}
