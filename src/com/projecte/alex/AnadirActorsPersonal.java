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
	
	
	static Scanner entrada = new Scanner(System.in);
	private String nomUsuari;
	
	

	public static List<Actor> getActorsPersonals() {
		return actorsPersonals;
	}

	public static void setActorsPersonals(List<Actor> actorsPersonals) {
		AnadirActorsPersonal.actorsPersonals = actorsPersonals;
	}

	public static void añadirActorPersonal() {
		Scanner entrada = new Scanner(System.in);
		mostrarActorsPersonal();
		System.out.println("Que actor vols anyadir a la teua llista");
		AnadirActorsGeneral.mostrarActors();
		
		int n = 0;
		int num_max = idPeli();
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
		
		List<Actor> actors = AnadirActorsGeneral.getActors();

		String nomUsuari = IniciSesio.getUsuario();
		for(Actor actor : actors) {
			if(n == actor.getId()) {
				// Llegir datos existents en el codi per a que no sobreescribisca els datos
		        try {
		            FileInputStream fileIn = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista");
		            ObjectInputStream in = new ObjectInputStream(fileIn);
		            actorsPersonals = (List<Actor>) in.readObject();
		            in.close();
		            fileIn.close();
		        } catch (IOException e) {
		            // Si el archivo no existe todavía, simplemente creamos una nueva lista
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        
		        boolean encontrada = false;
	            for (Actor actorPer: actorsPersonals) {
	                if (n == actorPer.getId()) {
	                    System.out.println("Error lo que has introducido ya esta en la lista personal");
	                    encontrada = true;
	                    break;
	                }
	            }
	            if (!encontrada) {
					actorsPersonals.add(actor);
	                System.out.println("Actor añadido");
	                ObjectOutputStream oos = null;
					FileOutputStream fout = null;
					try {
						//obrim el fitxer per escriure, sense afegir
						//només tindrem un ArrayList d'objectes
						fout = new FileOutputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista", false);
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
			FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				actorsPersonals = (ArrayList<Actor>) reader.readObject();
				if (actorsPersonals.size() > 0) {
					System.out.println("Actors en la llista personal");
					System.out.println(" +----------------------------------------------------------------------------------------+ ");
					for (Actor actor : actorsPersonals) {
						  System.out.println(actor.toString());
						}
					System.out.println(" +----------------------------------------------------------------------------------------+ ");
				}else {
					System.out.println("No hi ha cap en la llista");
				}

			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
			System.out.println("No hi han actors en la llista personal encara, fica'n");
		}
	}
	public static void eliminarActor() {
		mostrarActorsPersonal();
		if (actorsPersonals.size() != 0) {
			int numCancelar = 0;
			int numUsuario;
			boolean encontrado = false;
			do {
				do {
					System.out.println("Que actor vols eliminar");
					System.out.println("Si vols cancelar fica: " + numCancelar);
					while (!entrada.hasNextInt()) {
						System.out.println("El valor no es un número");
						entrada.next();
					}
					numUsuario = entrada.nextInt();
					if (numUsuario < 0 || numUsuario > 2147483647) {
						System.out.println("El número esta fora del rang");
					}
				} while (numUsuario < 0 || numUsuario > 2147483647);
				// LLevar a partir del contador, el getId() i el numUsuari borrar el director si
				// conincideix el numero
				for (int i = 0; i < actorsPersonals.size(); i++) {
					Actor actor = actorsPersonals.get(i);
					if (actor.getId() == numUsuario) {
						actorsPersonals.remove(i);
						encontrado = true;
					}
				}
				// Si el id del director no esta en ixe rang de numeros se indica i se torna a
				// demanar el id a eliminar
				if (!encontrado && numUsuario != numCancelar) {
					System.out.println("El actor ixe no esta en la llista personal");
				}
				if (numUsuario == numCancelar) {
					System.out.println("Has elegit cancelar la eliminació");
				}
			} while (!encontrado && numUsuario != numCancelar);

			if (encontrado) {
				System.out.println("S'ha eliminat correctament el actor");
				String nomUsuari = IniciSesio.getUsuario();

				ObjectOutputStream oos = null;
				FileOutputStream fout = null;
				try {
					// obrim el fitxer per escriure, sense afegir
					// només tindrem un ArrayList d'objectes
					fout = new FileOutputStream("Usuarios/" + nomUsuari + "/dades/Actors.llista", false);
					oos = new ObjectOutputStream(fout);
					// escrivim ArrayList sencer en el fitxer (1 sol objecte)
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
}
