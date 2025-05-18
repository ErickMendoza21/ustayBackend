package com.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Cuarto;
import com.springboot.entity.Propiedad;
import com.springboot.service.CuartoService;
import com.springboot.service.PropiedadService;

@RestController
@RequestMapping("/api/cuarto")
public class CuartoController {

	@Autowired
	private CuartoService cuartoService;
	
	@Autowired
	private PropiedadService propiedadService;

	@GetMapping("/listar")
	public List<Cuarto> getCuartos() {
		return cuartoService.list();
	}

	@GetMapping("/listarByDisponibilidad")
	public List<Cuarto> getCuartoDisponibles() {
		return cuartoService.listarCuartosDisponibles();
	}

	@GetMapping("/listarById/{id}")
	public Cuarto getCuartoById(@PathVariable("id") int cuarto_id) {
		return cuartoService.listCuartoById(cuarto_id);
	}

	@GetMapping("/listarByPropiedad/{id}")
	public List<Cuarto> getCuartoByPropiedad(@PathVariable("id") int propiedad_id) {
		Propiedad propiedad = propiedadService.listPropiedadById(propiedad_id);
		return cuartoService.listarCuartosByPropiedad(propiedad);
	}

	@PostMapping("/save")
	public Cuarto save(@RequestBody Cuarto cuarto) {
		return cuartoService.saveCuarto(cuarto);
	}

	@PutMapping("/edit/{id}")
	public Cuarto edit(@PathVariable("id") int cuarto_id, @RequestBody Cuarto cuarto) {
		return cuartoService.editCuarto(cuarto_id, cuarto);
	}

}
