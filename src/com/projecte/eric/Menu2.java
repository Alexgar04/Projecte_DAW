package com.projecte.eric;

import java.util.Scanner;

import com.projecte.alex.AnadirActors;
import com.projecte.alex.AnadirDirectors;
import com.projecte.alex.AnadirPeliculaGeneral;


public class Menu2 {

	public int mostrarMenu2() {

		Scanner entrada = new Scanner(System.in);
		String nom = "Paco";
		String cognoms = "Garcia Gutierrez";
		int opcio = 0;
		System.out.println("----------------------------");
		System.out.println("Menu principal " + "\n");
		boolean semafor = false;
		while (!semafor) {
			
			System.out.println("1. Accedir menu directors");
			System.out.println("2. Accedir menu d'actors ");
			System.out.println("3. Accedir menu pel·lícules");
			System.out.println("4. Tancar programa");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:
					System.out.println("----------------------------");
					System.out.println("Menu de directors ->");
					semafor = true;
					mostrardirectors();
					break;
				case 2:
					System.out.println("----------------------------");
					System.out.println("Menu d'actors ->");
					semafor = true;
					mostraractors();
					break;
				case 3:
					System.out.println("----------------------------");
					System.out.println("Menu de pel·lícules ->");
					semafor = true;
					mostrarpelicules();
					break;
				case 4:
					
					System.out.println("El programa ha sigut tancat");
					semafor = true;
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: La entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}

		return opcio;
	}

	public int mostrardirectors() {

		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {
			
			System.out.println("1. Mostrar llista general:");
			System.out.println("2. Mostrar llista personal: ");
			System.out.println("3. Afegir director a la llista general:");
			System.out.println("4. Afegir director a la llista personal:");
			System.out.println("5. Tancar el programa:");
			System.out.println("6. Tornar al menu de inici:");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirDirectors.mostrarDirectors();
					semafor = true;
					break;
				case 2:

					System.out.println("llista personal ->");
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir director a la llista general->");
					AnadirDirectors.pedirInfo();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir director a la llista personal->");
					semafor = true;
					break;
				case 5:

					System.out.println("El programa ha sigut tancat");
					semafor = true;
					break;
				case 6:

					System.out.println("Has tornat al inici->");
					semafor = true;
					mostrarMenu2();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: La entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
		return opcio;
	}

	public int mostrarpelicules() {

		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {
			
			System.out.println("1. Mostrar llista general:");
			System.out.println("2. Mostrar llista personal: ");
			System.out.println("3. Afegir pelicules a la llista general:");
			System.out.println("4. Afegir pelicules a la llista personal:");
			System.out.println("5. Tancar el programa:");
			System.out.println("6. Tornar al menu de inici:");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirPeliculaGeneral.mostrarPelicules();
					semafor = true;
					break;
				case 2:

					System.out.println("llista personal ->");
					
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir pelicules a la llista general->");
					AnadirPeliculaGeneral.pedirInfo();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir pelicules a la llista personal->");
					semafor = true;
					break;
				case 5:

					System.out.println("El programa ha sigut tancat");
					semafor = true;
					break;
				case 6:

					System.out.println("Has tornat al inici->");
					semafor = true;
					mostrarMenu2();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: La entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
		return opcio;
	}

	public int mostraractors() {

		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {
			
			System.out.println("1. Mostrar llista general:");
			System.out.println("2. Mostrar llista personal: ");
			System.out.println("3. Afegir actors a la llista general:");
			System.out.println("4. Afegir actors a la llista personal:");
			System.out.println("5. Tancar el programa:");
			System.out.println("6. Tornar al menu de inici:");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirActors.mostrarActors();
					semafor = true;
					break;
				case 2:

					System.out.println("llista personal ->");
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir actors a la llista general->");
					AnadirActors.pedirInfo();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir actors a la llista personal->");
					semafor = true;
					break;
				case 5:

					System.out.println("El programa ha sigut tancat");
					semafor = true;
					break;
				case 6:

					System.out.println("Has tornat al inici->");
					semafor = true;
					mostrarMenu2();
					break;

				default:
					System.out.println("----------------------------");
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: La entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
		return opcio;
	}
}