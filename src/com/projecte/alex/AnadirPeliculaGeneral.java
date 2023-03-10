package com.projecte.alex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.projecte.eric.Menu2;
import com.projecte.sergi.Pelicula;

public class AnadirPeliculaGeneral{
	
	private static List <Pelicula> pelicules = new ArrayList<>();
	static Scanner entrada = new Scanner(System.in);
	
	public static List<Pelicula> getPelicules() {
		return pelicules;
	}


	public void setPelicules(List<Pelicula> pelicules) {
		this.pelicules = pelicules;
	}


	public static void pedirInfo() throws IOException {

		Scanner entrada = new Scanner(System.in);
		String pelicula;
		int any;
		System.out.println("Dime que película vols");
		pelicula = nomPelicula();
		System.out.println("De quin any es la pelicula");
		any = anyPelicula();
		int id = saberId();
		
		// Llegir datos existents en el codi per a que no sobreescribisca els datos
        try {
            FileInputStream fileIn = new FileInputStream("Dades/PeliculesGenerals.llista");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pelicules = (List<Pelicula>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            // Si el archivo no existe todavía, simplemente creamos una nueva lista
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
		Pelicula p = new Pelicula(pelicula, any, id);
		pelicules.add(p);
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/PeliculesGenerals.llista", false);
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
		
	}
	
	public static void ficarPeliculesDefecte() {
		File f = new File("Dades/PeliculesGenerals.llista");
		pelicules.add(new Pelicula("Avatar", 2010, 1));
		pelicules.add(new Pelicula("Campeones", 2018, 2));
		pelicules.add(new Pelicula("Seven", 2004, 3));
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/PeliculesGenerals.llista", false);
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
	}
	public static void mostrarPelicules() {
		
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Dades/PeliculesGenerals.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				pelicules = (ArrayList<Pelicula>) reader.readObject();
				System.out.println("Películes en la llista general");
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
				for (Pelicula usuari : pelicules) {
					  System.out.println(usuari.toString());
					}
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
			Menu2 m = new Menu2();
		} catch (Exception ex) {
			System.out.println("No hi han pelicules encara, fica'n");
		}
	}
	
	
	public static int saberId() throws IOException {
		File f = new File("contadoresId/contadorIdPelis.txt");
	    int id;
	    
	    // Abrir archivo para lectura
	    try (Scanner leer = new Scanner(f)) {
	        if (f.length() == 0) {
	            // Si el archivo está vacío, escribir "0" y devolver 0
	            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
	                bw.write("0");
	            }
	            return 0;
	        } else {
	            // Leer valor actual de id
	            id = leer.nextInt();
	            // Incrementar id
	            id++;
	        }
	    }
	    
	    // Escribir nuevo valor de id en el archivo
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
	        bw.write(String.valueOf(id));
	    }
	    
	    return id;
	}

	public static String nomPelicula() {
		String nacionalitat;
		do {
			nacionalitat = entrada.nextLine();
			nacionalitat.trim();
			if(nacionalitat.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			}
		}while(nacionalitat.equals(""));	
		return nacionalitat;
	}
	
	public static int anyPelicula() {
		int n;
		do {
			while (!entrada.hasNextInt()) {
				System.out.println("El valor introduit no és un número");
				entrada.next();
			}
			n = entrada.nextInt();
			if (n < 1940 || n > 2023) {
				System.out.println("El valor introduit está fora del rang");
			}
		} while (n < 1940 || n > 2023);
		
		return n;
	}
	
}
	



