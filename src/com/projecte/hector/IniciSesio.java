package com.projecte.hector;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IniciSesio {

	public int opcionUser;

	public int getOpcionUser() {
		return opcionUser;
	}

	public void setOpcionUser(int opcionUser) {
		this.opcionUser = opcionUser;
	}

	private void introduirDades(int opciopUser) {
		// El usuari introdueix el nom per teclat i la contrasenya per a comprobarla.
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduzca el nombre de usuario: ");
		String usuario = entrada.nextLine();
		System.out.print("Introduzca la contraseña: ");
		String contrasena = entrada.nextLine();

		// Verificar les credencials del usuaris.
		if (verificarCredenciales(usuario, contrasena)) {
			System.out.println("Inicio de sesión exitoso");
			// Si son correctes segueix en lo seguent.
		} else {
			System.out.println("Nombre de usuario o contraseña incorrectos");
			// Mostrar mensatge de error y torna al formulari de nou.
		}
	}

	// Aquest metode se encarrega de llegir el que hi ha escrit al fitxer de text.

	public static boolean verificarCredenciales(String usuario, String contrasena) {
		// Lig les dades de UsersInfo.txt y comprova si son reals
		try (BufferedReader llegirdades = new BufferedReader(new FileReader("UsersInfo\\UsersInfo.txt"))) {
			String linea;
			while ((linea = llegirdades.readLine()) != null) {
				// Separar el nom de usuari i contrasenya en un array separant a partir dels ::
				String[] datosUsuari = linea.split("::");
				String usuarioIntroduit = datosUsuari[1];
				String contrasenaIntroduit = datosUsuari[5];

				// Verificar si el nom de usuari i la contrasenya coincidisen
				if (usuario.equals(usuarioIntroduit) && contrasena.equals(contrasenaIntroduit)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Si no troba una coincidencia tornara false.

		return false;
	}

}
