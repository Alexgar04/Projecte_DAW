package com.projecte.sergi;

import java.io.Serializable;

public class Director implements Serializable {
		// Atributos de la clase Director
		private String nombre;
		private String nacionalidad;
		private String genero;
		private int id;
		private  String nomCreador;
		
		// Constructor de la clase Director
		public Director(String nombre, String nacionalidad, String genero, int id) {
			this.nombre = nombre;
			this.nacionalidad = nacionalidad;
			this.genero = genero;
			this.id = id;
			
		}
		
		public Director(String nombre, String nacionalidad, String genero, int id,String nomCreador) {
			this.nombre = nombre;
			this.nacionalidad = nacionalidad;
			this.genero = genero;
			this.id = id;
			this.setNomCreador(nomCreador);
			
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
			return "Id: "+id+ " Nom: " + nombre + ", Nacionalitat: " + nacionalidad + ", Genere: " + genero+" / Creador: "+this.nomCreador;
		}

		public String getNomCreador() {
			return nomCreador;
		}

		public void setNomCreador(String nomCreador) {
			this.nomCreador = nomCreador;
		}
		
		
		
		
	}

