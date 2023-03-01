package com.projecte.main;

import com.projecte.alex.Menu;
import com.projecte.alex.Registro;
import com.projecte.eric.Menu2;
import com.projecte.hector.IniciSesio;

public class ProgramaPrincipal {

	public static void main(String[] args) {
//		MostrarSergi mostrarsergi = new MostrarSergi();
//		MostrarAlex mostraralex = new MostrarAlex();
//		mostrarsergi.mostrarSergi();
//		mostraralex.mostrarAlex();
//		
//		MostrarHector mostrarhector=new MostrarHector();
//		mostrarhector.mostrarHector();
		
		Menu mostrarM = new Menu();
		Menu2 mostrarM2 = new Menu2();
		int opcionUser = mostrarM.mostrarMenu();
		int opcionUser2 = mostrarM2.mostrarMenu2();
		if (opcionUser == 1) {
			IniciSesio iniciSesio=new IniciSesio();
			
			
		}else {
			Registro reg = new Registro(opcionUser);
		}
		
		
	}

}

//mostrar nom alex
//package com.projecte.Alex;
//
//public class MostrarAlex {
//    public void mostrarAlex() {
//        System.out.println("Alex Garcia");
//    }
//}
