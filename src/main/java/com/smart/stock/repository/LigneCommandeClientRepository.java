package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.LigneCommandeClient;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer>{

}
