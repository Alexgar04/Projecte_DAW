package com.projecte.alex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Registro {
	public int id = 1;
	Scanner entrada = new Scanner(System.in);
	
	private int opcionUser;
	

	public int getOpcionUser() {
		return opcionUser;
	}

	public void setOpcionUser(int opcionUser) {
		this.opcionUser = opcionUser;
	}	
	

	public Registro(int opcionUser){
		String nombreUser = PedirUser();
		File User = new File("Usuarios/"+nombreUser);
		if (User.exists()) {
			System.out.println("El usuario introducido ya existe, prueba iniciando sesion");
			System.out.println("**********************************************");
			Menu mostrarM = new Menu();
			int opcion = mostrarM.mostrarMenu();
			if (opcion == 2) {
				Registro reg = new Registro(opcion);
			}
			
		}else {
			System.out.println("Nombre y apellidos: ");
			String nomApell = entrada.nextLine();
			System.out.println("Poblacion: ");
			String poblacion = entrada.nextLine();
			
			String contraseña;
			String compContraseña;
			do {
				System.out.println("Introduce contraseña: ");
				contraseña = entrada.nextLine();
				System.out.println("Vuelve a introducir la contraseña");
				compContraseña = entrada.nextLine();
				if(!contraseña.equals(compContraseña)) {
					System.out.println("Error las contraseñas introducidas no coinciden");
				}
			}while(!contraseña.equals(compContraseña));
			int id = 1;
			escribirInformacion(nombreUser,nomApell,poblacion,contraseña);
			
			boolean creacion = User.mkdir();
			if(creacion) {
				System.out.println("El usuario " +nombreUser+" se ha creado correctamente");
				mensajeBienvenida(nombreUser);
			}else {
				System.out.println("Algo ha fallado intentelo de nuevo mas tarde");
			}
		}
		
	}
	
	public String PedirUser() {
		System.out.println("Introduce un nombre de usuario: ");
		String nombreUser = entrada.nextLine();
		return nombreUser;
		
	}
	public void mensajeBienvenida(String nom) {
		System.out.println("Hola Bienvendido: "+nom);
	}
	
	public void escribirInformacion(String nombreUser, String nomApell, String poblacion,String contraseña) {
		File escInfo = new File("UsersInfo/UsersInfo.txt");
        try {
			FileWriter escribir = new FileWriter(escInfo, true);
			escribir.write("ID Usuario: "+ id +"\n");
			id++;
			escribir.write("Nombre Usuario: "+nombreUser+"\n");
			escribir.write("Nombre y Apellidos: "+nomApell+"\n");
			escribir.write("Poblacion: "+poblacion+"\n");
			escribir.write("Contraseña: "+contraseña+"\n");
			escribir.write("------------------------------------------------"+"\n");
			escribir.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

	
}	


