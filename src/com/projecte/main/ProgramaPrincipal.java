package com.projecte.main;

import com.projecte.alex.Menu;
import com.projecte.alex.Registro;

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
		int opcionUser = mostrarM.mostrarMenu();
		if (opcionUser == 1) {
			
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
