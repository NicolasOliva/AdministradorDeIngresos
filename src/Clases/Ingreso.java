package Clases;

import java.io.Serializable;
import java.util.Calendar;

public class Ingreso  implements Serializable {
	
	protected int identificador;  // va a recibir el numero que le de el ID
	
	protected int valor; 
	
	protected String nombre; 
	
	protected int cantidad; 
	
	protected int Hora;    
	
	protected int Minuto;
	
	protected boolean MO; 
	
	// CONSTRUCTOR
	
	public Ingreso (int v, String n, Anio a, int c) {
		
		Calendar H1 = Calendar.getInstance();
		
		Hora = H1.get(Calendar.HOUR_OF_DAY);
		
		Minuto = H1.get(Calendar.MINUTE);
		
		valor = v;
		
		nombre = n; 
		
		cantidad = c; 
		
		MO = true;
		
		identificador = a.getID();	// uso el ID que contiene anio para darle un valor unico al producto
		
		a.SumarID();
		
	}


	// GET Y SET 

	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHora() {
		return Hora;
	}

	public void setHora(int hora) {
		Hora = hora;
	}

	public int getMinuto() {
		return Minuto;
	}

	public void setMinuto(int minuto) {
		Minuto = minuto;
	}

	public boolean isMO() {
		return MO;
	}

	public void setMO(boolean mO) {
		MO = mO;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
}