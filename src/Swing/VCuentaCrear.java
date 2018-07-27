package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Cuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCuentaCrear extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_contrasenia;

	public VCuentaCrear() {
		setTitle("Modificar Cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(340, 250, 384, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nuevo nombre : ");
		lblNombre.setBounds(34, 24, 104, 20);
		contentPane.add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Nueva Contrase\u00F1a : ");
		lblContrasea.setBounds(34, 80, 128, 20);
		contentPane.add(lblContrasea);
		
		textField_nombre = new JTextField(Principal.Principal.Archi.LeerCuenta().getNombre());
		textField_nombre.setBounds(134, 24, 104, 20);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_contrasenia = new JTextField(Principal.Principal.Archi.LeerCuenta().getContrasenia());
		textField_contrasenia.setBounds(148, 80, 90, 20);
		contentPane.add(textField_contrasenia);
		textField_contrasenia.setColumns(10);
		
		
		// BOTON ATRAS
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		btnAtras.setBounds(10, 145, 89, 23);
		contentPane.add(btnAtras);
		
		
		// BOTON GUARDAR 
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Control(textField_nombre, textField_contrasenia)){
				
				String nombre = textField_nombre.getText();
				String contrasenia = textField_contrasenia.getText();
			
				Cuenta a = new Cuenta(nombre,contrasenia);
				
				try {
					
					Principal.Principal.Archi.GuardarCuenta(a);
					
					JOptionPane.showMessageDialog(null, " La cuenta se creo correctamente ");
					
				}catch(Exception e) {

					JOptionPane.showMessageDialog(null, " No se pudo guardar correctamente ");
					
				}
				
				dispose();
				
				}
			}
		});
		btnGuardar.setBounds(222, 145, 89, 23);
		contentPane.add(btnGuardar);
		
		JLabel lblMinCaracteres = new JLabel("(min. 4 caracteres)");
		lblMinCaracteres.setBounds(248, 26, 110, 17);
		contentPane.add(lblMinCaracteres);
		
		JLabel label = new JLabel("(min. 4 caracteres)");
		label.setBounds(248, 82, 110, 17);
		contentPane.add(label);
	}
	
	public boolean Control (JTextField nombre , JTextField contra) {
		
		if(nombre.getText().length() < 4 || contra.getText().length() < 4) {
			
			JOptionPane.showMessageDialog(null, "ERROR : Campo menor a 4 caracteres");
			
			return false;
			
		}else {
			
			return true;
			
		}
		
	}
	
}
