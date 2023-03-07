package com.projecte.sergi;

import java.io.Serializable;

public class Director implements Serializable {
		// Atributos de la clase Director
		private String nombre;
		private String nacionalidad;
		private String genero;

		// Constructor de la clase Director
		public Director(String nombre, String nacionalidad, String genero) {
			this.nombre = nombre;
			this.nacionalidad = nacionalidad;
			this.genero = genero;
		}

		// Métodos getter y setter para cada atributo
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getNacionalidad() {
			return nacionalidad;
		}

		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		@Override
		public String toString() {
			return "Nombre: " + nombre + ", Nacionalidad: " + nacionalidad + ", Genero: " + genero;
		}
		
		
		
		
	}

