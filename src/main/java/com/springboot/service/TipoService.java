package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Tipo;
import com.springboot.repository.TipoRepository;


@Service
public class TipoService {

	@Autowired
	private TipoRepository tipoRepository;
	
	public List<Tipo> listar(){
		return tipoRepository.findAll();
	}

}
