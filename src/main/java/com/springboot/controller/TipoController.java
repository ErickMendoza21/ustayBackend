package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Tipo;
import com.springboot.service.TipoService;

@RestController
@RequestMapping("/api/tipo")
public class TipoController {

	@Autowired
	private TipoService tipoService;
	
	@GetMapping("/listar")
	public List<Tipo> listar() {
		return tipoService.listar();
	}
	
}
