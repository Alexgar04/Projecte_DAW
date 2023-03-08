package com.projecte.alex;

import java.util.Scanner;

public class Menu {
	public int mostrarMenu() {
		Scanner entrada = new Scanner(System.in);
		System.out.println(" +------------------------------------+ ");
		System.out.println(" | Bienvenido al menú de la Cartelera |");
		System.out.println(" |   Elige una opción:                |");
		System.out.println(" |   1: Inicio de Sesión              |");
		System.out.println(" |   2: Registro                      |");
		System.out.println(" +------------------------------------+ ");
		
		int num = 0;;
		do {
			if(!entrada.hasNextInt()) {
				System.out.println("Lo que has introducido no es un numero");
				entrada.nextLine();
			}else {
				 num = entrada.nextInt();
				 if(num < 1 || num > 2) {
						System.out.println("Lo que has introducido esta fuera del rango de las opciones");
						entrada.nextLine();
						
					}
			}
			
			
		}while(num < 1 || num > 2);
		return num;
	}
}
