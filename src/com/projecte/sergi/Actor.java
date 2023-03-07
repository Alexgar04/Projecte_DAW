package com.projecte.sergi;

	public class Actor {
		// Atributos de la clase Actor
		private String nombre;
		private String nacionalidad;
		private int edad;
		private String genero;

		// Constructor de la clase Actor
		public Actor(String nombre, String nacionalidad, int edad, String genero) {
			this.nombre = nombre;
			this.nacionalidad = nacionalidad;
			this.edad = edad;
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

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}
	
}
