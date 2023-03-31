package com.projecte.eric;

import java.io.File;
import java.util.Scanner;

import com.projecte.alex.AnadirActorsGeneral;
import com.projecte.alex.AnadirActorsPersonal;
import com.projecte.alex.AnadirDirectorsGeneral;
import com.projecte.alex.AnadirDirectorsPersonal;
import com.projecte.alex.AnadirPeliculaGeneral;
import com.projecte.alex.AnadirPeliculaPersonal;
import com.projecte.alex.Comprobacion;


public class Menu2 {

	public int mostrarMenu2() {

		Scanner entrada = new Scanner(System.in);
		int opcio = 0;
		boolean semafor = false;
		while (!semafor) {
			
			System.out.println(" +------------------------------+ ");
			System.out.println(" |     Menú principal           |" );
			System.out.println(" | 1. Accedir menú directors    |");
			System.out.println(" | 2. Accedir menú actors       |");
			System.out.println(" | 3. Accedir menú pel·lícules  |");
			System.out.println(" | 4. Tancar sessió             |");
			System.out.println(" +------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:
					mostrardirectors();
					semafor = true;
					break;
				case 2:
					mostraractors();
					semafor = true;
					break;
				case 3:
					mostrarpelicules();
					semafor = true;
					break;
				case 4:
			
					System.out.println("El programa ha sigut tancat");
					Comprobacion c = new Comprobacion();
			        c.comprobacion();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}

		return opcio;
	}

	public int mostrardirectors() {
		File f = new File("Dades/DirectorsGenerals.llista");
		if(f.length() == 0) {
			AnadirDirectorsGeneral.ficarDirectorsDefecte();
		}
		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {
			System.out.println(" +---------------------------------------------+ ");
			System.out.println(" |       Menú de directores                    |");
			System.out.println(" | 1. Mostrar llista general                   |");
			System.out.println(" | 2. Mostrar llista personal                  |");
			System.out.println(" | 3. Afegir director a llista general         |");
			System.out.println(" | 4. Afegir director a llista personal        |");
			System.out.println(" | 5. Eliminar director de la llista personal  |");
			System.out.println(" | 6. Tornar al menú d'inici                   |");
			System.out.println(" +---------------------------------------------+ ");

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
					System.out.println("Llista personal ->");
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
					AnadirDirectorsPersonal.eliminarDirector();
					semafor = true;
					mostrardirectors();
					break;
				case 6:

					System.out.println("Has tornat a l'inici->");
					mostrarMenu2();
					semafor = true;
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
		return opcio;
	}

	public int mostrarpelicules() {
		File f = new File("Dades/PeliculesGenerals.llista");
		if(f.length() == 0) {
			AnadirPeliculaGeneral.ficarPeliculesDefecte();
		}
		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {
			System.out.println(" +-------------------------------------------------+ ");
			System.out.println(" |       Menú de pel·lícules                       |");
			System.out.println(" | 1. Mostrar llista general                       |");
			System.out.println(" | 2. Mostrar llista personal                      |");
			System.out.println(" | 3. Afegir pel·lícula a llista general           |");
			System.out.println(" | 4. Afegir pel·lícula a llista personal          |");
			System.out.println(" | 5. Eliminar pel·lícula de la llista personal    |");
			System.out.println(" | 6. Tornar al menú d'inici                       |");
			System.out.println(" +-------------------------------------------------+ ");


			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("Llista general ->");
					AnadirPeliculaGeneral.mostrarPelicules();
					mostrarpelicules();
					semafor = true;
					break;
				case 2:

					System.out.println("Llista personal ->");	
					AnadirPeliculaPersonal.mostrarPeliculasPersonal();;
					mostrarpelicules();
					semafor = true;
					break;
				case 3:

					System.out.println("Afegir pel·lícules a la llista general->");
					AnadirPeliculaGeneral.pedirInfo();
					mostrarpelicules();
					semafor = true;
					break;
				case 4:

					System.out.println("Afegir pel·lícules a la llista personal->");
					AnadirPeliculaPersonal.añadirPeliculaPersonal();
					mostrarpelicules();
					semafor = true;
					break;
					
				case 5:
					AnadirPeliculaPersonal.eliminarPelicula();
					semafor = true;
					mostrarpelicules();
					break;
				case 6:

					System.out.println("Has tornat l'inici->");
					semafor = true;
					mostrarMenu2();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
		return opcio;
	}

	public int mostraractors() {
		File f = new File("Dades/ActorssGenerals.llista");
		if(f.length() == 0) {
			AnadirActorsGeneral.ficarActorsDefecte();
		}
		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {
			
			System.out.println(" +--------------------------------------------+ ");
			System.out.println(" |       Menú d'actors                        |");
			System.out.println(" | 1. Mostrar llista general                  |");
			System.out.println(" | 2. Mostrar llista personal                 |");
			System.out.println(" | 3. Afegir actor a llista general           |");
			System.out.println(" | 4. Afegir actor a llista personal          |");
			System.out.println(" | 5. Eliminar actor de la llista personal    |");
			System.out.println(" | 6. Tornar al menú d'inicio                 |");
			System.out.println(" +--------------------------------------------+");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("Llista general ->");
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
					AnadirActorsPersonal.eliminarActor();
					semafor = true;
					mostraractors();
					break;
				case 6:

					System.out.println("Has tornat a l'inici->");
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
	
	/////////////////////////////////////////////////////////////////////////
	/// 																  ///
	/// 																  ///
	/// 							  ADMIN 							  ///
	/// 																  ///
	/// 																  ///
	/////////////////////////////////////////////////////////////////////////

	public int mostrarMenu2Admin() {

		Scanner entrada = new Scanner(System.in);
		int opcio = 0;
		boolean semafor = false;
		while (!semafor) {

			System.out.println(" +------------------------------+ ");
			System.out.println(" |     Menú principal           |");
			System.out.println(" | 1. Accedir menú directors    |");
			System.out.println(" | 2. Accedir menú actors       |");
			System.out.println(" | 3. Accedir menú pel·lícules  |");
			System.out.println(" | 4. Tancar sessió             |");
			System.out.println(" +------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:
					menuAdminDirector();
					semafor = true;
					break;
				case 2:
					menuAdminActor();
					semafor = true;
					break;
				case 3:
					menuAdminPelicula();
					semafor = true;
					break;
				case 4:
					System.out.println("El programa ha sigut tancat");
					Comprobacion c = new Comprobacion();
			        c.comprobacion();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}

		return opcio;
	}

	public void menuAdminActor() {
		File f = new File("Dades/ActorssGenerals.llista");
		if(f.length() == 0) {
			AnadirActorsGeneral.ficarActorsDefecte();
		}
		Scanner entrada = new Scanner(System.in);
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {

			System.out.println(" +--------------------------------------------+ ");
			System.out.println(" |       Menú de actors                       |");
			System.out.println(" | 1. Mostrar llista general                  |");
			System.out.println(" | 2. Afegir actor a llista general           |");
			System.out.println(" | 3. Eliminar actor de la llista general     |");
			System.out.println(" | 4. Tornar al menú d'inicio                 |");
			System.out.println(" +--------------------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("Llista general ->");
					AnadirActorsGeneral.mostrarActors();
					menuAdminActor();
					semafor = true;
					break;
				case 2:

					System.out.println("Afegir actors a la llista general->");
					AnadirActorsGeneral.pedirInfo();
					menuAdminActor();
					semafor = true;
					break;

				case 3:
					AnadirActorsGeneral.demanarIdEliminarActor();
					menuAdminActor();
					semafor = true;
					break;
					
				case 4:

					System.out.println("Has tornat a l'inici->");
					mostrarMenu2Admin();
					semafor = true;
					break;
					
				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
	}

	public void menuAdminDirector() {
		File f = new File("Dades/DirectorsGenerals.llista");
		if(f.length() == 0) {
			AnadirDirectorsGeneral.ficarDirectorsDefecte();
		}
		Scanner entrada = new Scanner(System.in);
		
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {

			System.out.println(" +---------------------------------------------+ ");
			System.out.println(" |       Menú de director                      |");
			System.out.println(" | 1. Mostrar llista general                   |");
			System.out.println(" | 2. Afegir director a llista general         |");
			System.out.println(" | 3. Eliminar director de la llista general   |");
			System.out.println(" | 4. Tornar al menú d'inici                   |");
			System.out.println(" +---------------------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("llista general ->");
					AnadirDirectorsGeneral.mostrarDirectors();
					menuAdminDirector();
					semafor = true;
					break;
				case 2:

					System.out.println("Afegir directors a la llista general->");
					AnadirDirectorsGeneral.pedirInfo();
					menuAdminDirector();
					semafor = true;
					break;
				case 3:

					AnadirDirectorsGeneral.demanarIdEliminarDirector();
					menuAdminDirector();
					break;
				case 4:

					System.out.println("Has tornat a l'inici->");
					semafor = true;
					mostrarMenu2Admin();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
	}

	public void menuAdminPelicula() {
		File f = new File("Dades/PeliculesGenerals.llista");
		if(f.length() == 0) {
			AnadirPeliculaGeneral.ficarPeliculesDefecte();
		}
		Scanner entrada = new Scanner(System.in);
		
		boolean semafor = false;
		int opcio = 0;
		while (!semafor) {

			System.out.println(" +-------------------------------------------------+ ");
			System.out.println(" |       Menú de pel·lícula                        |");
			System.out.println(" | 1. Mostrar llista general                       |");
			System.out.println(" | 2. Afegir pel·lícula a llista general           |");
			System.out.println(" | 3. Eliminar pel·lícula de la llista general     |");
			System.out.println(" | 4. Tornar al menú d'inici                       |");
			System.out.println(" +-------------------------------------------------+ ");

			try {
				opcio = entrada.nextInt();
				switch (opcio) {
				case 1:

					System.out.println("Llista general ->");
					AnadirPeliculaGeneral.mostrarPelicules();
					menuAdminPelicula();
					semafor = true;
					break;
				case 2:

					System.out.println("Afegir pel·lícula a la llista general->");
					AnadirPeliculaGeneral.pedirInfo();
					menuAdminPelicula();
					semafor = true;
					break;
				case 3:
					AnadirPeliculaGeneral.demanarIdEliminarPelicula();
					menuAdminPelicula();
					break;
				case 4:

					System.out.println("Has tornat a l'inici->");
					semafor = true;
					mostrarMenu2Admin();
					break;

				default:
					System.out.println("Opció no vàlida. Torna a provar.");

				}

			} catch (Exception e) {
				System.out.print("Error: L'entrada no és un enter.");
				entrada.nextLine();
				System.out.println("");
				System.out.println("");

			}
		}
	}
}