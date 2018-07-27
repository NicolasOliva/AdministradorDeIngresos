package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Dia;
import Clases.Ingreso;
import Principal.Principal;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class VAutoCompleter extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JLabel label;
	private JLabel espacio;
  
	public VAutoCompleter() {
		setTitle("Lista AutoCompletar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 170, 453, 381);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_lista = new JScrollPane();
		scrollPane_lista.setBounds(163, 36, 260, 245);
		contentPane.add(scrollPane_lista);
		
		JPanel panel_lista = new JPanel();
		scrollPane_lista.setViewportView(panel_lista);
		panel_lista.setLayout(new BoxLayout(panel_lista, BoxLayout.Y_AXIS)); // permite que cada string se posicione uno arriba del otro
		
		ArrayList Lista = Principal.Archi.LeerArreglo();
		
		CreaRenglon(panel_lista,Lista);
		
		
		// BOTON ATRAS 
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnAtras.setBounds(355, 308, 68, 23);
		contentPane.add(btnAtras);
		
		
		// BOTON CARGAR 
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				VNuevoAutoCompleter ventana = new VNuevoAutoCompleter(); 
				
				ventana.setVisible(true);
				
				dispose();
				
			}
		});
		btnCargar.setBounds(29, 109, 89, 23);
		contentPane.add(btnCargar);
		
		
		// BOTON ELIMINAR 
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_id.getText().isEmpty() ) {
					
					JOptionPane.showMessageDialog(null, "Campo vacio");
					
				}else {
					
					int id = Integer.parseInt(textField_id.getText() );
		
					ArrayList Lista = Principal.Archi.LeerArreglo();
					
					try {
						
						Lista.get(id);
						
					}catch (IndexOutOfBoundsException e) {
						
						JOptionPane.showMessageDialog(null, "Numero incorrecto");
						
					}
					
				BorrarRenglon(Lista, textField_id);
				
				Principal.Archi.GuardarArreglo(Lista);
				
				Actualizar();
				
				}	
			
			}
		});
		btnEliminar.setBounds(29, 154, 89, 23);
		contentPane.add(btnEliminar);
		
		
		// TEXTFIELD  
		
		textField_id = new JTextField();
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				char a = ke.getKeyChar();

				if((a<'0' || a>'9') || (textField_id.getText().length() == 8)) {
					
					ke.consume();
				
				}
				
			}
		});
		textField_id.setBounds(55, 48, 63, 23);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNombre = new JLabel("ID :");
		lblNombre.setBounds(33, 57, 61, 14);
		contentPane.add(lblNombre);
		
		
		
		
		
		
	}
	
	public void CreaRenglon (JPanel panel , ArrayList Lista){
		
			
		for (int i = 0; i<Lista.size() ;i++) {
			
			String palabra = (String) Lista.get(i);												
			
			label = new JLabel("  ID : " + i + "       Nombre : " + palabra); 
			
			espacio = new JLabel(" ");
			
			panel.add(label);
	
			panel.add(espacio);
		
		}
		
	}
	
	public void BorrarRenglon (ArrayList Lista, JTextField id){
		
		int numero = Integer.parseInt(id.getText() ); // convierto el TextField en int
					
		Lista.remove(numero);
	
	}
	
	public void Actualizar () {
		
		VAutoCompleter ventana = new VAutoCompleter();
		
		ventana.setVisible(true);
		
		dispose();
		
	}


}
