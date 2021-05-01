package com.smart.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer>{

	Optional<Fournisseur> findByNom(String nom);

	Optional<Fournisseur> findByPrenom(String prenom);

	Optional<Fournisseur> findByMail(String mail);

}
