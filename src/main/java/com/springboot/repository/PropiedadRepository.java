package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Propiedad;

@Repository
public interface PropiedadRepository extends JpaRepository<Propiedad, Integer>{

	
	
}
