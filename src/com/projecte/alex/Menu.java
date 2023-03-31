package com.projecte.alex;

import java.util.Scanner;

public class Menu {
	public int mostrarMenu() {
		Scanner entrada = new Scanner(System.in);
		System.out.println(" +------------------------------------+ ");
		System.out.println(" | Benvingut al menú de la Cartelera  |");
		System.out.println(" |   Tria una opció                   |");
		System.out.println(" |   1: Inici de Sessió               |");
		System.out.println(" |   2: Registre                      |");
		System.out.println(" |   3: Tancar programa               |");
		System.out.println(" +------------------------------------+ ");
		
		int num = 0;;
		do {
			if(!entrada.hasNextInt()) {
				System.out.println("El que has introduït, no és un número");
				entrada.nextLine();
			}else {
				 num = entrada.nextInt();
				 if(num < 1 || num > 3) {
						System.out.println("El que has introduït, està fora del rang de les opcions");
						entrada.nextLine();
						
					}
			}
			
			
		}while(num < 1 || num > 3);
		return num;
	}
}
