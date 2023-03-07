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

	// Constructor de la clase Pelicula
	public Pelicula(String titulo, int año, int id) {
		this.titulo = titulo;
		this.año = año;
		this.id = id;
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
		return "Id: " +this.id+ " Titul: " + this.titulo + " / Año: " + this.año;
	}
}
