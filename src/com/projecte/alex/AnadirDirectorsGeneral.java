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
import com.projecte.hector.ComprobarDirector;
import com.projecte.hector.IniciSesio;
import com.projecte.sergi.Director;

public class AnadirDirectorsGeneral {
	private static List<Director> directors = new ArrayList<>();
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

		boolean difer = false;
		int id;
		
		do {
		System.out.println("Nombre Director: ");
		nombre = nombreDirector();
		difer = ComprobarDirector.comprobarDirector(nombre);
		System.out.println("Nacionalidad: ");
		nacionalidad = nacionalitatDirector();
		System.out.println("Genere(M/F): ");
		genero = comprobarGenere();
		id = saberId(true);
		
		
		
		} while (difer);

		// Llegir datos existents en el codi per a que no sobreescribisca els datos
		try {
			FileInputStream fileIn = new FileInputStream("Dades/DirectorsGenerals.dades");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			directors = (List<Director>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {
			// Si el archivo no existe todavía, simplemente creamos una nueva lista
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Director p = new Director(nombre, nacionalidad, genero, id,IniciSesio.arrayLinea[1]);

		directors.add(p);

		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			// obrim el fitxer per escriure, sense afegir
			// només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("Dades/DirectorsGenerals.dades", false);
			oos = new ObjectOutputStream(fout);
			// escrivim ArrayList sencer en el fitxer (1 sol objecte)
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
			FileInputStream file = new FileInputStream("Dades/DirectorsGenerals.dades");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {

				
				// llegim l'objecte que hi ha al fitxer (1 sol array List)
				directors = (ArrayList<Director>) reader.readObject();
				if (directors.size() > 0) {
					System.out.println("Dades dels directors");
					System.out.println(
							" +----------------------------------------------------------------------------------------+ ");
					for (Director usuari : directors) {
						System.out.println(usuari.toString());
					}
					System.out.println(
							" +----------------------------------------------------------------------------------------+ ");

				}else {
					System.out.println("No hi ha cap en la llista");
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
		File f = new File("Dades/DirectorsGenerals.dades");
		if (!f.exists()) {
			directors.add(new Director("Vicente Belda Navarro", "España", "M", 1,"Default"));
			directors.add(new Director("Jesus Briones Ubon", "Francia", "M", 2,"Default"));
			directors.add(new Director("Will Smith Pechugon", "Inglaterra", "M", 3,"Default"));
			ObjectOutputStream oos = null;
			FileOutputStream fout = null;
			try {
				// obrim el fitxer per escriure, sense afegir
				// només tindrem un ArrayList d'objectes
				fout = new FileOutputStream("Dades/DirectorsGenerals.dades", false);
				oos = new ObjectOutputStream(fout);
				// escrivim ArrayList sencer en el fitxer (1 sol objecte)
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
	}

	public static int saberId(boolean incrementar) throws IOException {
	    File f = new File("contadoresId/contadorIdDirectors.txt");
	    int id;

	    // Obrir fitxer per a lectura
	    try (Scanner leer = new Scanner(f)) {
	        if (f.length() == 0) {
	            // Si el fitxer està buit, escriure "0" i retornar 0
	            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
	                bw.write("0");
	            }
	            return 0;
	        } else {
	            // Llegir valor actual de id
	            id = leer.nextInt();
	            // Incrementar id si s'indica
	            if (incrementar) {
	                id++;
	            }
	        }
	    }

	    // Escriure nou valor de id en el fitxer
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
	        bw.write(String.valueOf(id));
	    }

	    return id;
	}

	public static String nombreDirector() {
		
		String nombre = "";
		nombre = nombre.toLowerCase();
		do {
			nombre = entrada.nextLine();
			nombre.trim();
			if (nombre.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			} else if (!Pattern.compile("^[A-Za-z][a-z]+ [A-Za-z][a-z]+ [A-Za-z][a-z]+$").matcher(nombre).matches()) {
				System.out.println("Té que estar compost per el nom i els dos cognoms");
			}
		} while (nombre.equals("") || !Pattern.compile("^[A-Za-z][a-z]+ [A-Za-z][a-z]+ [A-Za-z][a-z]+$").matcher(nombre).matches());
		return nombre;
	}

	public static String nacionalitatDirector() {
		String nacionalitat;
		do {
			nacionalitat = entrada.nextLine();
			nacionalitat.trim();
			if (nacionalitat.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			}
		} while (nacionalitat.equals(""));
		return nacionalitat;
	}

	public static String comprobarGenere() {
		String genere;
		do {
			genere = entrada.nextLine();
			genere.trim();
			if (genere.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			} else if (!genere.equalsIgnoreCase("M") && !genere.equalsIgnoreCase("F")) {
				System.out.println("El genere introduit no exiseix, introdueix M o F");
			}
		} while (genere.equals("") || !genere.equalsIgnoreCase("M") && !genere.equalsIgnoreCase("F"));
		return genere;
	}
	public static void demanarIdEliminarDirector() {
		mostrarDirectors();
		int num = 0;
		try {
		    saberId(false);
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
			System.out.println("Introdueix el Id del actor que vols eliminar, per a cancelar l'operació escriu \"0\"");
			if (!entrada.hasNextInt()) {
				System.out.println("Lo que has introduit, no es un número");
				entrada.nextLine();
			} else {
				num = entrada.nextInt();
				while(num < 0 || num > 2147483647) {
					System.out.println("Numero invalido");
					num = entrada.nextInt();
				}
				if (num == 0) {
					Menu2 menu = new Menu2(); 
			        menu.menuAdminDirector(); 
				}else {
					// Eliminar un element del ArrayList
					boolean encontrado = false;
					
					for (int i = 0; i < directors.size(); i++) {
						if (directors.get(i).getId() == num) {
							directors.remove(i);
							encontrado = true;
							break;
						}
					}

					if (encontrado) {
						System.out.println("S'ha eliminat un director amb el id " + num + ".");
					} else {
						System.out.println("No s'ha encontrat ningún director amb el id " + num + ".");
					}

					// Serialitzar el ArrayList actualitzat en el arxiu
					try {
						FileOutputStream fileOut = new FileOutputStream("Dades/DirectorsGenerals.dades");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(directors);
						out.close();
						fileOut.close();
					} catch (IOException i) {
						i.printStackTrace();
					}
				}

				}
				
		

	}
}