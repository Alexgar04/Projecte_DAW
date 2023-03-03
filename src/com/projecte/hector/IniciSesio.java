package com.projecte.hector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.projecte.eric.Menu2;
import com.projecte.alex.Comprobacion;

public class IniciSesio {

	public int opcionUser;

	public int getOpcionUser() {
		return opcionUser;
	}

	public void setOpcionUser(int opcionUser) {
		this.opcionUser = opcionUser;
	}

	public IniciSesio(int opciopUser) {
		// El usuari introdueix el nom per teclat i la contrasenya per a comprobarla.
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca el nombre de usuario: ");
		String usuario = entrada.nextLine();
		System.out.println("Introduzca la contraseña: ");
		String contrasena = entrada.nextLine();
		verificarCredenciales(usuario, contrasena);

	}

	public static void verificarCredenciales(String usuario, String contrasena) {
		File compUsuario = new File("Usuarios/"+usuario);
	    if (compUsuario.exists()) {
	       File comprobacion = new File("UsersInfo/UsersInfo.txt");
	       try {
			Scanner leer = new Scanner(comprobacion);
			String pepe = "hol";
			boolean hola = false;
			while(!hola) {
				
				if(!leer.hasNextLine()) {
					System.out.println("INCORRECTO");
					pepe = "hola";
					hola = true;
				}
				else {
					String linea = leer.nextLine();
					String[] arrayLinea = linea.split("::");
					String contrasena_b = arrayLinea[6];
					String usuario_b = arrayLinea[1];
					if(contrasena_b.equals(contrasena) && usuario_b.equals(usuario)) {
						System.out.println("Usuario correcto");
						System.out.println("----------------------------");
						Menu2 menu = new Menu2();
				        menu.mostrarMenu2();
						
					}
					
					
						
					
				}
				
			}
			
			if(pepe.equals("hola")) {
				Comprobacion c = new Comprobacion();
		        c.comprobacion();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	       
	    } else {
	        System.out.println("El usuario introducido no existe");
	        Comprobacion c = new Comprobacion();
            c.comprobacion();
		}
		// Lig les dades de UsersInfo.txt y comprova si son reals

		// Si no troba una coincidencia tornara false.

	}

}
