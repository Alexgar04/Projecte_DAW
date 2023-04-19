package com.projecte.sergi;

import java.io.Serializable;

import com.projecte.alex.Rol_usuario.ROL;

public class Usuari implements Serializable {
	//Atributs
	private int id;
	private String nomUser;
	private String nombreUser;
	private String nomApell;
	private String correo;
	private String contrasenya;
	private String poblacion;
	private ROL rol;
	
	//private Date dataNaiximent;
	
	
	public int getId() {
		return id;
	}
	public ROL getRol() {
		return rol;
	}
	public void setRol(ROL rol) {
		this.rol = rol;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public String getNomApell() {
		return nomApell;
	}
	public void setNomApell(String nomApell) {
		this.nomApell = nomApell;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public Usuari(int id, String nombreUser, String nomUser, String nomApell,String poblacion, String contrasenya,String correo) {
		super();
		this.id = id;
		this.nomUser = nomUser;
		this.nombreUser = nombreUser;
		this.nomApell = nomApell;
		this.correo = correo;
		this.contrasenya = contrasenya;
		this.poblacion = poblacion;
	}
	public Usuari(int id, String nombreUser, String nomUser, String nomApell,String poblacion, String contrasenya,String correo, ROL rol) {
		super();
		this.id = id;
		this.nomUser = nomUser;
		this.nombreUser = nombreUser;
		this.nomApell = nomApell;
		this.correo = correo;
		this.contrasenya = contrasenya;
		this.poblacion = poblacion;
	}
	@Override
	public String toString() {
		return "Usuari [id=" + id+"" + ", nomUser=" + nomUser + ", nombreUser=" + nombreUser + ", nomApell=" + nomApell
				+ ", correo=" + correo + ", contrasenya=" + contrasenya + ", poblacion=" + poblacion + "]";
	}
	
	
	
	//Getters Setters
	
	
	
//	public Date getDataNaiximent() {
//		return dataNaiximent;
//	}
//	public void setDataNaiximent(Date dataNaiximent) {
//		this.dataNaiximent = dataNaiximent;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
