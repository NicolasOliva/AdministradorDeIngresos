package Auxiliares;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.Anio;
import Clases.Cuenta;

public class archivo {
	
	
	// CUENTA 
	
	public void GuardarCuenta (Cuenta cuenta) {
		
		File archi = new File("Cuenta");
		
		try {
			
			ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(archi) );   // creo el flujo de salida de datos para guardarlo
		
			guardar.writeObject(cuenta);	// lo guardo 
			
			guardar.close();		// y cierro el objeto
		
		} catch (IOException e ) 	{
			
			e.printStackTrace();
			
		}		
		
	}
	
	public Cuenta LeerCuenta () {
		
		Cuenta cuenta = new Cuenta();
		
		try {
			
			ObjectInputStream Leer = new ObjectInputStream (new FileInputStream ("Cuenta") );			// creo el flujo de entrada de datos para utilizarlo
			
			cuenta = (Cuenta) Leer.readObject();			// lee el objeto 
			
			Leer.close();				
		
		} 
		catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();	
			
			JOptionPane.showMessageDialog(null, "ERROR: Archivo Cuenta no encontrado. Se creara uno nuevo vacio");
			
			Cuenta a = new Cuenta("", "");
			
			GuardarCuenta(a);
			
			JOptionPane.showMessageDialog(null, "Podra ingresar sin nombre ni contraseÒa");
			

		
		}  
		
		return cuenta;		// retorno la lista leido
	
		
	}
	
	
	// ARREGLO (AUTOCOMPLETER)
	
	public void GuardarArreglo (ArrayList Lista) {
		
		File archi = new File("Lista AutoCompleter");
		
		try {
			
			ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(archi) );   // creo el flujo de salida de datos para guardarlo
		
			guardar.writeObject(Lista);	// lo guardo 
			
			guardar.close();		// y cierro el objeto
		
		} catch (IOException e) 	{
			
			e.printStackTrace();
		
		}		
		
	}
	
	public ArrayList LeerArreglo () {
		
		ArrayList Lista = new ArrayList();
		
		try {
			
			ObjectInputStream Leer = new ObjectInputStream (new FileInputStream ("Lista AutoCompleter ") );			// creo el flujo de entrada de datos para utilizarlo
		
			Lista = (ArrayList) Leer.readObject();			// lee el objeto y se lo da a "a√±o" de tipo Anio
			
			Leer.close();				
		
		}catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();	
			
			JOptionPane.showMessageDialog(null, "ERROR: Archivo no encontrado. Se creara uno nuevo vacio");
			
			ArrayList a = new ArrayList();
			
			GuardarArreglo(a);
		
		}  
		
		return Lista;		// retorno la lista leido
	
		
	}
	
	
	// A—O
	
	public void GuardarAnio (Anio anio) {
		
		Object a = anio.getAnio();			// casteo el numero int a string
		
		File archi = new File(a.toString());
		
		try {
			
			ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(archi) );   // creo el flujo de salida de datos para guardarlo
		
			guardar.writeObject(anio);	// lo guardo 
			
			guardar.close();		// y cierro el objeto
		
		} catch (IOException e) 	{
			
			e.printStackTrace();
		
		}
	
	}

	public Anio LeerAnio (String nombre) {				// en el parametro le pongo el anio o la ruta del archivo que va a leer	
	
		Anio year = null;	
		
		try {
			
			ObjectInputStream Leer = new ObjectInputStream ( new FileInputStream (nombre) );			// creo el flujo de entrada de datos para utilizarlo
		
			year = (Anio) Leer.readObject();			// lee el objeto y se lo da a "a√±o" de tipo Anio
			
			Leer.close();				
		
		} 
		catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();			
		
			JOptionPane.showMessageDialog(null, "ERROR: Archivo no encontrado. Se creara uno nuevo");
			
		}  
		
		return year;		// retorno la anio leido
	
	}
	
}