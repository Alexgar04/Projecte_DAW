package com.projecte.hector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.projecte.alex.AnadirPeliculaGeneral;
import com.projecte.eric.Menu2;
import com.projecte.sergi.Director;
import com.projecte.sergi.Pelicula;

public class ComprobarDirector {

	public static boolean comprobarDirector(String nom) {

		ArrayList<Director> comprobarDirector = new ArrayList<Director>();
		boolean diferente = false;
		try {
			FileInputStream fileIn = new FileInputStream("Dades/DirectorsGenerals.dades");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			comprobarDirector = (ArrayList<Director>) in.readObject();

//			nom.trim().replace("  ", " ").replace(" ", "");

			for (Director director : comprobarDirector) {

				String nombre = director.getNombre().trim();
				if (nom.equalsIgnoreCase(nombre)) {
					System.out.println("Està repetit");
					Menu2 menu2 = new Menu2();
					menu2.mostrardirectors();
					 
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