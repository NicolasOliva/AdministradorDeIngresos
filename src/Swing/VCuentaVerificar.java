package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Cuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VCuentaVerificar extends JFrame {

	private JPanel contentPane;
	private JTextField textField_cuenta;
	private JPasswordField textField_contra;
	
	public VCuentaVerificar(JFrame ventana) {
		
		setTitle("Verificar Cuenta");
		getContentPane().setLayout(null);
		setBounds(400, 220, 285, 248);
		
		JLabel lblIngreseCuenta = new JLabel("Ingrese Cuenta : ");
		lblIngreseCuenta.setBounds(33, 32, 105, 22);
		lblIngreseCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblIngreseCuenta);
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(33, 82, 60, 22);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(33, 115, 78, 22);
		getContentPane().add(lblContrasea);
		
		textField_cuenta = new JTextField();
		textField_cuenta.setBounds(94, 83, 105, 20);
		getContentPane().add(textField_cuenta);
		textField_cuenta.setColumns(10);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(22, 172, 89, 23);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre = textField_cuenta.getText();
				String contrasenia = textField_contra.getText();

				if(Verificar(nombre,contrasenia) ){
					
					ventana.setVisible(true);
					
					dispose();
					
				}else{
					
					JOptionPane.showMessageDialog(null, " Los datos ingresados son incorrectos ");
					
				}
				
			}
		});
		getContentPane().add(btnContinuar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(164, 172, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VMenuPrincipal VM = new VMenuPrincipal();
				
				VM.setVisible(true);		
				
				dispose();		
				
			}
		});
		getContentPane().add(btnAtras);
		
		textField_contra = new JPasswordField();
		textField_contra.setBounds(110, 116, 95, 20);
		getContentPane().add(textField_contra);
	
	}
	
	public static boolean Verificar (String nombre, String contra) {
		
		Cuenta cuenta = Principal.Principal.Archi.LeerCuenta();
		
		if(nombre.equals(cuenta.getNombre()) && contra.equals(cuenta.getContrasenia())){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
	}
}
