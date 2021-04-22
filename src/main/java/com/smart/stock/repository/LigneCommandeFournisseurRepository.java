package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.LigneCommandeFournisseur;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer>{

}
