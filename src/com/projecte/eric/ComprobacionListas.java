package com.projecte.eric;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

import com.projecte.alex.AnadirActorsGeneral;
import com.projecte.alex.AnadirActorsPersonal;
import com.projecte.hector.IniciSesio;
import com.projecte.sergi.Actor;

public class ComprobacionListas {
	public static void comprobarGeneralActors() {
		List<Actor> actorsGenerals = AnadirActorsGeneral.getActors();
	    List<Actor> actorsPersonals = AnadirActorsPersonal.getActorsPersonals();

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
			
			String nomUsuari = IniciSesio.getUsuario();
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
			List<Actor> peliculesGenerals = AnadirActorsGeneral.getActors();
		    List<Actor> peliculesPersonals = AnadirActorsPersonal.getActorsPersonals();

		    Iterator<Actor> iterador = peliculesPersonals.iterator();

		    while (iterador.hasNext()) {
		        Actor personal = iterador.next();
		        boolean encontrado = false;
		        for (Actor general : peliculesGenerals) {
		            if (general.getId() == personal.getId()) {
		                encontrado = true;
		                break;
		            }
		        }
		        
		        if (!encontrado) {
		            iterador.remove();
		        }
		    }
				
				String nomUsuari = IniciSesio.getUsuario();
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
			List<Actor> directorsGenerals = AnadirActorsGeneral.getActors();
		    List<Actor> directorsPersonals = AnadirActorsPersonal.getActorsPersonals();

		    Iterator<Actor> iterador = directorsPersonals.iterator();

		    while (iterador.hasNext()) {
		        Actor personal = iterador.next();
		        boolean encontrado = false;
		        for (Actor general : directorsGenerals) {
		            if (general.getId() == personal.getId()) {
		                encontrado = true;
		                break;
		            }
		        }
		        
		        if (!encontrado) {
		            iterador.remove();
		        }
		    }
				
				String nomUsuari = IniciSesio.getUsuario();
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