package com.projecte.miquel;

public class Usuari extends Rol {

	//Atributs
		private static int contador;
		private int id;
		private String nomApell;
		private String poblacion;
		
		//Constructor
		public Usuari(String nom, String contraseña, String correo, String nomApell, String poblacion) {
			super(nom, contraseña, correo);
			contador++;
			this.id = contador;
			this.nomApell = nomApell;
			this.poblacion = poblacion;
		}

		//Getters i setters
		public static int getContador() {
			return contador;
		}

		public static void setContador(int contador) {
			Usuari.contador = contador;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String mostrarInformacio() {
			// TODO Auto-generated method stub
			return super.mostrarInformacio() + "[Id: " + this.id +"]" + "[Cognoms: " + this.nomApell +"]" + "[Població: " + this.poblacion +"]";
		}
}
