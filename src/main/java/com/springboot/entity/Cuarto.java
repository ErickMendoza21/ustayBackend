package com.springboot.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cuarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cuarto_id;
	private double precio;
	private String nombre;
	private String dimensiones;
	private int n_piso;
	private int n_cuarto;
	private String descripcion;
	private boolean disponibilidad;
	private String informacion_adicional;

	@ManyToOne
	@JoinColumn(name = "propiedad_id", nullable = false)
	private Propiedad propiedad;

	@ManyToOne
	@JoinColumn(name = "periodo_id", nullable = false)
	private Periodo periodo;

	@ManyToOne
	@JoinColumn(name = "tipo_id", nullable = false)
	private Tipo tipo;
	
	@OneToMany(mappedBy = "cuarto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Favorito> favorito;
	
	public Cuarto() {
	}

	public Cuarto(int cuarto_id, double precio, String nombre, String dimensiones, int n_piso, int n_cuarto,
			String descripcion, boolean disponibilidad, String informacion_adicional, Propiedad propiedad,
			Periodo periodo, Tipo tipo) {
		this.cuarto_id = cuarto_id;
		this.precio = precio;
		this.nombre = nombre;
		this.dimensiones = dimensiones;
		this.n_piso = n_piso;
		this.n_cuarto = n_cuarto;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
		this.informacion_adicional = informacion_adicional;
		this.propiedad = propiedad;
		this.periodo = periodo;
		this.tipo = tipo;
	}



	public int getCuarto_id() {
		return cuarto_id;
	}

	public void setCuarto_id(int cuarto_id) {
		this.cuarto_id = cuarto_id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public int getN_piso() {
		return n_piso;
	}

	public void setN_piso(int n_piso) {
		this.n_piso = n_piso;
	}

	public int getN_cuarto() {
		return n_cuarto;
	}

	public void setN_cuarto(int n_cuarto) {
		this.n_cuarto = n_cuarto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getInformacion_adicional() {
		return informacion_adicional;
	}

	public void setInformacion_adicional(String informacion_adicional) {
		this.informacion_adicional = informacion_adicional;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}
