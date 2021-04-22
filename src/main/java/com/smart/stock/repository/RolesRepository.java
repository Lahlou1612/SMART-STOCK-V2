package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository< Roles, Integer>{

}
