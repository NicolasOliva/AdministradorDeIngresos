package Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.Principal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class VNuevoAutoCompleter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public VNuevoAutoCompleter() {
		setTitle("Nuevo AutoText ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(435, 200, 253, 192);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(20, 47, 63, 15);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(78, 44, 106, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList Lista = Principal.Archi.LeerArreglo();
				
				Lista.add(textField.getText());
				
				Principal.Archi.GuardarArreglo(Lista);
				
				VAutoCompleter ventana = new VAutoCompleter();
				
				ventana.setVisible(true);
				
				dispose();
				
			}
		});
		btnCargar.setBounds(20, 109, 73, 23);
		contentPane.add(btnCargar);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VAutoCompleter VA = new VAutoCompleter();
				
				VA.setVisible(true);
				
				dispose();
			
			}
		});
		btnNewButton.setBounds(154, 109, 73, 23);
		contentPane.add(btnNewButton);
	}
}
