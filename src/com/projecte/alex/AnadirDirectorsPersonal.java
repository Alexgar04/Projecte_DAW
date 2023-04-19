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
import com.projecte.sergi.Director;

public class AnadirDirectorsPersonal {
	private static List<Director> directorPersonals = new ArrayList<Director>();
	static Scanner entrada = new Scanner(System.in);
	private String nomUsuari;
	
	
	
	public static List<Director> getDirectorPersonals() {
		return directorPersonals;
	}
	public static void setDirectorPersonals(List<Director> directorPersonals) {
		AnadirDirectorsPersonal.directorPersonals = directorPersonals;
	}
	public static void añadirDirectorPersonal() {
		Scanner entrada = new Scanner(System.in);
		mostrarDirectorPersonal();
		System.out.println("Que director vols anyadir a la teua llista");
		AnadirDirectorsGeneral.mostrarDirectors();
		int n = 0;
		int num_max = idDirector();
		do {
			while(!entrada.hasNextInt()) {
				System.out.println("El valor no és un número");
				entrada.nextLine();
			}
			n = entrada.nextInt();
			
			if(n < 0 || n > num_max) {
				System.out.println("El valor esta fora del rang");
			}
		}while(n < 0 || n > num_max);
		
		List<Director> directors = AnadirDirectorsGeneral.getDirectors();

		String nomUsuari = IniciSesio.getUsuario();
		for(Director director : directors) {
			if(n == director.getId()) {
				// Llegir datos existents en el codi per a que no sobreescribisca els datos
		        try {
		            FileInputStream fileIn = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Directors.llista");
		            ObjectInputStream in = new ObjectInputStream(fileIn);
		            directorPersonals = (List<Director>) in.readObject();
		            in.close();
		            fileIn.close();
		        } catch (IOException e) {
		            // Si el archivo no existe todavía, simplemente creamos una nueva lista
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        boolean encontrada = false;
		        for (Director directorPer: directorPersonals) {
	                if (n == directorPer.getId()) {
	                    System.out.println("Error lo que has introducido ya esta en la lista personal");
	                    encontrada = true;
	                    break;
	                }
	            }
	            if (!encontrada) {
			        directorPersonals.add(director);
	                System.out.println("Director añadido");
	                ObjectOutputStream oos = null;
					FileOutputStream fout = null;
					try {
						//obrim el fitxer per escriure, sense afegir
						//només tindrem un ArrayList d'objectes
						fout = new FileOutputStream("Usuarios/"+nomUsuari+"/dades/Directors.llista", false);
						oos = new ObjectOutputStream(fout);
						//escrivim ArrayList sencer en el fitxer (1 sol objecte)
						oos.writeObject(directorPersonals);
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
		
	}
	public static int idDirector() {
		File file = new File("contadoresId/contadorIdDirectors.txt");
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
	public static void mostrarDirectorPersonal() {
		String nomUsuari = IniciSesio.getUsuario();

		try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Directors.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				directorPersonals = (ArrayList<Director>) reader.readObject();
				System.out.println("Directors en la llista personal");
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
				for (Director usuari : directorPersonals) {
					  System.out.println(usuari.toString());
					}
				System.out.println(" +----------------------------------------------------------------------------------------+ ");
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
			System.out.println("No hi han directors en la llista personal encara, fica'n");
		}
	}
	public static void eliminarDirector() {
		mostrarDirectorPersonal();
		if (directorPersonals.size() != 0) {
			int numCancelar = 0;
			int numUsuario;
			boolean encontrado = false;
			do {
				do {
					System.out.println("Que director vols eliminar");
					System.out.println("Si vols cancelar fica: " + numCancelar);
					while (!entrada.hasNextInt()) {
						System.out.println("El valor no es un número");
						entrada.next();
					}
					numUsuario = entrada.nextInt();
					if (numUsuario < 1 || numUsuario > 2147483647) {
						System.out.println("El número esta fora del rang");
					}
				} while (numUsuario < 0 || numUsuario > 2147483647);
				// LLevar a partir del contador, el getId() i el numUsuari borrar el director si
				// conincideix el numero
				for (int i = 0; i < directorPersonals.size(); i++) {
					Director director = directorPersonals.get(i);
					if (director.getId() == numUsuario) {
						directorPersonals.remove(i);
						encontrado = true;
					}
				}
				// Si el id del director no esta en ixe rang de numeros se indica i se torna a
				// demanar el id a eliminar
				if (!encontrado && numUsuario != numCancelar) {
					System.out.println("El director ixe no esta en la llista personal");
				}
				if (numUsuario == numCancelar) {
					System.out.println("Has elegit cancelar la eliminació");
				}
			} while (!encontrado && numUsuario != numCancelar);

			if (encontrado) {
				System.out.println("S'ha eliminat correctament el director");
				String nomUsuari = IniciSesio.getUsuario();

				ObjectOutputStream oos = null;
				FileOutputStream fout = null;
				try {
					// obrim el fitxer per escriure, sense afegir
					// només tindrem un ArrayList d'objectes
					fout = new FileOutputStream("Usuarios/" + nomUsuari + "/dades/Directors.llista", false);
					oos = new ObjectOutputStream(fout);
					// escrivim ArrayList sencer en el fitxer (1 sol objecte)
					oos.writeObject(directorPersonals);
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
}
