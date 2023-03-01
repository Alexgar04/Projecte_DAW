package com.projecte.eric;

import java.util.Scanner;

public class Menu2 {
	
	public int mostrarMenu2() {
		
		
		  Scanner entrada = new Scanner(System.in);
	        String nom = "Paco";
	        String cognoms = "Garcia Gutierrez";
	        int opcio=0;

	        System.out.println("Benvingut " + nom + " " + cognoms + "\n");
	        boolean semafor = false;
	        while (!semafor) {
	  
	            System.out.println("Tria una opció:");
	            System.out.println("1. Veure llistat de pel·lícules");
	            System.out.println("2. Veure llistat d'actors");
	            System.out.println("3. Veure llistat de directors");
	            System.out.println("4. Afegir pel·lícula");
	            System.out.println("5. Afegir actor");
	            System.out.println("6. Afegir director");
	            System.out.println("7. Sortir\n");
	           
	           
	            try {
	            	opcio = entrada.nextInt();
	                switch (opcio) {
	                case 1:
	                   
	                    System.out.println("Mostrar llistat de pel·lícules ->");
	                    semafor = true;
	                    break;
	                case 2:
	                    
	                    System.out.println("Mostrar llistat d'actors ->");
	                    semafor = true;
	                    break;
	                case 3:
	                    
	                    System.out.println("Mostrar llistat de directors ->");
	                    semafor = true;
	                    break;
	                case 4:
	                    
	                    System.out.println("Afegir pel·lícula:");
	                    semafor = true;
	                    break;
	                case 5:
	                   
	                    System.out.println("Afegir actor:");
	                    semafor = true;
	                    break;
	                case 6:
	                    
	                    System.out.println("Afegir director:");
	                    semafor = true;
	                    break;
	                case 7:
	                    System.out.println("Adeu,hasta pronte.");
	                    semafor = true;
	                    
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
	}