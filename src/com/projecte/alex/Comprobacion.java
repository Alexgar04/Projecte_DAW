package com.projecte.alex;

import com.projecte.hector.IniciSesio;

public class Comprobacion {
	
	public void comprobacion() {
		Menu mostrarM = new Menu();
        int opcionUser = mostrarM.mostrarMenu();
        
        if (opcionUser == 1) {
            IniciSesio iniciSesio = new IniciSesio(opcionUser);
        } else {
            Registro reg = new Registro(opcionUser);
        }
	}
}
