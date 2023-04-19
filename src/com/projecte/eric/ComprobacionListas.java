package com.projecte.eric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.projecte.alex.AnadirActorsGeneral;
import com.projecte.alex.AnadirActorsPersonal;
import com.projecte.alex.AnadirDirectorsGeneral;
import com.projecte.alex.AnadirDirectorsPersonal;
import com.projecte.alex.AnadirPeliculaGeneral;
import com.projecte.alex.AnadirPeliculaPersonal;
import com.projecte.hector.IniciSesio;
import com.projecte.sergi.Actor;
import com.projecte.sergi.Director;
import com.projecte.sergi.Pelicula;

public class ComprobacionListas {
	public static void comprobarGeneralActors() {
		List<Actor> actorsGenerals = AnadirActorsGeneral.getActors();
	    List<Actor> actorsPersonals = AnadirActorsPersonal.getActorsPersonals();

	    
	    String nomUsuari = IniciSesio.getUsuario();
	    
	   //Deserialitzar general
	    
	    try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Dades/ActorsGenerals.dades");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				actorsGenerals = (ArrayList<Actor>) reader.readObject();
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
			Menu2 m = new Menu2();
		} catch (Exception ex) {
			
		}
	    
	    //Deserialitzar personal
	    
	    try {
			// obrim fitxer per a lectura
			FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Actors.llista");
			ObjectInputStream reader = new ObjectInputStream(file);
			try {
				//llegim l'objecte que hi ha al fitxer (1 sol array List)
				actorsPersonals = (ArrayList<Actor>) reader.readObject();
			} catch (Exception ex) {
				System.err.println("Final del fitxer");
			}

			reader.close();
			file.close();
		} catch (Exception ex) {
			
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    Iterator<Actor> iterador = actorsPersonals.iterator();

	    while (iterador.hasNext()) {
	        Actor personal = iterador.next();
	        boolean encontrado = false;
	        for (Actor general : actorsGenerals) {
	            if (general.getId() == personal.getId()) {
	                encontrado = true;
	                break;
	            }
	        }
	        
	        if (!encontrado) {
	            iterador.remove();
	        }
	    }
			
			
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
		public static void comprobarGeneralPelicules() {
			List<Pelicula> peliculesGenerals = AnadirPeliculaGeneral.getPelicules();
		    List<Pelicula> peliculesPersonals = AnadirPeliculaPersonal.getPeliculesPersonals();

			String nomUsuari = IniciSesio.getUsuario();
			
			//Deserialitzar general
			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("Dades/PeliculesGenerals.dades");
				ObjectInputStream reader = new ObjectInputStream(file);

				try {
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					peliculesGenerals = (ArrayList<Pelicula>) reader.readObject();
					
				} catch (Exception ex) {
					System.err.println("Final del fitxer");
				}

				reader.close();
				file.close();
				Menu2 m = new Menu2();
			} catch (Exception ex) {
			}
		
			// Deserialitzar personal
			
			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Pelicules.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					//llegim l'objecte que hi ha al fitxer (1 sol array List)
					peliculesPersonals = (ArrayList<Pelicula>) reader.readObject();
					
				} catch (Exception ex) {
					System.err.println("Final del fitxer");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
			}
			
		    Iterator<Pelicula> iterador = peliculesPersonals.iterator();

			while (iterador.hasNext()) {
		    	Pelicula personal = iterador.next();
		        boolean encontrado = false;
		        for (Pelicula general : peliculesGenerals) {
		            if (general.getId() == personal.getId()) {
		                encontrado = true;
		                break;
		            }
		        }
		        
		        if (!encontrado) {
		            iterador.remove();
		        }
		    }
				
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
		public static void comprobarGeneralDirectors() {
			List<Director> directorsGenerals = AnadirDirectorsGeneral.getDirectors();
		    List<Director> directorsPersonals = AnadirDirectorsPersonal.getDirectorPersonals();
		    String nomUsuari = IniciSesio.getUsuario();
		    
		    //Deserialitzar general
		    try {
				// obrim fitxer per a lectura
				File f = new File("");
				FileInputStream file = new FileInputStream("Dades/DirectorsGenerals.dades");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {

					
					// llegim l'objecte que hi ha al fitxer (1 sol array List)
					directorsGenerals = (ArrayList<Director>) reader.readObject();
					

				} catch (Exception ex) {
					System.err.println("Final del fitxer");
				}

				reader.close();
				file.close();
				Menu2 m = new Menu2();
			} catch (Exception ex) {
			}
		
		    
		    
		    
		    // Deserialitzar personal
		    try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("Usuarios/"+nomUsuari+"/dades/Directors.llista");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					//llegim l'objecte que hi ha al fitxer (1 sol array List)
					directorsPersonals = (ArrayList<Director>) reader.readObject();
				} catch (Exception ex) {
					System.err.println("Final del fitxer");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
			}
		
		    
		    Iterator<Director> iterador = directorsPersonals.iterator();
		    
		    

		    while (iterador.hasNext()) {
		    	Director personal = iterador.next();
		        boolean encontrado = false;
		        for (Director general : directorsGenerals) {
		            if (general.getId() == personal.getId()) {
		                encontrado = true;
		                break;
		            }
		        }
		        
		        if (!encontrado) {
		            iterador.remove();
		        }
		    }
				
				
				ObjectOutputStream oos = null;
				FileOutputStream fout = null;
				try {
					//obrim el fitxer per escriure, sense afegir
					//només tindrem un ArrayList d'objectes
					fout = new FileOutputStream("Usuarios/"+nomUsuari+"/dades/Directors.llista", false);
					oos = new ObjectOutputStream(fout);
					//escrivim ArrayList sencer en el fitxer (1 sol objecte)
					oos.writeObject(directorsPersonals);
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
	
