package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mxrck.autocompleter.TextAutoCompleter;
import Clases.Ingreso;
import Principal.Principal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class VMercaderia extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Ingreso;
	private JTextField textField_Nombre;
	private JTextField textField_Cantidad;
	

	public VMercaderia() {
	
		setTitle("Mercaderia");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 367, 258);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// BOTON ATRAS
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VIngresos ingreso = new VIngresos();
				
				ingreso.setVisible(true);
				
				dispose();
				
			}
		});
		btnAtras.setBounds(10, 174, 86, 25);
		contentPane.add(btnAtras);
		
		// LABEL INGRESO 
		
		JLabel lblIngreso = new JLabel("Ingreso : ");
		lblIngreso.setBounds(29, 105, 73, 18);
		contentPane.add(lblIngreso);
		
		textField_Ingreso = new JTextField();
		textField_Ingreso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {

				char a = ke.getKeyChar();
				
				if((a<'0' || a>'9') || (textField_Ingreso.getText().length() > 8)) {
					
					ke.consume();
				}
				
			}
		});
		textField_Ingreso.setBounds(92, 104, 48, 20);
		contentPane.add(textField_Ingreso);
		textField_Ingreso.setColumns(10);
		
		// LABEL NOMBRE 
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(29, 24, 73, 14);
		contentPane.add(lblNombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				
				if(textField_Nombre.getText().length() == 40) {
					
					ke.consume();
				}
				
				
			}
		});
		textField_Nombre.setBounds(92, 21, 97, 20);
		contentPane.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		// LABEL CANTIDAD 
		
		JLabel lblCantidad = new JLabel("Cantidad : ");
		lblCantidad.setBounds(29, 66, 61, 14);
		contentPane.add(lblCantidad);
		
		textField_Cantidad = new JTextField();
		textField_Cantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {

				char a = ke.getKeyChar();

				if((a<'0' || a>'9') || (textField_Cantidad.getText().length() == 8)) {
					
					ke.consume();
				
				}

			}
		});
		textField_Cantidad.setBounds(92, 63, 30, 20);
		contentPane.add(textField_Cantidad);
		textField_Cantidad.setColumns(10);
		
		// AUTOCOMPLETER 
		ArrayList Lista = Principal.Archi.LeerArreglo();
		
		TextAutoCompleter AutoComp = new TextAutoCompleter(textField_Nombre,Lista);

		// GUARDA EL INGRESO CARGADO 
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_Nombre.getText().length()==0 || textField_Ingreso.getText().isEmpty() || textField_Cantidad.getText().isEmpty() ) {
					
					JOptionPane.showMessageDialog(null, "Hay un campo vacio");
					
				} else { 
					
				Guardar(textField_Ingreso,textField_Cantidad,textField_Nombre);
				
				VIngresos ingre = new VIngresos();
				
				ingre.setVisible(true);
				
				dispose();
				
				}
			}
		});
		
		btnGuardar.setBounds(259, 175, 82, 23);
		contentPane.add(btnGuardar);
		
		
		// BOTON GUARDAR AUTOCOMPLETER
		
		JButton btnCargar = new JButton("Guardar Palabra");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_Nombre.getText().length()!=0){
					
					VPregunta ventana = new VPregunta(textField_Nombre);
					
					ventana.setVisible(true);
					
					}else{
						
						JOptionPane.showMessageDialog(null, "Campo vacio");
						
					}
				
			}
		});
		btnCargar.setBounds(211, 20, 130, 23);
		contentPane.add(btnCargar);

		JButton btnGuardarYAgregar = new JButton("Guardar y agregar");
		btnGuardarYAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Guardar(textField_Ingreso,textField_Cantidad,textField_Nombre);
				
				VMercaderia ingre = new VMercaderia();
				
				ingre.setVisible(true);
				
				dispose();
				
				
			}
		});
		btnGuardarYAgregar.setBounds(198, 141, 143, 23);
		contentPane.add(btnGuardarYAgregar);
		

	}
	
	public void Guardar(JTextField ing,JTextField cant,JTextField nom) {
		
		int ingreso =   Integer.parseInt(ing.getText() );
		
		int cantidad = Integer.parseInt(cant.getText());
		
		String nombre =  nom.getText();
		
		Ingreso ingres = new Ingreso( ingreso , nombre , Principal.year, cantidad);
		
		ingres.setMO(false);
		
		Principal.CargaIngresoDelDia(ingres);

		Principal.Archi.GuardarAnio(Principal.year);	
		
	}
	
	public void ControlCampos (JTextField ing,JTextField cant,JTextField nom) {
		
		
		if(nom.getText().isEmpty() ||ing.getText().isEmpty() || cant.getText().isEmpty() ) {
			
			JOptionPane.showMessageDialog(null, "Hay un campo vacio");
		
		}

	}
	
}
