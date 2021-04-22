package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer>{

}
