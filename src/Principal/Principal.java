package Principal;

import java.util.Calendar;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import Auxiliares.archivo;
import Clases.Anio;
import Clases.Dia;
import Clases.Ingreso;
import Clases.Mes;
import Swing.VMenuPrincipal;

	public class Principal {

	public static archivo Archi = new archivo();
	
	public static Anio year = new Anio();
	
	// ________________ 
	
	public static Anio CrearAnio () {
	
	Anio year = new Anio(); 
	
	Mes mes = new Mes(); 
	
	Dia dia = new Dia();
	
	mes.CargaDia(dia);
	
	year.CargaMes(mes);
	
	return year;
	
}

	public static void Inicio () {
		
		Calendar calendar = Calendar.getInstance();
	
		int anioAux = calendar.get(Calendar.YEAR);  // me devuelve el anio actual 
		
		String anio = String.valueOf(anioAux);		// lo paso a un string 
		
		
		year = Archi.LeerAnio(anio);
		
		Anio aux = new Anio();
		
		
		if(year == null){
			
			aux = CrearAnio();
			
			Archi.GuardarAnio(aux);
			
			year = aux; 
			
		}else {
			
			Mes actual = year.UltimoMes();
			
			Mes MesNuevo = new Mes (); 
			
			if(actual.getMes() != MesNuevo.getMes() ){    // comparo el mes, si son difrentes creo un mes nuevo con un dia nuevo y se lo cargo a anio
 				
				Dia DiaNuevo = new Dia(); 
				
				MesNuevo.CargaDia(DiaNuevo);
				
				year.CargaMes(MesNuevo);
				
			} else { 
				
				Dia DiaActual = year.UltimoDia();
				
				Dia DiaNuevo = new Dia();
				
				if (DiaActual.getDia() != DiaNuevo.getDia()) {    // si el anio y el mes son iguales, comparo el dia, si es diferente creo un dia nuevo, lo guardo en el mes y el mes en el anio
					
					year.CargaDia(DiaNuevo);

				}
				
			
			}
		
		}
	
}
	
	public static void CargaIngresoDelDia (Ingreso i) {
		
		Principal.year.UltimoDia().CargaIngreso(i);	 
		
		Principal.year.UltimoMes().CargaIngresosMes(i); 

		Principal.year.CargaIngresoAnio(i);
		
	}
	
	public static Dia DevolverDia (JDateChooser Date) {
		
		Dia aux = null; 
		
		int dia= Date.getCalendar().get(Calendar.DAY_OF_MONTH); 	// obtengo las fechas por separado 
		int mes= Date.getCalendar().get(Calendar.MONTH) + 1 ; 
		int anio= Date.getCalendar().get(Calendar.YEAR); 
		
		if (anio == year.getAnio() ) {
			
			Mes m = year.DevolverMes(mes);
			
			if (m != null) {
			
			aux = m.DevolverDia(dia);
					
			}
			
		} else {
			
			JOptionPane.showMessageDialog(null, "Dia ingresado no valido");
			
			
		}
		
		return aux; 
		
	}
	
	public static void main(String[] args) {
		
		Inicio();

		VMenuPrincipal menu = new VMenuPrincipal ();
		
		menu.setVisible(true);
		
		Archi.GuardarAnio(year);
		
	}
	
}
	
	
	
