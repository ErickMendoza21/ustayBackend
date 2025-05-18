package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Propiedad;
import com.springboot.service.PropiedadService;

@RestController
@RequestMapping("/api/propiedad")
public class PropiedadController {

	@Autowired
	private PropiedadService propiedadService;

	@GetMapping("/listarById/{id}")
	public Propiedad listargetPropiedadById(@PathVariable("id") int propiedad_id) {
		return propiedadService.listPropiedadById(propiedad_id);
	}
	
	
}
