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
	static Scanner entrada = new Scanner(System.in);
	private String nomUsuari;
	
	public static List<Pelicula> getPeliculesPersonals() {
		return peliculesPersonals;
	}

	public static void setPeliculesPersonals(List<Pelicula> peliculesPersonals) {
		AnadirPeliculaPersonal.peliculesPersonals = peliculesPersonals;
	}

	public static void añadirPeliculaPersonal() {
		Scanner entrada = new Scanner(System.in);
		mostrarPeliculasPersonal();
		System.out.println("Què pel·lícula vols afegir a la teua llista?");
		AnadirPeliculaGeneral.mostrarPelicules();
		int n = 0;
		int num_max = idPeli();
		do {
			while(!entrada.hasNextInt()) {
				System.out.println("El valor no és un número");
				entrada.nextLine();
			}
			n = entrada.nextInt();
			
			if(n < 0 || n > num_max) {
				System.out.println("El valor està fora del rang");
			}
		}while(n < 0 || n > num_max);
		
		List<Pelicula> pelicules = AnadirPeliculaGeneral.getPelicules();

		String nomUsuari = IniciSesio.getUsuario();
		boolean hola = false;
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
		            boolean encontrada = false;
		            for (Pelicula peliculaPer: peliculesPersonals) {
		                if (n == peliculaPer.getId()) {
		                    System.out.println("Error el que has introduït ja està en la llista personal");
		                    encontrada = true;
		                    break;
		                }
		            }
		            if (!encontrada) {
		                peliculesPersonals.add(pelicula);
		                System.out.println("Pelicula afegida");
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
		                Menu2 m = new Menu2();
		                m.mostrarpelicules();
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
				System.out.println("Pel·lícules en la llista personal");
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
			System.out.println("No hi ha pel·lícules en la llista personal encara, fica'n");
		}
	}
	public static void eliminarPelicula() {
		mostrarPeliculasPersonal();
		if (peliculesPersonals.size() != 0) {
			int numCancelar = 0;
			int numUsuario;
			boolean encontrado = false;
			do {
				do {
					System.out.println("Què pel·lícula vols eliminar?");
					System.out.println("Si vols cancel·lar fica: " + numCancelar);
					while (!entrada.hasNextInt()) {
						System.out.println("El valor no és un número");
						entrada.next();
					}
					numUsuario = entrada.nextInt();
					if (numUsuario < 0 || numUsuario > 2147483647) {
						System.out.println("El número està fora del rang");
					}
				} while (numUsuario < 0 || numUsuario > 2147483647);
				// LLevar a partir del contador, el getId() i el numUsuari borrar el director si
				// conincideix el numero
				for (int i = 0; i < peliculesPersonals.size(); i++) {
					Pelicula pelicula = peliculesPersonals.get(i);
					if (pelicula.getId() == numUsuario) {
						peliculesPersonals.remove(i);
						encontrado = true;
					}
				}
				// Si el id del director no esta en ixe rang de numeros se indica i se torna a
				// demanar el id a eliminar
				if (!encontrado && numUsuario != numCancelar) {
					System.out.println("La pel·lícula eixa no està en la llista personal");
				}
				if (numUsuario == numCancelar) {
					System.out.println("Has elegit cancel·lar l'eliminació");
				}
			} while (!encontrado && numUsuario != numCancelar);

			if (encontrado) {
				System.out.println("S'ha eliminat correctament la pel·lícula");
				String nomUsuari = IniciSesio.getUsuario();

				ObjectOutputStream oos = null;
				FileOutputStream fout = null;
				try {
					// obrim el fitxer per escriure, sense afegir
					// només tindrem un ArrayList d'objectes
					fout = new FileOutputStream("Usuarios/" + nomUsuari + "/dades/Pelicules.llista", false);
					oos = new ObjectOutputStream(fout);
					// escrivim ArrayList sencer en el fitxer (1 sol objecte)
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
}
