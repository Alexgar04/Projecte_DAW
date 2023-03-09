package com.projecte.main;

import com.projecte.alex.Comprobacion;
import com.projecte.alex.MostrarAlex;
import com.projecte.eric.MostrarEric;
import com.projecte.hector.MostrarHector;
import com.projecte.miquel.MostrarMiquel;
import com.projecte.sergi.MostrarSergi;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		MostrarSergi mostrarsergi = new MostrarSergi();
		MostrarMiquel mostrarMiquel = new MostrarMiquel();
		MostrarAlex mostraralex = new MostrarAlex();
		MostrarEric MostrarEric = new MostrarEric();
		MostrarHector mostrarhector=new MostrarHector();
		System.out.println("+--------------------------------+");
		System.out.println("|Membres del grup:               |");
		mostrarsergi.mostrarSergi();
		mostraralex.mostrarAlex();
		MostrarEric.mostrarEric();
		mostrarhector.mostrarHector();
		mostrarMiquel.mostrarMiquel();
		System.out.println("+--------------------------------+");
		

		
		
		Comprobacion c = new Comprobacion();
        c.comprobacion();
	
	}

}


