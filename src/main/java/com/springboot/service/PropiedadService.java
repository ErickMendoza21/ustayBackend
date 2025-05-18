package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.springboot.entity.Propiedad;
import com.springboot.repository.PropiedadRepository;

@Service
public class PropiedadService {

	@Autowired
	private PropiedadRepository propiedadRepository;

	public Propiedad listPropiedadById(int propiedad_id) {
		return propiedadRepository.findById(propiedad_id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No se encontro la propiedad con id: " + propiedad_id));
	}

}
