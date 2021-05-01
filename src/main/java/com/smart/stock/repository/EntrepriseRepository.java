package com.smart.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer>{

	Optional<Entreprise> findByNom(String description);

	Optional<Entreprise> findByDescription(String description);

	Optional<Entreprise> findByCodeFiscale(String codeFiscale);

	Optional<Entreprise> findByEmail(String email);

	
	Optional<Entreprise> findByNumTel(String numTel);

}
