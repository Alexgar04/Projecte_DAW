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
import com.projecte.hector.ComprobarActor;
import com.projecte.sergi.Actor;

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
		
		boolean difer = false;
		int id;
		do {
			
		
		System.out.println("Nom de l'actor: ");
		nombre = nombreActor();
		difer = ComprobarActor.comprobarActor(nombre);
		System.out.println("Nacionalitat: ");
		nacionalidad = nacionalitatActor();
		System.out.println("Gènere: ");
		genero = comprobarGenere();
		
		id = saberId(true);
		} while (difer);
		
		
		
		// Llegir datos existents en el codi per a que no sobreescribisca els datos
        try {
            FileInputStream fileIn = new FileInputStream("Dades/ActorsGenerals.dades");
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
            FileInputStream fileIn = new FileInputStream("Dades/ActorsGenerals.dades");
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
			fout = new FileOutputStream("Dades/ActorsGenerals.dades", false);
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
		File f = new File("Dades/ActorsGenerals.dades");
	    if (!f.exists()) {
	        actors.add(new Actor("Pedro Picapiedra Martinez", "Espanya", "M", 1));
	        actors.add(new Actor("Maria Vaño Blasco", "Colombia", "F", 2));
	        actors.add(new Actor("David Calatayud Gimenez", "Equador", "M", 3));
	        ObjectOutputStream oos = null;
	        FileOutputStream fout = null;
	        try {
	            fout = new FileOutputStream("Dades/ActorsGenerals.dades", false);
	            oos = new ObjectOutputStream(fout);
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
	}
	
	public static void mostrarActors() {
		
		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Dades/ActorsGenerals.dades");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				actors = (ArrayList<Actor>) reader.readObject();
				System.out.println("Dades dels actors");
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
			System.out.println("No hi ha actors encara, fica'n");
		}
	}
	
	public static int saberId(boolean incrementar) throws IOException {
        File f = new File("contadoresId/contadorIdActors.txt");
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
	
	public static String nombreActor() {
	    String nombre;
	    do {
	        nombre = entrada.nextLine();
	        nombre.trim();
	        if(nombre.equals("")) {
	            System.out.println("No pot estar la cadena buida, torna a introduir el nom");
	        } else if(!Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+$").matcher(nombre).matches()) {
	            System.out.println("Ha d'estar compost pel nom i els dos cognoms");
	        }
	    } while(nombre.equals("") || !Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+ [A-Z][a-z]+$").matcher(nombre).matches());	
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
			System.out.println("Introdueix el gènere. Utilitza 'M' per a home i 'F' per a dona.");
			genere = entrada.nextLine();
			genere.trim();
			if(genere.equals("")) {
				System.out.println("No pot estar la cadena buida, torna a introduir el nom");
			}else if(!genere.equalsIgnoreCase("M") && !genere.equalsIgnoreCase("F")) {
				System.out.println("El gènere introduït no existeix, introdueix M o F");
			}
		}while(genere.equals("") || !genere.equalsIgnoreCase("M") && !genere.equalsIgnoreCase("F"));	
		return genere;
	}
	public static void demanarIdEliminarActor() {
		mostrarActors();
		int num = 0;
		try {
            saberId(false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
			System.out.println("Introdueix l'Id del actor que vols eliminar, per a cancel·lar l'operació escriu \"0\"");
			if (!entrada.hasNextInt()) {
				System.out.println("El que has introduït, no és un número");
				entrada.nextLine();
			} else {
				num = entrada.nextInt();
				while(num < 0 || num > 2147483647) {
					System.out.println("Número invàlid");
					num = entrada.nextInt();
				}
				if (num == 0) {
					Menu2 menu = new Menu2(); 
			        menu.menuAdminActor(); 
				}else {
					// Eliminar un element del ArrayList
					boolean encontrado = false;
					
					for (int i = 0; i < actors.size(); i++) {
						if (actors.get(i).getId() == num) {
							actors.remove(i);
							encontrado = true;
							break;
						}
					}

					if (encontrado) {
						System.out.println("S'ha eliminat un actor amb l'id " + num + ".");
					} else {
						System.out.println("No s'ha encontrat ningún actor amb l'id " + num + ".");
					}

					// Serialitzar el ArrayList actualitzat en el arxiu
					try {
						FileOutputStream fileOut = new FileOutputStream("Dades/ActorsGenerals.dades");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(actors);
						out.close();
						fileOut.close();
					} catch (IOException i) {
						i.printStackTrace();
					}
				}

				}
				
		

	}
}
