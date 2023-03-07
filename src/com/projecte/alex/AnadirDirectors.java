package com.projecte.alex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.projecte.eric.Menu2;
import com.projecte.sergi.Actor;
import com.projecte.sergi.Director;

public class AnadirDirectors {
	private static List <Director> directors = new ArrayList<>();

	public static List<Director> getDirectors() {
		return directors;
	}

	public static void setDirectors(List<Director> directors) {
		AnadirDirectors.directors = directors;
	}
	
	public static void pedirInfo() {
		Scanner entrada = new Scanner(System.in);
		String nombre;
		String nacionalidad;
		String genero;
		
		System.out.println("Nombre Director: ");
		nombre = entrada.nextLine();
		System.out.println("Nacionalidad: ");
		nacionalidad = entrada.nextLine();
		System.out.println("Genere: ");
		genero = entrada.nextLine();
		
		Director p = new Director(nombre, nacionalidad, genero);
		directors.add(p);
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/DirectorsGenerals.llista", false);
			oos = new ObjectOutputStream(fout);
			//escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(directors);
			oos.flush();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		Menu2 m = new Menu2();
		m.mostrardirectors();
		
	}
	
	public static void mostrarDirectors() {
		
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Dades/DirectorsGenerals.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				directors = (ArrayList<Director>) reader.readObject();
				System.out.println("Dades dels usuaris");
				for (Director usuari : directors) {
					  System.out.println(usuari.toString());
					}
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
			Menu2 m = new Menu2();
			m.mostrardirectors();
		} catch (Exception ex) {
			System.err.println("Error en llegir usuaris.dades " + ex);
		}
	}
}
