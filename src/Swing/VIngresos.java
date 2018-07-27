package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Clases.Dia;
import Clases.Ingreso;
import Principal.Principal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class VIngresos extends JFrame {

	JPanel contentPane;
	JLabel lbl;
	JLabel espacio;
	private JTextField textField_IDMO;
	private JTextField textField_IDMercaderia;
	
	public VIngresos() {
		setBackground(Color.DARK_GRAY);
		
		setTitle("Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1025, 740);
			
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_IDMO = new JTextField();
		textField_IDMO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				char a = ke.getKeyChar();
				
				if((a<'0' || a>'9') || (textField_IDMO.getText().length() == 8)) {
				
					ke.consume();
				}
			}
		});
		textField_IDMO.setBounds(155, 583, 86, 20);
		contentPane.add(textField_IDMO);
		textField_IDMO.setColumns(10);
		
		textField_IDMercaderia = new JTextField();
		textField_IDMercaderia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				char a = ke.getKeyChar();
				
				if((a<'0' || a>'9') || (textField_IDMercaderia.getText().length() == 8)) {
					
					ke.consume();
				}
				
			}
		});
		textField_IDMercaderia.setColumns(10);
		textField_IDMercaderia.setBounds(679, 583, 86, 20);
		contentPane.add(textField_IDMercaderia);
		
		
		// BOTON MANO DE OBRA 
		
		JButton btnManoDeObra = new JButton("Mano de obra ");
		btnManoDeObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VManoDeObra mo = new VManoDeObra();
				
				mo.setVisible(true);
				
				dispose();
				
			}
		});
		btnManoDeObra.setBounds(178, 42, 146, 42);
		contentPane.add(btnManoDeObra);
		
		// BOTON MERCADERIA
		
		JButton btnNewButton = new JButton("Mercaderia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VMercaderia mercaderia = new VMercaderia();
				
				mercaderia.setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton.setBounds(682, 42, 146, 42);
		contentPane.add(btnNewButton);
		
		// BOTON ATRAS
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnAtras.setBounds(934, 666, 65, 25);
		contentPane.add(btnAtras);
		
		
		// PANEL MANO DE OBRA 

		JScrollPane scrollPane_MO = new JScrollPane();
		scrollPane_MO.setBounds(24, 115, 455, 441);
		contentPane.add(scrollPane_MO);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		scrollPane_MO.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		// PANEL MERCADERIA 
		
		JScrollPane scrollPanel_Mercaderia = new JScrollPane();
		scrollPanel_Mercaderia.setBounds(530, 115, 455, 441);
		contentPane.add(scrollPanel_Mercaderia);
		
		JPanel panel_mercaderia = new JPanel();
		panel_mercaderia.setBackground(SystemColor.menu);
		scrollPanel_Mercaderia.setViewportView(panel_mercaderia);
		panel_mercaderia.setLayout(new BoxLayout(panel_mercaderia, BoxLayout.Y_AXIS));
		
		// -------------------------------- 

		ActualizarPaneles(panel, panel_mercaderia, Principal.year.UltimoDia() );

		// --------------------------------
		
		// BOTON MODIFICAR INGRESO MANO DE OBRA 
		
		JButton btn_ModificarMO = new JButton("Modificar");
		btn_ModificarMO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HashMap < Integer , Ingreso> Lista = Principal.year.UltimoDia().getListaMO();
				
				try{
				
				int id = Integer.parseInt(textField_IDMO.getText() );
				
				if(ValidarID(textField_IDMO,id,Lista) ) {  // si el id es true realiza el proceso
				
					Dia d = Principal.year.UltimoDia();
					
					Ingreso aux = d.DevuelveIngreso(d.getListaMO() ,id); 

					VModificarIngreso MI = new VModificarIngreso(aux);
					
					MI.setVisible(true);
					
					dispose();
				
				}
				
				}catch(NumberFormatException e){

					JOptionPane.showMessageDialog(null, "Debe ingresar un ID ");
					
				}
				
			}
		});
		btn_ModificarMO.setBounds(249, 582, 97, 23);
		contentPane.add(btn_ModificarMO);
		
		
		// BOTON ELIMINAR INGRESO MO
		
		JButton btn_EliminarMO = new JButton("Eliminar");
		btn_EliminarMO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HashMap < Integer , Ingreso> Lista = Principal.year.UltimoDia().getListaMO();
				
				try {
				
				int id = Integer.parseInt(textField_IDMO.getText() );
				
				if(ValidarID(textField_IDMO,id,Lista) ) {  // si el id es true realiza el proceso
				
				Dia d = Principal.year.UltimoDia();
	
				Ingreso aux = d.DevuelveIngreso(d.getListaMO(), id);

				dispose();

				VEliminarIngreso EI = new VEliminarIngreso(Principal.year.UltimoDia().getListaMO(), aux);
				
				EI.setVisible(true);	
				
				}
				
				}catch(NumberFormatException e){

					JOptionPane.showMessageDialog(null, "Debe ingresar un ID ");
					
				}
				
			}
		});
		btn_EliminarMO.setBounds(249, 616, 97, 23);
		contentPane.add(btn_EliminarMO);
		
		JLabel lbl_ID = new JLabel("ID : ");
		lbl_ID.setBounds(134, 586, 21, 14);
		contentPane.add(lbl_ID);
		
		
		// BOTON MODIFICAR INGRESO MERCADERIA 
		
		JButton btn_modificarMerc = new JButton("Modificar");
		btn_modificarMerc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HashMap < Integer , Ingreso> Lista = Principal.year.UltimoDia().getListaMercaderia();
				
				try{
				
				int id = Integer.parseInt(textField_IDMercaderia.getText() );
				
				if(ValidarID(textField_IDMercaderia,id,Lista) ) {  // si el id es true realiza el proceso
				
				Dia d = Principal.year.UltimoDia();
				
				Ingreso aux = d.DevuelveIngreso(d.getListaMercaderia() ,id);

				VModificarIngreso MI = new VModificarIngreso(aux);
				
				MI.setVisible(true);
				
				dispose();
						
				}
				
				}catch(NumberFormatException e){

					JOptionPane.showMessageDialog(null, "Debe ingresar un ID ");
					
				}
				
			}
		});
		btn_modificarMerc.setBounds(775, 582, 97, 23);
		contentPane.add(btn_modificarMerc);

		
		// BOTON ELIMINAR INGRESO MERCADERIA
		
		JButton btn_EliminarMerc = new JButton("Eliminar");
		btn_EliminarMerc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HashMap < Integer , Ingreso> Lista = Principal.year.UltimoDia().getListaMercaderia();
				
				try{
				
				int id = Integer.parseInt(textField_IDMercaderia.getText() );
					
					if(ValidarID(textField_IDMercaderia,id,Lista) ) {  // si el id es true realiza el proceso
						
						Dia d = Principal.year.UltimoDia();
			
						Ingreso aux = d.DevuelveIngreso(d.getListaMercaderia(), id);

						dispose();

						VEliminarIngreso EI = new VEliminarIngreso(Principal.year.UltimoDia().getListaMercaderia(), aux);
						
						EI.setVisible(true);	
						
						}
					
				}catch(NumberFormatException e){

					JOptionPane.showMessageDialog(null, "Debe ingresar un ID ");
					
				}
				
			
			}
		});
		btn_EliminarMerc.setBounds(775, 616, 97, 23);
		contentPane.add(btn_EliminarMerc);
		
		JLabel label = new JLabel("ID : ");
		label.setBounds(659, 586, 21, 14);
		contentPane.add(label);

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

	 public int menor_id (Dia dia){ // funcion que utiliza 'ActualizarPaneles'
		
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

	 public boolean ValidarID (JTextField TF , int id , HashMap < Integer , Ingreso> Lista) {
			
			int numero = 8;
			
			if (TF.getText().length() > numero ){
				
				JOptionPane.showMessageDialog(null, "Numero demasiado largo");
				
				return false;
				
			} else {
			
			if(id < 0 || id > (Principal.year.getID()-1) ) {    // valido que se ingrese un numero entre 0 y el ultimo id cargado
				
				JOptionPane.showMessageDialog(null, "Numero incorrecto");
				
				return false;
				
			}else {
					
					if (Lista.get(id) == null ) {
						
						JOptionPane.showMessageDialog(null, "Este id no se encuentra en la lista de mano de obra ");

						return false;
						
					} else {
						
						return true;
						
					}
					
				  }
			
			}
		
	   }
		
}
