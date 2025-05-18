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
public class Propiedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propiedad_id;
	private String reglas;
	private String descripcion;
	private String direccion;
	private boolean estado_verificacion;
	
	@OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Cuarto> cuarto;
	
	public Propiedad() {
		// TODO Auto-generated constructor stub
	}
	
	public Propiedad(int propiedad_id, String reglas, String descripcion, String direccion, boolean estado_verificacion,
			Cuarto cuarto) {
		this.propiedad_id = propiedad_id;
		this.reglas = reglas;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.estado_verificacion = estado_verificacion;
	}
	
	public int getPropiedad_id() {
		return propiedad_id;
	}

	public void setPropiedad_id(int propiedad_id) {
		this.propiedad_id = propiedad_id;
	}

	public String getReglas() {
		return reglas;
	}

	public void setReglas(String reglas) {
		this.reglas = reglas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEstado_verificacion() {
		return estado_verificacion;
	}

	public void setEstado_verificacion(boolean estado_verificacion) {
		this.estado_verificacion = estado_verificacion;
	}
}
