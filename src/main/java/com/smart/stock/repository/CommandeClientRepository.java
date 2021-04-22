package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.CommandeClient;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer>{

}
