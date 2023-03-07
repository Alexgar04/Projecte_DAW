package com.projecte.sergi;

import java.io.Serializable;

public class Pelicula implements Serializable {
	// Atributos de la clase Pelicula
	private static int contador = 0;
	private int id;


	private String titulo;
	private int año;

	// Constructor de la clase Pelicula
	public Pelicula(String titulo, int año, int id) {
		contador++;
		this.id = contador;
		this.titulo = titulo;
		this.año = año;

	}

	// Métodos getter y setter para cada atributo
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
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
		return "["+ "id= " + id + ", Titul: " + this.titulo + " / Año: " + this.año + " ]";
	}
}
