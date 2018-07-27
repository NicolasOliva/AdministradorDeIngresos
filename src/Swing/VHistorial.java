package Swing;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Clases.Anio;
import Clases.Dia;
import Clases.Ingreso;
import Clases.Mes;
import Principal.Principal;
import com.toedter.calendar.JDateChooser;

public class VHistorial extends JFrame {

	JLabel lbl;
	JLabel espacio;
	private JPanel contentPane;
	
	public VHistorial() {
		
		setTitle("Historial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1025, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		// LABELS 
		
		JLabel lblManoDeObra = new JLabel("Mano de obra : ");
		lblManoDeObra.setBounds(23, 114, 96, 25);
		contentPane.add(lblManoDeObra);
		
		JLabel lblMercaderia = new JLabel("Mercaderia : ");
		lblMercaderia.setBounds(528, 116, 74, 20);
		contentPane.add(lblMercaderia);
		
		JLabel lblIngresosManoDeObra = new JLabel("Ingresos Mano de obra: ");
		lblIngresosManoDeObra.setBounds(23, 551, 278, 20);
		contentPane.add(lblIngresosManoDeObra);
		
		JLabel lblIngresosMercaderia = new JLabel("Ingresos Mercaderia: ");
		lblIngresosMercaderia.setBounds(528, 551, 269, 20);
		contentPane.add(lblIngresosMercaderia);
		
		JLabel lblTotalDia = new JLabel("");
		lblTotalDia.setBounds(23, 595, 176, 14);
		contentPane.add(lblTotalDia);
		
		JLabel lblTotalMes = new JLabel("");
		lblTotalMes.setBounds(23, 629, 176, 14);
		contentPane.add(lblTotalMes);
		
		JLabel lblTotalAo = new JLabel("");
		lblTotalAo.setBounds(23, 666, 176, 14);
		contentPane.add(lblTotalAo);
		
		JLabel lblAo = new JLabel("");
		lblAo.setBounds(23, 76, 112, 14);
		contentPane.add(lblAo);
		
		JLabel lblMes = new JLabel("");
		lblMes.setBounds(109, 76, 112, 14);
		contentPane.add(lblMes);
		
		JLabel lblDia = new JLabel("");
		lblDia.setBounds(233, 76, 106, 14);
		contentPane.add(lblDia);		
		
		
		JLabel lblMesMO = new JLabel("");
		lblMesMO.setBounds(233, 629, 228, 14);
		contentPane.add(lblMesMO);
		
		JLabel lblAnioMO = new JLabel("");
		lblAnioMO.setBounds(233, 666, 228, 14);
		contentPane.add(lblAnioMO);
		
		JLabel lblMesMercaderia = new JLabel("");
		lblMesMercaderia.setBounds(528, 629, 221, 14);
		contentPane.add(lblMesMercaderia);
		
		JLabel lblAnioMercaderia = new JLabel("");
		lblAnioMercaderia.setBounds(528, 666, 221, 14);
		contentPane.add(lblAnioMercaderia);
		
		// BOTON ATRAS
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnAtras.setBounds(934, 666, 65, 25);
		contentPane.add(btnAtras);
		
		
		// DATECHOOSER  
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(23, 25, 95, 20);
		contentPane.add(dateChooser);
		
		
		// PANEL MANO DE OBRA  
		
		JScrollPane scrollPane_MO = new JScrollPane();
		scrollPane_MO.setBounds(23, 150, 455, 390);
		contentPane.add(scrollPane_MO);
		
		JPanel panel_MO = new JPanel();
		panel_MO.setBackground(SystemColor.menu);
		scrollPane_MO.setViewportView(panel_MO);
		panel_MO.setLayout(new BoxLayout(panel_MO, BoxLayout.Y_AXIS));
		
		
		// PANEL MERCADERIA 
		
		JScrollPane scrollPanel_Mercaderia = new JScrollPane();
		scrollPanel_Mercaderia.setBounds(528, 150, 455, 390);
		contentPane.add(scrollPanel_Mercaderia);
		
		JPanel panel_mercaderia = new JPanel();
		panel_mercaderia.setBackground(SystemColor.menu);
		scrollPanel_Mercaderia.setViewportView(panel_mercaderia);
		panel_mercaderia.setLayout(new BoxLayout(panel_mercaderia, BoxLayout.Y_AXIS));
		
	
		// BOTON MOSTRAR FECHA  
		
		JButton btnMostrarFecha = new JButton("Mostrar Fecha ");
		btnMostrarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {

				Dia day = Principal.DevolverDia(dateChooser);
				
				int mes= dateChooser.getCalendar().get(Calendar.MONTH) + 1 ; 
				Mes m = Principal.year.DevolverMes(mes);
				
				int anio= dateChooser.getCalendar().get(Calendar.YEAR);   //obtengo el numero de año seleccionado en el dateChooser
				String numero = String.valueOf(anio);	// lo paso a un tring
				Anio a = Principal.Archi.LeerAnio(numero); // lo obtengo a traves del archivo 
						
				ActualizarPaneles(panel_MO , panel_mercaderia , day);
			
				lblIngresosManoDeObra.setText("Ingresos Mano de obra: " + day.getTotalMO() );
				lblIngresosMercaderia.setText("Ingresos Mercaderia: " + day.getTotalMercaderia() );
				lblTotalDia.setText("Total Dia : " + day.getTotalDelDia() );
				lblTotalMes.setText("Total Mes : " + m.getTotalDelMes() );
				lblTotalAo.setText("Total Año : " + a.getTotalDelAnio() );
				lblAo.setText("AÑO: " + a.getAnio());
				lblMes.setText("MES: " + a.DevolverNombreMes(mes) );
				lblDia.setText("DIA: " + day.getDia());
				lblMesMO.setText("Total Mes Mano de obra : " + m.getTotalMO() );
				lblMesMercaderia.setText("Total Mes Mercaderia : " + m.getTotalMercaderia() );
				lblAnioMO.setText("Total Año Mano de obra : " + a.getTotalMO() );
				lblAnioMercaderia.setText("Total Año Mercaderia : " + a.getTotalMercaderia() );
				
				
				}catch(NullPointerException e){
					
					JOptionPane.showMessageDialog(null, "Dia ingresado inconrrecto");
					
				}
			}
		});
		btnMostrarFecha.setBounds(128, 25, 127, 23);
		contentPane.add(btnMostrarFecha);

		}

	public void ActualizarPaneles (JPanel panel_mo, JPanel panel_merc, Dia dia){

	panel_mo.removeAll();
	panel_merc.removeAll();	//limpio los paneles para que no se mesclen los ingresos con los de otro dia
		
	int tamaño = dia.getListaMO().size() + dia.getListaMercaderia().size(); //cuento la cantidad de ingresos que hay en el dia y la comparo en el while	
	int j = menor_id(dia); //me devuelve el numero del primer id del dia
	int i = 0; 
	
	while (tamaño != i) {	
		
		Ingreso ingreso = (Ingreso) dia.getListaMO().get(j);												
		
		if(ingreso == null){
			
			 ingreso = (Ingreso) dia.getListaMercaderia().get(j);
			
		}
		
		if(ingreso != null) { // compruebo de que haya un ingreso
			
			i++; //sumo un ingreso mostrado en pantalla
			
			if(ingreso.isMO()) {
				
			lbl = new JLabel(" ID: " + ingreso.getIdentificador() +" |      Nombre : " + ingreso.getNombre() + "    Cantidad: " + ingreso.getCantidad() + "    Importe: " + ingreso.getValor() + "     | Hora: " + ingreso.getHora() + ":" + ingreso.getMinuto() );
			
			lbl.setFont(new Font("Times Roman", Font.BOLD, 12));
			
			espacio = new JLabel(" ");
			
			panel_mo.add(lbl);
	
			panel_mo.add(espacio);
			
			}else {
				
				lbl = new JLabel(" ID: " + ingreso.getIdentificador() +" |      Nombre : " + ingreso.getNombre() + "    Cantidad: " + ingreso.getCantidad() + "    Importe: " + ingreso.getValor() + "     | Hora: " + ingreso.getHora() + ":" + ingreso.getMinuto() );
				
				lbl.setFont(new Font("Times Roman", Font.BOLD, 12));
				
				espacio = new JLabel(" ");
				
				panel_merc.add(lbl);
		
				panel_merc.add(espacio);
					
			}
			
		}
		
		j++;
	
	}
	
}
	
	public int menor_id (Dia dia){
			
			HashMap <Integer,Ingreso> ListaMO = dia.getListaMO();
			HashMap <Integer,Ingreso> ListaMercaderia = dia.getListaMercaderia();
			int flag = 0; 
			int menor = 0;
			
			
			Set <Integer> identificadores = ListaMO.keySet();
			
			for (Integer i : identificadores) {
				
				Ingreso ingreso = ListaMO.get(i);												
				
				while (flag == 0){   //cargo el primer ingreso, para tener un parametro
					
					menor = ingreso.getIdentificador();
					
					flag = 1;
					
				}
				
				if(menor > ingreso.getIdentificador() ){
					
					menor = ingreso.getIdentificador();
					
				}
				
			}
			
			
			Set <Integer> identificador_merc = ListaMercaderia.keySet();
			
			for (Integer i : identificador_merc) {
				
				Ingreso ingreso = ListaMercaderia.get(i);												
				
				if(menor > ingreso.getIdentificador() ){
					
					menor = ingreso.getIdentificador();
					
				}
				
			}
			
			return menor;
			
		}
}

