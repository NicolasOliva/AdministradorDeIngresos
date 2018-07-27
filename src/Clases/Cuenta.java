package Clases;

import java.io.Serializable;

public class Cuenta implements Serializable{

	protected String nombre;
	
	protected String contrasenia;


	// METODOS 
	
	public Cuenta () {
		
	}
	
	public Cuenta (String n, String c) {
		
		nombre = n; 
		
		contrasenia = c;
		
	}
	
	
	// GETTERS AND SETTERS 
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
