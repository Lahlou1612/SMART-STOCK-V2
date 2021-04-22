package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer>{

}
