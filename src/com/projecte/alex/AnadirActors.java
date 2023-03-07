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
import com.projecte.sergi.Actor;

public class AnadirActors {
	
	private static List <Actor> actors = new ArrayList<>();
	

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public static void pedirInfo() throws IOException {
		Scanner entrada = new Scanner(System.in);
		String nombre;
		String nacionalidad;
		String genero;
		
		System.out.println("Nombre Actor: ");
		nombre = entrada.nextLine();
		System.out.println("Nacionalidad: ");
		nacionalidad = entrada.nextLine();
		System.out.println("Genere: ");
		genero = entrada.nextLine();
		
		int id = saberId();
		
//		Actor p1 = new Actor("Clint Eastwood", "Estados Unidos", "Masculino");
//		Actor p2 = new Actor("Kirk Douglas", "Estados Unidos", "Masculino");
//		actors.add(p1);
//		actors.add(p2);
		Actor p = new Actor(nombre, nacionalidad, genero, id);
		actors.add(p);
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/ActorssGenerals.llista", true);
			oos = new ObjectOutputStream(fout);
			//escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(actors);
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
		m.mostraractors();

	}
	
	public static void mostrarActors() {
		
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Dades/ActorssGenerals.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				actors = (ArrayList<Actor>) reader.readObject();
				System.out.println("Dades dels usuaris");
				for (Actor usuari : actors) {
					  System.out.println(usuari.toString());
					}
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
			Menu2 m = new Menu2();
			m.mostraractors();
		} catch (Exception ex) {
			System.err.println("Error en llegir usuaris.dades " + ex);
		}
	}
	
	public static int saberId() throws IOException {
		File f = new File("contadoresId/contadorIdActors.txt");
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
}
