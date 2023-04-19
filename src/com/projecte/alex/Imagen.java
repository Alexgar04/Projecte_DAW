package com.projecte.alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.projecte.hector.IniciSesio;

public class Imagen {
	public static void imagenDefecto(String nomUser) {
		        // Ruta de la imagen original
		        Path rutaOriginal = Paths.get("Imagenes/ImagenDefecto.png");
		        
		        // Ruta donde se guardará la imagen copiada
		        Path rutaDestino = Paths.get("Usuarios/"+nomUser+"/dades/defecto.png");

		        try {
		            // Copiar la imagen utilizando la clase Files
		            Files.copy(rutaOriginal, rutaDestino);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	}
	
	public static void canviarImagen(String nomUser) {
		Scanner entrada = new Scanner(System.in);
		// Ruta del archivo a modificar
		String rutaArchivo = "UsersInfo/UsersInfo.txt";
		System.out.println("Que imagen quieres");
		// Nueva imagen de perfil
		String imagen = entrada.nextLine();
		
		if(!imagen.contains(".")) {
		    System.out.println("INCORRECTO");
		} else if(!imagen.contains(".png") && !imagen.contains(".jpg") && !imagen.contains(".jpeg") && !imagen.contains(".gif")) {
		    System.out.println("Extensión inválida");
		} else {
			File comprobacion = new File("Imagenes/"+imagen);
			if(comprobacion.exists()) {
				File archivo = new File(rutaArchivo);
				try {
				    BufferedReader reader = new BufferedReader(new FileReader(archivo));
				    BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo + ".tmp"));

				    // Lee y modifica el archivo línea por línea
				    String linea;
				    while ((linea = reader.readLine()) != null) {

				        // Busca la línea que contiene el usuario
				        if (linea.contains(nomUser)) {
				        	borraImagen(nomUser);
				            // Modifica la imagen de perfil del usuario
				            String[] campos = linea.split("::");
				            campos[campos.length-1] = imagen;
				            String nuevaLinea = String.join("::", campos);
				            writer.write(nuevaLinea);

				        } else {
				            // Escribe las líneas del archivo sin cambios
				            writer.write(linea);
				        }
				        writer.write(System.lineSeparator()); // agrega una nueva línea al final de cada línea escrita
				        
				    }
				    System.out.println("Cambiada la imagen correctamente");
				    copiaNuevaImagen(imagen,nomUser);
				    // Cierra el archivo
				    reader.close();
				    writer.close();

				    // Borra el archivo original y renombra el archivo temporal
				    archivo.delete();
				    File tmpArchivo = new File(rutaArchivo + ".tmp");
				    tmpArchivo.renameTo(archivo);

				} catch (IOException e) {
				    System.out.println("Error al abrir o escribir el archivo.");
				}
			}else {
				System.out.println("La imagen que has introducido no existe");
			}


		}
}
	public static void copiaNuevaImagen(String imagen, String nomUser) {
		// Ruta de la imagen original
        Path rutaOriginal = Paths.get("Imagenes/"+imagen);
        
        // Ruta donde se guardará la imagen copiada
        Path rutaDestino = Paths.get("Usuarios/"+nomUser+"/dades/"+imagen);

        try {
            // Copiar la imagen utilizando la clase Files
            Files.copy(rutaOriginal, rutaDestino);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void borraImagen(String nomUser) {
        File f = new File("UsersInfo/UsersInfo.txt");
        try {
            Scanner leer = new Scanner(f);
            while(leer.hasNextLine()) {
                String linea = leer.nextLine();
                if(linea.contains(nomUser)) {
                    String[] campos = linea.split("::");
                    String imagen = campos[campos.length - 1];
                    File borrar = new File("Usuarios/"+nomUser+"/dades/"+imagen);
                    System.out.println("Borrada imagen anterior: " + imagen);
                    boolean hola = borrar.delete();
                    if (!hola) {
                        System.err.println("Fallo al borar el archivo: " + imagen);
                    }
                }
            }
            leer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
}
	
	public static void mostrarImagen() {
		String nomUser = IniciSesio.getUsuario();
		String imagen = "";
		 File f = new File("UsersInfo/UsersInfo.txt");
	        try {
	            Scanner leer = new Scanner(f);
	            while(leer.hasNextLine()) {
	                String linea = leer.nextLine();
	                if(linea.contains(nomUser)) {
	                    String[] campos = linea.split("::");
	                    imagen = campos[campos.length - 1];
	                }
	            }
	            leer.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }


	        String workspacePath = System.getProperty("user.dir");
	        String rutaRelativa ="Usuarios/"+ nomUser + "/dades/"+imagen;
	        String ruta = "file:///" + Paths.get(workspacePath, rutaRelativa).toString();
	        String sistemaOperatiu = System.getProperty("os.name").toLowerCase();

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Elija el navegador para abrir la imagen: (chrome/firefox/edge)");
	        String navegador = scanner.nextLine().toLowerCase();

	        if (sistemaOperatiu.contains("windows")) {
	            try {
	                if (navegador.equals("chrome")) {
	                    Runtime.getRuntime().exec("cmd /c start chrome " + ruta);
	                    System.out.println("La imagen se ha abierto en el navegador satisfactoriamente.");
	                } else if (navegador.equals("firefox")) {
	                    Runtime.getRuntime().exec("cmd /c start firefox " + ruta);
	                    System.out.println("La imagen se ha abierto en el navegador satisfactoriamente.");
	                } else if (navegador.equals("edge")) {
	                	Runtime.getRuntime().exec("cmd /c start msedge " + ruta);
	                	System.out.println("La imagen se ha abierto en el navegador satisfactoriamente.");
	                } else {
	                    System.out.println("Navegador no reconocido.");
	                }
	                
	            } catch (IOException e) {
	                System.err.println("Error al abrir la imagen en el navegador: " + e.getMessage());
	            }
	        } else if (sistemaOperatiu.contains("linux")) {
	            try {
	                if (navegador.equals("chrome")) {
	                    Runtime.getRuntime().exec("google-chrome " + ruta);
	                } else if (navegador.equals("firefox")) {
	                    Runtime.getRuntime().exec("firefox " + ruta);
	                } else {
	                    System.out.println("Navegador no reconocido.");
	                }
	                System.out.println("La imagen se ha abierto en el navegador satisfactoriamente.");
	            } catch (IOException e) {
	                System.err.println("Error al abrir la imagen en el navegador: " + e.getMessage());
	            }
	        }else if (sistemaOperatiu.contains("mac")) {
	            try {
	                if (navegador.equals("chrome")) {
	                    Runtime.getRuntime().exec("open -a \"Google Chrome\" " + ruta);
	                } else if (navegador.equals("firefox")) {
	                    Runtime.getRuntime().exec("open -a Firefox " + ruta);
	                } else if (navegador.equals("safari")) {
	                    Runtime.getRuntime().exec("open -a Safari " + ruta);
	                } else if (navegador.equals("safari")) {
	                    Runtime.getRuntime().exec("open -a Safari " + ruta);
	                }else {
	                    System.out.println("Navegador no reconocido.");
	                }
	                System.out.println("La imagen se ha abierto en el navegador satisfactoriamente.");
	            } catch (IOException e) {
	                System.err.println("Error al abrir la imagen en el navegador: " + e.getMessage());
	            }
	        }else {
	            System.out.println("Esta función no está implementada para tu sistema operativo.");
	        }
	}
	
	
}