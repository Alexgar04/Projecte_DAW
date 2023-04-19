package com.projecte.sergi;

import java.io.Serializable;

public class Pelicula implements Serializable {
	// Atributos de la clase Pelicula
	private String titulo;
	
	
	//private static int contador;
	private int id;
	private int año;
	private String pais;
	private String genero;
	private String nomCreador;

	// Constructor de la clase Pelicula
	public Pelicula(String titulo, int año, int id) {
		this.titulo = titulo;
		this.año = año;
		this.id = id;
	}
	
	public Pelicula(String titulo, int año, int id, String nomCreador) {
		this.titulo = titulo;
		this.año = año;
		this.id = id;
		this.nomCreador=nomCreador;
	}

	// Métodos getter y setter para cada atributo	
	public String getTitulo() {
		return titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String toString() {
		return "Id: " +this.id+ " Titul: " + this.titulo + " / Año: " + this.año+ " / Creador: "+this.nomCreador;
	}

	public String getNomCreador() {
		return nomCreador;
	}

	public void setNomCreador(String nomCreador) {
		this.nomCreador = nomCreador;
	}
}
