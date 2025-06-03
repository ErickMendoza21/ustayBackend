package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer>{

}
