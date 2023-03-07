package com.projecte.sergi;

import java.util.ArrayList;
import java.util.List;

public class ClaseUsuari {
	// atributs
	 private List<Actor> actor = new ArrayList<>();
     private List<Pelicula> peliculas = new ArrayList<>();
     private List<Director> director = new ArrayList<>();
     
	private String nom;
	private String cognoms;
	private String DNI;
	private int telefono;
	private String contrasenya;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public ClaseUsuari(String nom, String cognoms, String dNI, int telefono, String contrasenya) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		DNI = dNI;
		this.telefono = telefono;
		this.contrasenya = contrasenya;
	}

}
