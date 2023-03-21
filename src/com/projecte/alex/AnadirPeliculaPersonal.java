package com.projecte.alex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.projecte.eric.Menu2;
import com.projecte.hector.IniciSesio;
import com.projecte.sergi.Pelicula;

public class AnadirPeliculaPersonal {

	private static List<Pelicula> peliculesPersonals = new ArrayList<Pelicula>();
	private String nomUsuari;

	public static void añadirPeliculaPersonal() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Que pelicula vols anyadir a la teua llista");
		AnadirPeliculaGeneral.mostrarPelicules();
		int n = 0;
		int num_max = idPeli();
		do {
			while(!entrada.hasNextInt()) {
				System.out.println("El valor no és un número");
			}
			n = entrada.nextInt();
			
			if(n < 0 || n > num_max) {
				System.out.println("El valor esta fora del rang");
			}
		}while(n < 0 || n > num_max);
		
		List<Pelicula> pelicules = AnadirPeliculaGeneral.getPelicules();

		String nomUsuari = IniciSesio.getUsuario();
		for(Pelicula pelicula : pelicules) {
			if(n == pelicula.getId()) {
				// Llegir datos existents en el codi per a que no sobreescribisca els datos
		        try {
		            FileInputStream fileIn = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Pelicules.llista");
		            ObjectInputStream in = new ObjectInputStream(fileIn);
		            peliculesPersonals = (List<Pelicula>) in.readObject();
		            in.close();
		            fileIn.close();
		        } catch (IOException e) {
		            // Si el archivo no existe todavía, simplemente creamos una nueva lista
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        
				peliculesPersonals.add(pelicula);
				
				ObjectOutputStream oos = null;
				FileOutputStream fout = null;
				try {
					//obrim el fitxer per escriure, sense afegir
					//només tindrem un ArrayList d'objectes
					fout = new FileOutputStream("Usuarios/"+nomUsuari+"/dades/Pelicules.llista", false);
					oos = new ObjectOutputStream(fout);
					//escrivim ArrayList sencer en el fitxer (1 sol objecte)
					oos.writeObject(peliculesPersonals);
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
		}
		
	}
	
	public static int idPeli() {
		File file = new File("contadoresId/contadorIdPelis.txt");
		int number = 0;
		try {
			Scanner scanner = new Scanner(file);
			number = scanner.nextInt();
			scanner.close();
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return number;
	}
	
	public static void mostrarPeliculasPersonal() {
		String nomUsuari = IniciSesio.getUsuario();

		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Pelicules.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				peliculesPersonals = (ArrayList<Pelicula>) reader.readObject();
				System.out.println("Pelicules en la llista personal");
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
				for (Pelicula usuari : peliculesPersonals) {
					  System.out.println(usuari.toString());
					}
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
			System.out.println("No hi han pelicules en la llista personal encara, fica'n");
		}
	}
}
