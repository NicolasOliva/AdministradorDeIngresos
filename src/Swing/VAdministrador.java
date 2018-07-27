package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class VAdministrador extends JFrame {

	private JPanel contentPane;

	public VAdministrador() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(170, 200, 259, 356);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// MODIFICAR CUENTA
		
		JButton btnModificarCuenta = new JButton("Modificar Cuenta");
		btnModificarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VCuentaCrear CC = new VCuentaCrear();
				
				CC.setVisible(true);
				
			}
		});
		btnModificarCuenta.setBounds(40, 143, 130, 43);
		contentPane.add(btnModificarCuenta);
		
		
		// ATRAS 
		
		JButton btnAtras_1 = new JButton("Atras");
		btnAtras_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VMenuPrincipal VM = new VMenuPrincipal();
				
				VM.setVisible(true);
				
				dispose();
				
			}
		});
		btnAtras_1.setBounds(144, 284, 89, 23);
		contentPane.add(btnAtras_1);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VHistorial VH = new VHistorial();
				
				VH.setVisible(true);
				
			}
		});
		btnHistorial.setBounds(40, 54, 130, 43);
		contentPane.add(btnHistorial);
	}
}
