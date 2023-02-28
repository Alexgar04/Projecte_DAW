package com.projecte.miquel;

public class Rol {

	//Atributs
		protected String nom;
		protected String contraseña;
		protected String correo;
		
		//Constructor
		public Rol(String nom, String contraseña, String correo) {
			this.nom = nom;
			this.contraseña = contraseña;
			this.correo = correo;
		}
		
		//Getters i Setters
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		
		//Mètodes
		public void añadirPeliculas() {
			
		}
		
		public void añadirDirectores() {
			
		}

		public void añadirActores() {
		
		}
		
		public String mostrarInformacio() {
			return "[Nom: " + this.nom +"]" +
					"[Contraseña: " + this.contraseña +"]" + "[Correo: " + this.correo +"]";
		}
}
