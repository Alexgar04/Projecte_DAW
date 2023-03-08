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
import java.util.regex.Pattern;

import com.projecte.eric.Menu2;
import com.projecte.sergi.Actor;
import com.projecte.sergi.Pelicula;

public class AnadirActorsGeneral {
	
	private static List <Actor> actors = new ArrayList<>();
	static Scanner entrada = new Scanner(System.in);


	public static List<Actor> getActors() {
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
		nombre = nombreActor();
		System.out.println("Nacionalidad: ");
		nacionalidad = nacionalitatActor();
		System.out.println("Genere: ");
		genero = comprobarGenere();
		
		int id = saberId();
		
		
		
		// Llegir datos existents en el codi per a que no sobreescribisca els datos
        try {
            FileInputStream fileIn = new FileInputStream("Dades/ActorssGenerals.llista");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            actors = (List<Actor>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            // Si el archivo no existe todavía, simplemente creamos una nueva lista
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
//		Actor p1 = new Actor("Clint Eastwood", "Estados Unidos", "Masculino");
//		Actor p2 = new Actor("Kirk Douglas", "Estados Unidos", "Masculino");
//		actors.add(p1);
//		actors.add(p2);
        
     // Llegir datos existents en el codi per a que no sobreescribisca els datos
        try {
            FileInputStream fileIn = new FileInputStream("Dades/ActorsGenerals.llista");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            actors = (List<Actor>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            // Si el archivo no existe todavía, simplemente creamos una nueva lista
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
		Actor p = new Actor(nombre, nacionalidad, genero, id);
		actors.add(p);
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/ActorssGenerals.llista", false);
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
		

	}
	
	public static void ficarActorsDefecte() {
		File f = new File("Dades/ActorssGenerals.llista");
		actors.add(new Actor("Pedro", "España", "M", 1));
		actors.add(new Actor("Maria", "Colombia", "F", 2));
		actors.add(new Actor("David", "Ecuador", "M", 3));
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/ActorssGenerals.llista", false);
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
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
				for (Actor usuari : actors) {
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
			System.out.println("No hi han actors encara, fica'n");
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
	
	public static String nombreActor() {
		String nombre;
		do {
			nombre = entrada.nextLine();
			nombre.trim();
			if(nombre.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			}else if(!Pattern.compile("^[a-zA-Z]+$").matcher(nombre).matches()) {
				System.out.println("El nom sols pot tindre lletres i una sola palabra");
			}
		}while(nombre.equals("") || !Pattern.compile("^[a-zA-Z]+$").matcher(nombre).matches());	
		return nombre;
	}
	
	public static String nacionalitatActor() {
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
	
	public static String comprobarGenere() {
		String genere;
		do {
			genere = entrada.nextLine();
			genere.trim();
			if(genere.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			}else if(!genere.equalsIgnoreCase("M") && !genere.equalsIgnoreCase("F")) {
				System.out.println("El genere introduit no exiseix, introdueix M o F");
			}
		}while(genere.equals("") || !genere.equalsIgnoreCase("M") && !genere.equalsIgnoreCase("F"));	
		return genere;
	}
}
