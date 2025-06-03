package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{

}
