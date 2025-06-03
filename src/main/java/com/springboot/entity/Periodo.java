package com.springboot.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Periodo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int periodo_id;
	private String periodo;

	@OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Cuarto> cuarto;

	public Periodo() {
	}

	public Periodo(String periodo) {
		this.periodo = periodo;
	}

	public int getPeriodo_id() {
		return periodo_id;
	}

	public void setPeriodo_id(int periodo_id) {
		this.periodo_id = periodo_id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
