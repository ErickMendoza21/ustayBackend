package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Periodo;
import com.springboot.service.PeriodoService;

@RestController
@RequestMapping("/api/periodo")
public class PeriodoController {

	@Autowired
	private PeriodoService periodoService;
	
	@GetMapping("/listar")
	public List<Periodo> listar(){
		return periodoService.listar();
	}
	
}
