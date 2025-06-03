package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Cuarto;
import com.springboot.service.FavoritoService;

@RestController
@RequestMapping("/api/favorito")
public class FavoritoController {

	@Autowired
	private FavoritoService favoritoService;
	
	@GetMapping("/{usuario_id}")
	public List<Cuarto> listByUsuario(@PathVariable("usuario_id") int usuario_id){
		return favoritoService.listarFavoriteByUser(usuario_id);
	}
	
	
}
