package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Principal.Principal;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VPregunta extends JFrame {

	private JPanel contentPane;

	public VPregunta(JTextField nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 240, 269, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeseaGuardarLa = new JLabel("Desea guardar la palabra ? ");
		lblDeseaGuardarLa.setBounds(55, 36, 167, 23);
		contentPane.add(lblDeseaGuardarLa);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnAtras.setBounds(10, 94, 82, 23);
		contentPane.add(btnAtras);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList Lista = Principal.Archi.LeerArreglo();
				
				Lista.add(nombre.getText());
				
				Principal.Archi.GuardarArreglo(Lista);
				
				dispose();
				
			}
		});
		btnGuardar.setBounds(161, 94, 82, 23);
		contentPane.add(btnGuardar);
	}
}
