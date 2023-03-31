package com.projecte.hector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.projecte.alex.AnadirPeliculaGeneral;
import com.projecte.eric.Menu2;
import com.projecte.sergi.Actor;
import com.projecte.sergi.Pelicula;

public class ComprobarActor {

	public static boolean comprobarActor(String nom) {

		ArrayList<Actor> comprobarActors = new ArrayList<Actor>();
		boolean diferente = false;
		try {
			FileInputStream fileIn = new FileInputStream("Dades/ActorsGenerals.dades");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			comprobarActors = (ArrayList<Actor>) in.readObject();

//			nom.trim().replace("  ", " ").replace(" ", "");

			for (Actor actors : comprobarActors) {

				String nombre = actors.getNombre().trim();
				if (nom.equalsIgnoreCase(nombre)) {

					
					System.out.println("Està repetit");
					Menu2 menu2 = new Menu2();
					menu2.mostraractors();
					 
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