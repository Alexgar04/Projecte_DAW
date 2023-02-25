package com.projecte.alex;

import java.io.File;
import java.util.Scanner;
public class Registro {
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
		File User = new File("/ProjecteDAW/Usuarios/"+nombreUser);
		if (User.exists()) {
			System.out.println("El usuario introducido ya existe, prueba iniciando sesion");
			System.out.println("**********************************************");
			Menu mostrarM = new Menu();
			int opcion = mostrarM.mostrarMenu();
			if (opcion == 2) {
				Registro reg = new Registro(opcion);
			}
			
		}else {
			
			
//			boolean creacion = User.mkdir();
//			if(creacion) {
//				System.out.println("El usuario se ha creado correctamente");
//				
//			}else {
//				System.out.println("Algo ha fallado intentelo de nuevo mas tarde");
//			}
		}
		
	}
	
	public String PedirUser() {
		System.out.println("Introduce un nombre de usuario: ");
		String nombreUser = entrada.nextLine();
		return nombreUser;
		
	}
}	


