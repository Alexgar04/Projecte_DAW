package com.projecte.sergi;

import java.io.Serializable;

public class ClasePelicula {
	public class Pelicula implements Serializable{
	    // Atributos de la clase Pelicula
	    private String titulo;
	    private int año;
	    private String pais;
	    private String genero;

	    // Constructor de la clase Pelicula
	    public Pelicula(String titulo, int año, String pais, String genero) {
	        this.titulo = titulo;
	        this.año = año;
	        this.pais = pais;
	        this.genero = genero;
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

	    public String getPais() {
	        return pais;
	   }

	   public void setPais(String pais) {
	       this.pais = pais;
	   }

	   public String getGenero() {
	       return genero;
	   }

	   public void setGenero(String genero) {
	       this.genero = genero;
	   }
	   
	   public String toString() {
			return "[Titul: "+this.titulo+" / Año: "+this.año+" / Pais: "+this.pais+ " / Genere: "+this.genero + " ]";
		}
	}
}
