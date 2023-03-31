package com.projecte.alex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.projecte.sergi.Usuari;

public class Registro{
	private static List<Usuari> usuaris = new ArrayList<Usuari>();
	
	Scanner entrada = new Scanner(System.in);
	private static int id = 1;
	private int opcionUser;

	public int getOpcionUser() {
		return opcionUser;
	}

	public void setOpcionUser(int opcionUser) {
		this.opcionUser = opcionUser;
	}

	public Registro(int opcionUser) {
		String nomApell;
		String poblacion;
		String nombre = PedirUser();
		do {
			System.out.println("Cognoms: ");
			nomApell = entrada.nextLine();
			nomApell.replace("  ", "");
			while (nomApell.contains("::")) {
				System.out.println("No és pot ficar aquest caràcter \"::\" ");
				entrada.nextLine();
			}
		} while (nomApell.length() < 5);
		System.out.println("Introdueix el teu correu electrònic ");
		String correo = entrada.nextLine();
		while (!Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$").matcher(correo).matches()) {
			System.out.println("Introdueix un correu vàlid");
			correo = entrada.nextLine();
			while (correo.contains("::")) {
				System.out.println("No es pot ficar aquest caràcter \"::\" ");
				entrada.nextLine();

			}
		}
		do {
			System.out.println("Població: ");
			poblacion = entrada.nextLine();
			poblacion = poblacion.replace(" ", "");
			while (poblacion.contains("::")) {
				System.out.println("No es pot ficar aquest caràcter \"::\" ");
				entrada.nextLine();

			}

		} while (poblacion.length() < 3);

		String fechaNacimiento;
		do {
			System.out.println("Introdueix una data de naixement en format dd/mm/aaaa");
			fechaNacimiento = entrada.nextLine();
		} while (!Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$").matcher(fechaNacimiento).matches());

		String contraseña;
		String compContraseña;
		do {
			do {
				System.out.println("Introdueix contrasenya d'almenys 5 caràcters: ");
				contraseña = entrada.nextLine();
				while (contraseña.contains("::")) {
					System.out.println("No es pot ficar aquest caràcter \"::\" ");
					entrada.nextLine();

				}
			} while (contraseña.length() < 5);

			System.out.println("Torna a introduir la contrasenya");
			compContraseña = entrada.nextLine();
			if (!contraseña.equals(compContraseña)) {
				System.out.println("Error las contrasenyes introduïdes no coincideixen");
			}
		} while (!contraseña.equals(compContraseña));

		int id = leerId();
		String nombreUser = sacarNombreUser(id, correo);
		escribirInformacion(id, nombreUser, nombre, nomApell, poblacion, contraseña, correo);
		desSerializar();
		anadirUsuario(id, nombreUser, nombre, nomApell, poblacion, contraseña, correo);
		serializar();
		crearCarpetaInicial(nombreUser);
		crearCarpetaSecundaria(nombreUser);
		crearArchivos(nombreUser);

	}
	
	public void desSerializar() {
		File f = new File("usuaris.dades");
		if(f.length() != 0) {
			try {
				// obrim fitxer per a lectura
				FileInputStream file = new FileInputStream("usuaris.dades");
				ObjectInputStream reader = new ObjectInputStream(file);
				try {
					//llegim l'objecte que hi ha al fitxer (1 sol array List)
					usuaris = (ArrayList<Usuari>) reader.readObject();					
				} catch (Exception ex) {
					System.err.println("Final del fitxer");
				}

				reader.close();
				file.close();
			} catch (Exception ex) {
				System.err.println("Error en llegir usuaris.dades " + ex);
			}
		}
		
	}
	
	public void serializar() {
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			//obrim el fitxer per escriure, sense afegir
			//només tindrem un ArrayList d'objectes
			fout = new FileOutputStream("usuaris.dades", false);
			oos = new ObjectOutputStream(fout);
			//escrivim ArrayList sencer en el fitxer (1 sol objecte)
			oos.writeObject(usuaris);
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
	
	public void anadirUsuario(int id, String nomUser, String nombreUser, String nomApell, String poblacion,
			String contrasenya, String correo) {
		Usuari user = new Usuari(id, nombreUser, nomUser, nomApell, poblacion, contrasenya, correo);
		usuaris.add(user);
		
	}

	public void crearArchivos(String nomUser) {
		File fiDir = new File("Usuarios/" + nomUser + "/dades/Directors.llista");
		try {
			fiDir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File fiAct = new File("Usuarios/" + nomUser + "/dades/Actors.llista");
		try {
			fiAct.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File fiPel = new File("Usuarios/" + nomUser + "/dades/Pelicules.llista");
		try {
			fiPel.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mensajeBienvenida(nomUser);

	}

	public void crearCarpetaSecundaria(String nomUser) {
		File dades = new File("Usuarios/" + nomUser + "/dades");
		boolean creacion = dades.mkdir();

	}

	public void crearCarpetaInicial(String nombreUser) {
		File User = new File("Usuarios/" + nombreUser);
		boolean creacion = User.mkdir();
		if (creacion) {

			System.out.println("El usuari " + nombreUser + " s'ha creat correctament");
		} else {
			System.out.println("Alguna cosa ha fallat intenta-ho de nou més tard");
		}
	}

	public String sacarNombreUser(int id, String correo) {
		int letra = correo.indexOf("@");
		String nomUser = id + "_" + correo.substring(0, letra);
		return nomUser;
	}

	public int leerId() {
		File id = new File("UsersInfo/UsersInfo.txt");
		
		int int_id = 0;
		try {
			Scanner leer = new Scanner(id);
			String lineaUser = null;

			if (!leer.hasNextLine()) {
				return 1;
			} else {

				while (leer.hasNextLine()) {
					lineaUser = leer.nextLine();
				}
				String[] linea = lineaUser.split("::");
				String id_siguiente = linea[0];
				int_id = Integer.parseInt(id_siguiente);
				leer.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ++int_id;
	}

	public String PedirUser() {
		String nombreUser;
		do {
			System.out.println("Introdueix el teu nom: ");
			nombreUser = entrada.nextLine();
			nombreUser = nombreUser.replace(" ", "").replace("  ", "");
			while (nombreUser.contains("::")) {
				System.out.println("No es pot ficar aquest caràcter \"::\" ");
				nombreUser = entrada.nextLine();
				nombreUser = nombreUser.replace(" ", "").replace("  ", "");
			}

		} while (nombreUser.length() < 2);

		return nombreUser;

	}

	public void mensajeBienvenida(String nom) {
		System.out.println("Hola Benvingut: " + nom);
		Comprobacion c = new Comprobacion();
		c.comprobacion();

	}

	public void escribirInformacion(int id, String nomUser, String nombreUser, String nomApell, String poblacion,
			String contraseña, String correo) {
		File escInfo = new File("UsersInfo/UsersInfo.txt");
		
//		Path origen = Paths.get("imagenes/imagen.jpg");
//		Path destino = Paths.get(carpetaPersonal.toString(), "imagen.jpg");
//        Files.copy(origen, destino);
		try {
			FileWriter escribir = new FileWriter(escInfo, true);
			escribir.write(+id + "::" + nomUser + "::" + nombreUser + "::" + nomApell + "::" + correo + "::" + poblacion
					+ "::" + contraseña + "::" + "\n");
			escribir.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}