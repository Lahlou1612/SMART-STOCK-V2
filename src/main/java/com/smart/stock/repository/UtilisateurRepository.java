package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository< Utilisateur, Integer>{

}
