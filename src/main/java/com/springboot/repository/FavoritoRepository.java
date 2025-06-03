package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Cuarto;
import com.springboot.entity.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {

@Query("SELECT f.cuarto FROM Favorito f WHERE f.usuario.id = :usuario_id")
List<Cuarto> findCuartosFavoritosByUsuarioId(@Param("usuario_id") int usuario_id);

}
