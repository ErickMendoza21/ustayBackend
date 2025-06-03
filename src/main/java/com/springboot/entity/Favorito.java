package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favorito_id;

	@ManyToOne
	@JoinColumn(name = "cuarto_id", nullable = false)
	private Cuarto cuarto;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public Favorito() {
	
	}
	
	public Favorito(Cuarto cuarto, Usuario usuario) {
		this.cuarto = cuarto;
		this.usuario = usuario;
	}



	public int getFavorito_id() {
		return favorito_id;
	}

	public void setFavorito_id(int favorito_id) {
		this.favorito_id = favorito_id;
	}

	public Cuarto getCuarto() {
		return cuarto;
	}

	public void setCuarto(Cuarto cuarto) {
		this.cuarto = cuarto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
