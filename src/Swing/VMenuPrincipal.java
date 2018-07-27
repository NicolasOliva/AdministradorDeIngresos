package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class VMenuPrincipal extends JFrame {

	private JPanel contentPane;

	public VMenuPrincipal() {
		
		setTitle("Menu");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(170, 200, 337, 356);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// BOTON INGRESO 
		
		JButton btnIngreso = new JButton("Ingresos");
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VIngresos ingresos = new VIngresos ();
				
				ingresos.setVisible(true);
				
			}
		});
		btnIngreso.setBounds(32, 58, 136, 33);
		contentPane.add(btnIngreso);
		
		
		// BOTON CERRAR 
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnNewButton.setBounds(232, 280, 79, 23);
		contentPane.add(btnNewButton);
		
		
		// BOTON AUTOCOMPLETADO
		
		JButton btnListaautocompletado = new JButton("Lista Auto Completado");
		btnListaautocompletado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VAutoCompleter VAC = new VAutoCompleter(); 
				
				VAC.setVisible(true); 
				
			}
		});
		btnListaautocompletado.setBounds(32, 192, 165, 33);
		contentPane.add(btnListaautocompletado);
		
		
		// BOTON ADMINISTRADOR
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VAdministrador VA = new VAdministrador(); 
				
				VCuentaVerificar control = new VCuentaVerificar(VA);
				
				control.setVisible(true);
				
				dispose();
				
			}
		});
		btnAdministrador.setBounds(32, 123, 136, 33);
		contentPane.add(btnAdministrador);
	
	}
}
