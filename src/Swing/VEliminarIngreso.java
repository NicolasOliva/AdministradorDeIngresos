package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Dia;
import Clases.Ingreso;
import Clases.Mes;
import Principal.Principal;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class VEliminarIngreso extends JFrame {

	private JPanel contentPane;


	public VEliminarIngreso(HashMap<Integer, Ingreso> Lista, Ingreso i) {
		
		setTitle("Eliminar Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 258);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(36, 35, 61, 14);
		contentPane.add(lblNombre);
		
		JLabel lbl_NombreIngreso = new JLabel(i.getNombre());
		lbl_NombreIngreso.setBounds(98, 35, 112, 14);
		contentPane.add(lbl_NombreIngreso);
		
		JLabel lblCantidad = new JLabel("Cantidad : ");
		lblCantidad.setBounds(36, 85, 61, 14);
		contentPane.add(lblCantidad);
		
		JLabel lbl_CantidadIngreso = new JLabel("" + i.getCantidad());
		lbl_CantidadIngreso.setBounds(98, 85, 112, 14);
		contentPane.add(lbl_CantidadIngreso);
		
		JLabel lblPrecio = new JLabel("Precio : ");
		lblPrecio.setBounds(36, 136, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel label_PrecioIngreso = new JLabel("" + i.getValor());
		label_PrecioIngreso.setBounds(84, 136, 112, 14);
		contentPane.add(label_PrecioIngreso);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DescontarIngreso(i);
					
				Dia d = Principal.year.UltimoDia();
				
				d.EliminarIngreso(Lista, i.getIdentificador());
				
				Principal.Archi.GuardarAnio(Principal.year);
				
				dispose();

				VIngresos V = new VIngresos();
				
				V.setVisible(true);
				
			}
		});
		btnConfirmar.setBounds(195, 186, 96, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VIngresos VI = new VIngresos(); 
				
				VI.setVisible(true);
				
				dispose();
				
			}
		});
		btnCancelar.setBounds(98, 186, 86, 23);
		contentPane.add(btnCancelar);
	}
	

	public void DescontarIngreso(Ingreso i) {
		
		Principal.year.DescontarIngreso(i);
		
		Principal.year.UltimoMes().DescontarIngreso(i);; 
		
		Principal.year.UltimoDia().DescontarDelTotal(i);
		
	}

	
}
