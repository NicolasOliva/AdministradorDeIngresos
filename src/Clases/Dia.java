package Clases;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;


public class Dia implements Serializable  {
	
	protected int Dia; 

	HashMap <Integer,Ingreso> ListaMO = new HashMap <Integer , Ingreso> ();			// identificara cada ingreso por su id
	
	HashMap <Integer,Ingreso> ListaMercaderia = new HashMap <Integer , Ingreso> ();	// identificara cada ingreso por su id
	
	int TotalMO;
	
	int TotalMercaderia; 
	
	int TotalDelDia;

	// CONSTRUCTOR 
	
	public Dia (){
		
		Calendar H1 = Calendar.getInstance();
		
		Dia = H1.get(Calendar.DAY_OF_MONTH);

		TotalMO = 0; 
		
		TotalMercaderia = 0;
		
		TotalDelDia = 0;
	
	}

	
	// METODOS 
	
	public void CargaIngreso (Ingreso i) {
		
		if (i.isMO() ) {
			
			ListaMO.put(i.getIdentificador(), i);
			
		} else {
			
			ListaMercaderia.put(i.getIdentificador(), i);
			
		}
		
		CerrarCaja ();
		
	}
	
	private int DevuelveTotal (HashMap<Integer, Ingreso> Lista)	{		// devuelve el total de una lista de ingresos
		
		Set <Integer> identificadores = Lista.keySet();								// creo una variable que contenga todas las keys del hashmap 
		
		int total = 0;
		
		for (Integer i : identificadores) 	{
			
			Ingreso ingreso = Lista.get(i);												
			
			total = total + ingreso.getValor();
			
		}
		
		return total;	
	
	}	
	
	public Ingreso DevuelveIngreso (HashMap<Integer,Ingreso> Lista, int id) {
		
		Ingreso aux = Lista.get(id);
	
		return aux;
		
	}
	
	public void EliminarIngreso (HashMap<Integer,Ingreso> Lista, int id) {
		
		Lista.remove(id);
		
	}
	
	public void DescontarDelTotal (Ingreso i) {
		
		if (i.isMO() ) {
			
			TotalMO = TotalMO - i.getValor();
			
			ListaMO.remove(i.getIdentificador() );
			
		} else {
			
			TotalMercaderia = TotalMercaderia - i.getValor();
			

			ListaMercaderia.remove(i.getIdentificador() );
			
		}
		
		TotalDelDia = TotalDelDia - i.getValor();
		
		
	}
	
	public void CerrarCaja () {		// carga todos los totales (TotalMO , TotalMercaderia, TotalDelDia)
			
			TotalMO = DevuelveTotal(ListaMO);
			
			TotalMercaderia = DevuelveTotal(ListaMercaderia);
			
			TotalDelDia = TotalMO + TotalMercaderia;

	}
	


	
	// GET Y SET 
	
	public int getDia() {
		return Dia;
	}

	public void setDia(int dia) {
		Dia = dia;
	}

	public HashMap<Integer, Ingreso> getListaMO() {
		return ListaMO;
	}

	public HashMap<Integer, Ingreso> getListaMercaderia() {
		return ListaMercaderia;
	}

	public int getTotalMO() {
		return TotalMO;
	}

	public int getTotalMercaderia() {
		return TotalMercaderia;
	}

	public int getTotalDelDia() {
		return TotalDelDia;
	}

	
}

