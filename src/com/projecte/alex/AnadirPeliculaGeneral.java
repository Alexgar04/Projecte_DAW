package com.projecte.alex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.projecte.eric.Menu2;
import com.projecte.sergi.Pelicula;

public class AnadirPeliculaGeneral{
	
	private static List <Pelicula> pelicules = new ArrayList<>();
	
	
	public List<Pelicula> getPelicules() {
		return pelicules;
	}


	public void setPelicules(List<Pelicula> pelicules) {
		this.pelicules = pelicules;
	}


	public static void pedirInfo() {
		Scanner entrada = new Scanner(System.in);
		String pelicula;
		int any;
		System.out.println("Dime que pelicula quieres");
		pelicula = entrada.nextLine();
		System.out.println("De que año es la peli");
		any = entrada.nextInt();
		
		Pelicula p = new Pelicula(pelicula, any);
		pelicules.add(p);
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("usuaris.dades", false);
			oos = new ObjectOutputStream(fout);
			//escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(pelicules);
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
		m.mostrarpelicules();
		
	}
	
	public static void mostrarPelicules() {
		
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("usuaris.dades");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				pelicules = (ArrayList<Pelicula>) reader.readObject();
				System.out.println("Dades dels usuaris");
				for (Pelicula usuari : pelicules) {
					  System.out.println(usuari.toString());
					}
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
			Menu2 m = new Menu2();
			m.mostrarpelicules();
		} catch (Exception ex) {
			System.err.println("Error en llegir usuaris.dades " + ex);
		}
	}
	
	
	
	
	
}
	



