package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.entity.Cuarto;
import com.springboot.entity.Propiedad;
import com.springboot.repository.CuartoRepository;

@Service
public class CuartoService {

	@Autowired
	private CuartoRepository cuartoRepository;

	public List<Cuarto> list(){
		return cuartoRepository.findAll();
	}

	public List<Cuarto> listarCuartosDisponibles(){
		return cuartoRepository.findByDisponibilidad(true);
	}
	
	public List<Cuarto> listarCuartosByPropiedad(Propiedad propiedad){
		return cuartoRepository.findByPropiedad(propiedad);
	}
	
	public Cuarto listCuartoById(int cuarto_id) {
		return cuartoRepository.findById(cuarto_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cuarto no encontrado con el id: " + cuarto_id));
		
	}
	
	public Cuarto saveCuarto(Cuarto cuarto) {
		return cuartoRepository.save(cuarto);
	}
	
	public Cuarto editCuarto(int cuarto_id, Cuarto cuarto) {
	    Cuarto newCuarto = cuartoRepository.findById(cuarto_id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuarto no encontrado con id " + cuarto_id));
	    newCuarto.setDescripcion(cuarto.getDescripcion());
	    newCuarto.setDimensiones(cuarto.getDimensiones());
	    newCuarto.setDisponibilidad(cuarto.isDisponibilidad());
	    newCuarto.setInformacion_adicional(cuarto.getInformacion_adicional());
	    newCuarto.setN_cuarto(cuarto.getN_cuarto());
	    newCuarto.setN_piso(cuarto.getN_piso());
	    newCuarto.setNombre(cuarto.getNombre());
	    newCuarto.setPrecio(cuarto.getPrecio());
	    newCuarto.setPropiedad(cuarto.getPropiedad());

	    return cuartoRepository.save(newCuarto);
	}
	
}
