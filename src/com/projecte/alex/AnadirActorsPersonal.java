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

import com.projecte.hector.IniciSesio;
import com.projecte.sergi.Actor;

public class AnadirActorsPersonal {
	private static List<Actor> actorsPersonals = new ArrayList<Actor>();
	
	private String nomUsuari;

	public static void añadirActorPersonal() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Que actors vols anyadir a la teua llista");
		AnadirActorsGeneral.mostrarActors();
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
		
		List<Actor> actors = AnadirActorsGeneral.getActors();

		String nomUsuari = IniciSesio.getUsuario();
		for(Actor actor : actors) {
			if(n == actor.getId()) {
				// Llegir datos existents en el codi per a que no sobreescribisca els datos
		        try {
		            FileInputStream fileIn = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista.txt");
		            ObjectInputStream in = new ObjectInputStream(fileIn);
		            actorsPersonals = (List<Actor>) in.readObject();
		            in.close();
		            fileIn.close();
		        } catch (IOException e) {
		            // Si el archivo no existe todavía, simplemente creamos una nueva lista
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        
				actorsPersonals.add(actor);
				
				ObjectOutputStream oos = null;
				FileOutputStream fout = null;
				try {
					//obrim el fitxer per escriure, sense afegir
					//només tindrem un ArrayList d'objectes
					fout = new FileOutputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista.txt", false);
					oos = new ObjectOutputStream(fout);
					//escrivim ArrayList sencer en el fitxer (1 sol objecte)
					oos.writeObject(actorsPersonals);
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
		File file = new File("contadoresId/contadorIdActors.txt");
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
	
	public static void mostrarActorsPersonal() {
		String nomUsuari = IniciSesio.getUsuario();

		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista.txt");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				actorsPersonals = (ArrayList<Actor>) reader.readObject();
				System.out.println("Pelicules en la llista personal");
				for (Actor actor : actorsPersonals) {
					  System.out.println(actor.toString());
					}
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
			System.err.println("Error en llegir usuaris.dades " + ex);
		}
	}
}
