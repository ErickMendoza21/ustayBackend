package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Cuarto;
import com.springboot.repository.FavoritoRepository;

@Service
public class FavoritoService {

	@Autowired
	private FavoritoRepository favoritoRepository;
	
	public List<Cuarto> listarFavoriteByUser(int usuario_id){
		return favoritoRepository.findCuartosFavoritosByUsuarioId(usuario_id);
	}
	


	
}
