package com.smart.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.stock.models.MvtStock;

@Repository
public interface MvtStkRepository extends JpaRepository<MvtStock, Integer>{

}
