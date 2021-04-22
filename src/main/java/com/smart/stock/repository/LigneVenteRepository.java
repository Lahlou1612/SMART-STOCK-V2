package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.LigneVente;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer>{

}
