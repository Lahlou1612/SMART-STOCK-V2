package com.smart.stock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Optional<Category> findByCode(String code);
}
