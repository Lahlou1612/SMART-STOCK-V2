package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
