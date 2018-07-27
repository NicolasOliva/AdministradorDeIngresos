package Clases;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;

public class Anio implements Serializable {
	
	protected int ID;		// numero unico, identificador de los productos 
	
	protected int anio;	// numero del año 

	protected int TotalDelAnio;
	
	protected int TotalMO;
	
	protected int TotalMercaderia;
	
	protected ArrayList<Mes> ListaMeses = new ArrayList <Mes> (); 
	
	// CONSTRUCTOR 
	
	public Anio () {
		
		Calendar H1 = Calendar.getInstance();
		
		anio = H1.get(Calendar.YEAR);				// recibo el numero del anio
		
		TotalDelAnio = 0;
		
	}
	
	// METODOS 

	public void CargaDia (Dia d) {
		
		Mes m = UltimoMes();
		
		m.CargaDia(d);
		
		CargaMes(m);
		
	}

	public void CargaMes (Mes m) {
		
		ListaMeses.add(m);
		
	}
	
	public Mes UltimoMes () {
		
		Mes m = ListaMeses.get(ListaMeses.size() - 1 );
		
		return m;
		
	}

	public Dia UltimoDia () {
		
		Mes MesUltimo = UltimoMes();
		
		Dia	DiaUltimo = MesUltimo.UltimoDia(); 
		
		return DiaUltimo;
		
	}
	
	public void CargaIngresoAnio (Ingreso i) {
		
		if(i.isMO() ){
			
			TotalMO = TotalMO + i.getValor();
			
		}else {
			
			TotalMercaderia = TotalMercaderia + i.getValor();
			
		}

		TotalDelAnio = TotalDelAnio + i.getValor();
				
	}
			
	protected void SumarID () {
		
		ID++;
		
	}
	
	public void DescontarIngreso (Ingreso i) {
		
		if(i.isMO() ){
			
			TotalMO = TotalMO - i.getValor();
			
		}else {
			
			TotalMercaderia = TotalMercaderia - i.getValor();
			
		}

		TotalDelAnio = TotalDelAnio - i.getValor(); 
		
	}
	
	public ArrayList DevuelveTodosDias() {
		
		ArrayList Lista = new ArrayList (); 
		
		for(int i = 0; i < ListaMeses.size() ; i++) {		// recorro los meses del anio 
			
			Mes m = ListaMeses.get(i);						// obtengo un mes cargado 

			for(int j = 0; j < m.getListaDias().size() ; j++) {		// cargo en la "Lista" los dias de ese mes
				
				Dia d = m.getListaDias().get(j);
			
				Lista.add(d);
				
			}
				
		}
		
		return Lista; 
		
	}
	
	public Mes DevolverMes (int num) {
		
		Mes aux = null; 
		
		int flag = 0; 
		
		for(int i = 0; i < ListaMeses.size() && flag == 0; i++) {
			
			aux = ListaMeses.get(i);
			
			if(aux.getMes() == num) {
				
				flag = 1; 
				
			}
			
		}
		
		return aux; 
		
	}
	
	public String DevolverNombreMes (int num) {
		
		String aux = null; 
		
		switch(num){
			
			case 1:	aux = "Enero";
					break; 	
			
			case 2: aux = "Febrero";
					break; 
			
			case 3: aux = "Marzo";
			 		break; 	
			
			case 4: aux = "Abril";
	 				break; 	
	
			case 5: aux = "Mayo";
	 				break; 	
	
			case 6: aux = "Junio";
	 				break; 	
	
			case 7: aux = "Julio";
	 				break; 	
	
			case 8: aux = "Agosto";
	 				break; 	
	
			case 9: aux = "Septiembre";
	 				break; 	
	
			case 10: aux = "Octubre";
	 				 break; 	
	
			case 11: aux = "Noviembre";
	 				 break; 	
			
			case 12: aux = "Diciembre";
	 				 break; 	
			
		}
		
		return aux; 
		
	}
	
	
	// GEY Y SET 
	
	public int getID() {
		return ID;
	}
	
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}	
	
	public ArrayList<Mes> getListaMeses() {
		return ListaMeses;
	}

	public void setListaMeses(ArrayList<Mes> listaMeses) {
		ListaMeses = listaMeses;
	}

	public int getTotalDelAnio() {
		return TotalDelAnio;
	}

	public int getTotalMO() {
		return TotalMO;
	}
	
	public int getTotalMercaderia() {
		return TotalMercaderia;
	}

}
