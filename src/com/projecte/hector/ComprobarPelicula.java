package com.projecte.hector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.projecte.alex.AnadirPeliculaGeneral;
import com.projecte.eric.Menu2;
import com.projecte.sergi.Pelicula;

public class ComprobarPelicula {

	public static boolean comprobarPelicula(String nom) {

		ArrayList<Pelicula> comprobarPelicules = new ArrayList<Pelicula>();
		boolean diferente = false;
		try {
			FileInputStream fileIn = new FileInputStream("Dades/PeliculesGenerals.dades");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			comprobarPelicules = (ArrayList<Pelicula>) in.readObject();

//			nom.trim().replace("  ", " ").replace(" ", "");

			for (Pelicula pelicula : comprobarPelicules) {

				String titulo = pelicula.getTitulo().trim();
				if (nom.equalsIgnoreCase(titulo)) {

					
					System.out.println("Está repetit");
					Menu2 menu2 = new Menu2();
					menu2.mostrarpelicules();
					 
				} else {

					diferente = false;
				}

			}

			in.close();
			fileIn.close();

		} catch (IOException e) {
			// Si el archivo no existe todavía, simplemente creamos una nueva lista
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return diferente;

	}

}
