package com.projecte.sergi;

import java.io.Serializable;

public class Pelicula implements Serializable {
	// Atributos de la clase Pelicula
	private String titulo;
	private int año;
	private String pais;
	private String genero;

	// Constructor de la clase Pelicula
	public Pelicula(String titulo, int año) {
		this.titulo = titulo;
		this.año = año;

	}

	// Métodos getter y setter para cada atributo
	public String getTitulo() {
		return titulo;
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
		return "[Titul: " + this.titulo + " / Año: " + this.año + " ]";
	}
}
