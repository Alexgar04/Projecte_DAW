package com.projecte.main;

import com.projecte.hector.MostrarHector;
//import com.projecte.Alex.MostrarAlex;
import com.projecte.sergi.MostrarSergi;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		MostrarSergi mostrarsergi = new MostrarSergi();
//		MostrarAlex mostraralex = new MostrarAlex();
		mostrarsergi.mostrarSergi();
//		mostraralex.mostrarAlex();
		
		MostrarHector mostrarhector=new MostrarHector();
		mostrarhector.mostrarHector();

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
