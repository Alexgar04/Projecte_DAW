package com.projecte.miquel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.projecte.sergi.ClasePelicula;
import com.projecte.sergi.ClasePelicula.Pelicula;

public class AñadirPelicula {

private static ArrayList<Pelicula> llistaPelicules = new ArrayList<Pelicula>();
	
	public static ArrayList<Pelicula> getLlistaPelicules() {
		return llistaPelicules;
	}

	public static void setLlistaPelicules(ArrayList<Pelicula> llistaPelicules) {
		AñadirPelicula.llistaPelicules = llistaPelicules;
	}

	public static void añadirPeliculaGeneral() {
		Scanner entrada = new Scanner(System.in);
		// Crear ArrayList de Pelicules

		System.out.println("Introdueix la informació demanada de la pelicula que vols anyadir");
		// Titol de la pelicula i comprobacio
		System.out.println("Titol de la pelicula");
		String anyadirTitol = "";
		do {
			anyadirTitol = entrada.nextLine();
			anyadirTitol.trim();
			if (anyadirTitol.equals("")) {
				System.out.println("La cadena no pot estar buida");
			}
		} while (anyadirTitol.equals(""));

		// Any de la pelicula i comprobacio
		System.out.println("Any d'estreno de la pelicula");
		int anyadirAny = 0;
		do {
			while (!entrada.hasNextInt()) {
				System.out.println("El valor introduit no es un número");
			}
			anyadirAny = entrada.nextInt();
			if (anyadirAny < 1903 || anyadirAny > 2023) {
				System.out.println("La pelicula no es va poder estrenar en ixe any, introdueix un altre");
			}
		} while (anyadirAny < 1903 || anyadirAny > 2023);

		// Pais de la pelicula i comprobacio
		System.out.println("Pais on es va fer la pelicula");
		String anyadirPais = "";
		do {
			anyadirPais = entrada.nextLine();
			anyadirPais.trim();
			if (anyadirPais.equals("")) {
				System.out.println("La cadena no pot estar buida");
			}
		} while (anyadirPais.equals(""));

		// Genere de la pelicula i comprobacio
		System.out.println("Genere de la pelicula");
		String anyadirGenere = "";
		do {
			anyadirGenere = entrada.nextLine();
			anyadirGenere.trim();
			if (anyadirGenere.equals("")) {
				System.out.println("La cadena no pot estar buida");
			}
		} while (anyadirGenere.equals(""));

		 // Llegir datos existents en el codi per a que no sobreescribisca els datos
        try {
            FileInputStream fileIn = new FileInputStream("Dades/PeliculesGenerals.llista");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            llistaPelicules = (ArrayList<Pelicula>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            // Si el archivo no existe todavía, simplemente creamos una nueva lista
            System.out.println("El archivo no existe todavía");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        //Crear pelicula amb els datos i anyadirla al array
		Pelicula p1 = new Pelicula(anyadirTitol, anyadirAny, anyadirPais, anyadirGenere);
		llistaPelicules.add(p1);

		// serialització
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/PeliculesGenerals.llista", false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(llistaPelicules);
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
		System.out.println("Pelicula anyadida correctament");
	}

	public static void mostrarPeliculesGenerals(ArrayList<Pelicula>llistaPelicules) {
		// desserialització
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Dades/PeliculesGenerals.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//Faltaria comprobar si no hi ha ningun objecte
				
				// llegim l'objecte que hi ha al fitxer (1 sol array List)
				llistaPelicules = (ArrayList<Pelicula>) reader.readObject();
				System.out.println("Dades de les pelicules");
				for (Pelicula pelicula : llistaPelicules) {
					System.out.println(pelicula.toString());
				}
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
			System.err.println("No hi ha ninguna pelicula en la llista, anyadis");
		}
	}
}
