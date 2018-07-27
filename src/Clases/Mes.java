package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Mes implements Serializable {

	protected ArrayList<Dia> ListaDias = new ArrayList <Dia> (); 
	
	protected int Mes;	// numero del mes		
	
	protected int TotalDelMes;	// total de ganancias del mes
	
	protected int TotalMO;
	
	protected int TotalMercaderia;
	
	// CONSTRUCTOR 
	
	public Mes () {
		
		Calendar H1 = Calendar.getInstance();
		
		int a = H1.get(Calendar.MONTH);				// recido el numero de mes. Pero devuelve un numero menos
		
		Mes = a+1;
		
		TotalDelMes = 0;
		
	}
	
	
	// METODOS 

	public void CargaDia (Dia a) {
		
		ListaDias.add(a);
		
	}
	
	public Dia UltimoDia () {
		
		Dia a = ListaDias.get(ListaDias.size() -1 );
		
		return a;
		
	}
	
	public void CargaIngresosMes (Ingreso i) {
			
			if(i.isMO() ){
				
				TotalMO = TotalMO + i.getValor();
				
			}else {
				
				TotalMercaderia = TotalMercaderia + i.getValor();
				
			}
			
			TotalDelMes = TotalDelMes + i.getValor();
			
	}
	
	public void DescontarIngreso (Ingreso i) {
		
		if(i.isMO() ){
			
			TotalMO = TotalMO - i.getValor();
			
		}else {
			
			TotalMercaderia = TotalMercaderia - i.getValor();
			
		}
		
		TotalDelMes = TotalDelMes - i.getValor();; 
		
	}
	
	public Dia DevolverDia (int num) {
		
		Dia aux = null; 
		
		int flag = 0; 
		
		for(int i = 0; i < ListaDias.size() && flag == 0; i++) {
			
			aux = ListaDias.get(i);
			
			if(aux.getDia() == num) {
				
				flag = 1; 
				
			}
			
		}
		
		return aux; 
		
	}
	
	
	// GET Y SET 

	public int getMes() {
		return Mes;
	}

	public void setMes(int mes) {
		Mes = mes;
	}
	
	public ArrayList<Dia> getListaDias() {
		return ListaDias;
	}
	
	public void setListaDias(ArrayList<Dia> listaDias) {
		ListaDias = listaDias;
	}

	public int getTotalDelMes() {
		return TotalDelMes;
	}
	
	public int getTotalMO() {
		return TotalMO;
	}
	
	public int getTotalMercaderia() {
		return TotalMercaderia;
	}

}
