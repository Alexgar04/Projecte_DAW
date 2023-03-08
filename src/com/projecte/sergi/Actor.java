package com.projecte.sergi;

import java.io.Serializable;

public class Actor implements Serializable {
		// Atributos de la clase Actor
		private String nombre;
		private String nacionalidad;
		private String genero;
		private int id;
		// Constructor de la clase Actor
		public Actor(String nombre, String nacionalidad, String genero, int id) {
			this.nombre = nombre;
			this.nacionalidad = nacionalidad;
			this.genero = genero;
			this.id = id;
		}

		// Métodos getter y setter para cada atributo
		
		
		public String getNombre() {
			return nombre;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
			return "Id: "+ id + " Nombre: " + nombre + ", Nacionalidad: " + nacionalidad + ", Genero: " + genero;
		}
		
		
	
}
