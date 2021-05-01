package com.smart.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository< Utilisateur, Integer>{

	Optional<Utilisateur> findByNom(String nom);

	Optional<Utilisateur> findByPrenom(String prenom);

	
	Optional<Utilisateur> findByDatenaissance(String datenaissance);

	Optional<Utilisateur> findByMail(String mail);

}
