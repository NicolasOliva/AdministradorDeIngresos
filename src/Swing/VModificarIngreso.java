package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Clases.Dia;
import Clases.Ingreso;
import Clases.Mes;
import Principal.Principal;
import java.awt.Color;
import java.awt.SystemColor;

public class VModificarIngreso extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Ingreso;
	private JTextField textField_Nombre;
	private JTextField textField_Cantidad;

	public VModificarIngreso(Ingreso i) {
		
		setTitle(" Modificar Ingreso ");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 278, 223);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// BOTON ATRAS
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnAtras.setBounds(10, 152, 92, 25);
		contentPane.add(btnAtras);
		
		JLabel lblIngreso = new JLabel("Ingreso : ");
		lblIngreso.setBounds(29, 105, 73, 18);
		contentPane.add(lblIngreso);
		
		textField_Ingreso = new JTextField();
		textField_Ingreso.setBounds(106, 104, 48, 20);
		contentPane.add(textField_Ingreso);
		textField_Ingreso.setColumns(10);
		textField_Ingreso.setText(Integer.toString(i.getValor() ) );
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(29, 24, 73, 14);
		contentPane.add(lblNombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(106, 21, 86, 20);
		contentPane.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		textField_Nombre.setText(i.getNombre() );
		
		JLabel lblCantidad = new JLabel("Cantidad : ");
		lblCantidad.setBounds(29, 66, 61, 14);
		contentPane.add(lblCantidad);
		
		textField_Cantidad = new JTextField();
		textField_Cantidad.setBounds(106, 63, 30, 20);
		contentPane.add(textField_Cantidad);
		textField_Cantidad.setColumns(10);
		textField_Cantidad.setText(Integer.toString(i.getCantidad() ) );
	
		
		// GUARDA EL INGRESO CARGADO 
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ingreso =   Integer.parseInt(textField_Ingreso.getText() );	
				
				int cantidad = Integer.parseInt(textField_Cantidad.getText());
				
				String nombre =  textField_Nombre.getText();
				
				Ingreso ing = new Ingreso( ingreso , nombre , Principal.year, cantidad); // creo el ingreso modificado 
				
				if (!i.isMO()){		// le asigno al ingreso modificado si es MO o Mercaderia
					
					ing.setMO(false);
					
				}
				
				DescontarIngreso(i);	
				
				Principal.CargaIngresoDelDia(ing);   
				
				Principal.Archi.GuardarAnio(Principal.year);	// guardo el año 
				
				VIngresos VI = new VIngresos();
				
				VI.setVisible(true);
				
				dispose();
				
			}
		});
		
		btnGuardar.setBounds(164, 153, 92, 23);
		contentPane.add(btnGuardar);
		

	}
	
	public void DescontarIngreso(Ingreso i) {
			
		Principal.year.DescontarIngreso(i);
		
		Principal.year.UltimoMes().DescontarIngreso(i);; 
		
		Principal.year.UltimoDia().DescontarDelTotal(i);
				
	}
	
}
