package com.projecte.miquel;

public class Admin extends Rol {

	public Admin(String nom, String contraseña, String correo) {
		super(nom, contraseña, correo);
		this.nom = "admin";
		this.contraseña = "";
		this.correo = "";
	}

	//Mètode que sols podrà fer l'admin
	public void eliminarUsuaris() {
		
	}
	
	public void mostrarUsuaris() {
		
	}
}
