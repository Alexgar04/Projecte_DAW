package com.projecte.alex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Contrasenyes {
	public static final int longitudSalt = 4;
	public static final int iteracions = 10000;
	public static final int longitudHash = 256;
	
	
	public static String generarSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[longitudSalt];
		random.nextBytes(salt);
		String saltCadena = "";
		for (int i = 0; i < salt.length; i++) {
		    saltCadena += String.format("%02x", salt[i]); // Interprte la conversion de Bytes a cadena
		}
		return saltCadena;
	}
	
	public static String generarHash(String contrasenya, String salt){
		
	    char[] contrasenyaChars = contrasenya.toCharArray();
	    byte[] saltBytes = salt.getBytes();

	    PBEKeySpec spec = new PBEKeySpec(contrasenyaChars, saltBytes, iteracions, longitudHash);
	    SecretKeyFactory skf;
	    byte[] hashBytes = null;
		try {
			skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			try {
				hashBytes = skf.generateSecret(spec).getEncoded();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return Base64.getEncoder().encodeToString(hashBytes);
	}
	
	public static void escribirInfo(String nomUser, String salt, String hash) {
		File f = new File("UsersInfo/Contrasenyes.txt");
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("UsersInfo/Contrasenyes.txt" , true));
			 String linea = nomUser + ":::" + iteracions + ":::"+ salt + ":::" + longitudHash + ":::" + hash + ":::";
			 	writer.write(linea);
			    writer.newLine();
			    writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	public static boolean verificarContra(String nomUser, String contrasenya) throws FileNotFoundException, IOException {
	    BufferedReader reader = new BufferedReader(new FileReader("UsersInfo/Contrasenyes.txt"));
	    String line;
	    
	    while ((line = reader.readLine()) != null) {
	        String[] parts = line.split(":::");
	        if (parts[0].equals(nomUser)) {
	            String salt = parts[2];
	            String hash = parts[4];

	            String testHash = generarHash(contrasenya, salt);
	            
	            if (testHash.equals(hash)) {
	            	reader.close();
	                return true;
	            }
	        }
	    }
	    reader.close();
	    return false;
	}
	
	
	
	
}
