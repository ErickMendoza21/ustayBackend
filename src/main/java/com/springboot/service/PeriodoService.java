package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Periodo;
import com.springboot.repository.PeriodoRepository;

@Service
public class PeriodoService {

	@Autowired
	private PeriodoRepository periodoRepository;
	
	public List<Periodo> listar(){
		return periodoRepository.findAll();
	}

}
