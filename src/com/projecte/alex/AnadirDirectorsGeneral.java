package com.projecte.alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.projecte.eric.Menu2;
import com.projecte.sergi.Director;
import com.projecte.sergi.Pelicula;

public class AnadirDirectorsGeneral {
	private static List <Director> directors = new ArrayList<>();
	static Scanner entrada = new Scanner(System.in);
	
	public static List<Director> getDirectors() {
		return directors;
	}

	public static void setDirectors(List<Director> directors) {
		AnadirDirectorsGeneral.directors = directors;
	}
	
	public static void pedirInfo() throws IOException {
		Scanner entrada = new Scanner(System.in);
		String nombre;
		String nacionalidad;
		String genero;
		
		System.out.println("Nombre Director: "); 
		nombre = nombreDirector(); 
		System.out.println("Nacionalidad: "); 
		nacionalidad = nacionalitatDirector(); 
		System.out.println("Genere(M/F): "); 
		genero = comprobarGenere(); 
		int id = saberId();
		
		// Llegir datos existents en el codi per a que no sobreescribisca els datos
        try {
            FileInputStream fileIn = new FileInputStream("Dades/DirectorsGenerals.llista");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            directors = (List<Director>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            // Si el archivo no existe todavía, simplemente creamos una nueva lista
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		Director p = new Director(nombre, nacionalidad, genero, id);
		
		
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
			File f = new File("");
			FileInputStream file = new FileInputStream("Dades/DirectorsGenerals.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				
				System.out.println("Dades dels usuaris");
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				directors = (ArrayList<Director>) reader.readObject();
	            for (Director usuari : directors) {
					  System.out.println(usuari.toString());
				}	
	            
				
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
			Menu2 m = new Menu2();
		} catch (Exception ex) {
			System.out.println("No hi han directors encara, fica'n");
		}
	}
	
	public static void ficarDirectorsDefecte() {
		File f = new File("Dades/DirectorsGenerals.llista");
		directors.add(new Director("Vicente", "España", "M", 1));
		directors.add(new Director("Jesus", "Francia", "M", 2));
		directors.add(new Director("Will", "Inglaterra", "M", 3));
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
	}
	
	public static int saberId() throws IOException {
		File f = new File("contadoresId/contadorIdDirectors.txt");
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
	
	public static String nombreDirector() {
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
	
	public static String nacionalitatDirector() {
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
