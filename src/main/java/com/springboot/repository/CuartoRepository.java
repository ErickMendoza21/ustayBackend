package com.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.entity.Cuarto;
import com.springboot.entity.Propiedad;

@Repository
public interface CuartoRepository extends JpaRepository<Cuarto, Integer> {

	List<Cuarto> findByDisponibilidad(boolean disponibilidad);
	
	List<Cuarto> findByPropiedad(Propiedad propiedad);

}
