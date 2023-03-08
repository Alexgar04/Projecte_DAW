package com.projecte.eric;

import java.util.Scanner;

import com.projecte.alex.AnadirActorsGeneral;
import com.projecte.alex.AnadirActorsPersonal;
import com.projecte.alex.AnadirDirectorsGeneral;
import com.projecte.alex.AnadirDirectorsPersonal;
import com.projecte.alex.AnadirPeliculaGeneral;
import com.projecte.alex.AnadirPeliculaPersonal;


public class Menu2 {

	public int mostrarMenu2() {

		Scanner entrada = new Scanner(System.in);
		int opcio = 0;
		boolean semafor = false;
		while (!semafor) {
			
			System.out.println(" +----------------------------+ ");
			System.out.println(" |     Menú principal         |" );
			System.out.println(" | 1. Acceder menú directores |");
			System.out.println(" | 2. Acceder menú actores    |");
			System.out.println(" | 3. Acceder menú películas  |");
			System.out.println(" | 4. Cerrar programa         |");
			System.out.println(" +----------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:
					semafor = true;
					mostrardirectors();
					break;
				case 2:
					semafor = true;
					mostraractors();
					break;
				case 3:

					semafor = true;
					mostrarpelicules();
					break;
				case 4:
					
					System.out.println("El programa ha sigut tancat");
					System.exit(0);
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
			System.out.println(" +---------------------------------------+ ");
			System.out.println(" |       Menú de directores              |");
			System.out.println(" | 1. Mostrar lista general              |");
			System.out.println(" | 2. Mostrar lista personal             |");
			System.out.println(" | 3. Agregar director a lista general   |");
			System.out.println(" | 4. Agregar director a lista personal  |");
			System.out.println(" | 5. Cerrar el programa                 |");
			System.out.println(" | 6. Volver al menú de inicio           |");
			System.out.println(" +---------------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirDirectorsGeneral.mostrarDirectors();
					mostrardirectors();
					semafor = true;
					break;
				case 2:

					System.out.println("llista personal ->");
					AnadirDirectorsPersonal.mostrarDirectorPersonal();
					mostrardirectors();
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir director a la llista general->");
					AnadirDirectorsGeneral.pedirInfo();
					mostrardirectors();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir director a la llista personal->");
					AnadirDirectorsPersonal.añadirDirectorPersonal();
					mostrardirectors();
					semafor = true;
					break;
				case 5:

					System.out.println("El programa ha sigut tancat");
					System.exit(0);
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
			System.out.println(" +---------------------------------------+ ");
			System.out.println(" |       Menú de películas               |");
			System.out.println(" | 1. Mostrar lista general              |");
			System.out.println(" | 2. Mostrar lista personal             |");
			System.out.println(" | 3. Agregar película a lista general   |");
			System.out.println(" | 4. Agregar película a lista personal  |");
			System.out.println(" | 5. Cerrar el programa                 |");
			System.out.println(" | 6. Volver al menú de inicio           |");
			System.out.println(" +---------------------------------------+ ");


			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirPeliculaGeneral.mostrarPelicules();
					mostrarpelicules();
					semafor = true;
					break;
				case 2:

					System.out.println("llista personal ->");	
					AnadirPeliculaPersonal.mostrarPeliculasPersonal();;
					mostrarpelicules();
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir pelicules a la llista general->");
					AnadirPeliculaGeneral.pedirInfo();
					mostrarpelicules();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir pelicules a la llista personal->");
					AnadirPeliculaPersonal.añadirPeliculaPersonal();
					mostrarpelicules();
					semafor = true;
					break;
				case 5:

					System.out.println("El programa ha sigut tancat");
					System.exit(0);
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
			
			System.out.println(" +------------------------------------+ ");
			System.out.println(" |       Menú de actores              |");
			System.out.println(" | 1. Mostrar lista general           |");
			System.out.println(" | 2. Mostrar lista personal          |");
			System.out.println(" | 3. Agregar actor a lista general   |");
			System.out.println(" | 4. Agregar actor a lista personal  |");
			System.out.println(" | 5. Cerrar el programa              |");
			System.out.println(" | 6. Volver al menú de inicio        |");
			System.out.println(" +------------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirActorsGeneral.mostrarActors();
					mostraractors();
					semafor = true;
					break;
				case 2:

					System.out.println("llista personal ->");
					AnadirActorsPersonal.mostrarActorsPersonal();
					mostraractors();
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir actors a la llista general->");
					AnadirActorsGeneral.pedirInfo();
					mostraractors();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir actors a la llista personal->");
					AnadirActorsPersonal.añadirActorPersonal();
					mostraractors();
					semafor = true;
					break;
				case 5:

					System.out.println("El programa ha sigut tancat");
					System.exit(0);
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