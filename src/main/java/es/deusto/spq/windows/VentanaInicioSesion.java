package es.deusto.spq.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.border.LineBorder;

import es.deusto.spq.server.BaseDatos;
import es.deusto.spq.server.Producto;
import es.deusto.spq.server.Usuario;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class VentanaInicioSesion extends JFrame {
	private JTextField txtDni;
	private JPasswordField txtContr;
	public static String dni;
	public static String dniA;
	private Connection connection;
	public static  ArrayList<Producto> carrito ;
	public static HashMap<String, ArrayList<Producto>> mapa;
	private static boolean admin = false;
	public VentanaInicioSesion() {
		carrito = new ArrayList<>();
		/**
		 * PROBLEMA. Duda = ¿Cómo establecemos la conexión con la BBDD?
		 */
		Connection con = BaseDatos.initBD("data/DeustoIkea.db");
		
		mapa = new HashMap<>();
		
		/**
		 * PROBLEMA. Duda = ¿Cómo creamos la conexión con la BBDD?
		 */
		BaseDatos.crearTablasUsuario(con);
		setBounds(250, 225, 1000, 508);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(new Color(255, 255, 255));//
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelNorte.add(lblNewLabel);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("LOG IN");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniA = txtDni.getText();
				String erDniA = "[A][D][M][I][N]";
				String contraseniaA = txtContr.getText();
				String erContrA = "[A][D][M][I][N]";
				
				String dni = txtDni.getText();
				String erDni = "[0-9]{3}[A-Z]";
				String contrasenia = txtContr.getText();
				String erContr = "[0-9]{3}";
				
				if(Pattern.matches(erDniA, dniA) && Pattern.matches(erContrA, contraseniaA)) {
					 /**
					  * PROBLEMA. Duda = ¿Cómo establecemos la conexión con la BBDD?
					  */
					 BaseDatos.obtenerAdmin(con, dniA);
					 JOptionPane.showMessageDialog(null, "Bienvenido ADMIN", "SESIÓN INICIADA", JOptionPane.DEFAULT_OPTION);
					 VentanaInicial.dniA = dniA;
					 admin = true;
					 dispose();
				}else if(Pattern.matches(erDni, dni) && Pattern.matches(erContr, contrasenia)) {
					Usuario u = new Usuario();
					/**
					 * PROBLEMA. Duda = ¿Cómo establecemos la conexión con la BBDD?
					 */
					u = BaseDatos.obtenerUsuario(con, dni);
					if(u != null) {
						if(u.getContrasenia().equals(contrasenia)) {
							JOptionPane.showMessageDialog(null, "Bienvenido", "SESIÓN INICIADA", JOptionPane.DEFAULT_OPTION);
							//VentanaInicioSesion.dni = dni;
							VentanaInicial.dni = dni;
							/**
							 * DESCOMENTAR LA VENTANA PRINCIPAL
							 */
							//VentanaPrincipal.dni = dni;
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "La contraseña es erronea!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "No existe un usuario para ese DNI! \n Vuelve a introducirlo ó deberas de registrar! ", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Los datos no cumplen los requisitos", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					
				}
				txtDni.setText("");
				txtContr.setText("");
				
			}
		});
		
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelSur.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/**
				 * PROBLEMA. Duda = ¿Cómo establecemos la conexión con la BBDD?
				 */
				BaseDatos.closeBD(connection);
			}
			
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelSur.add(btnNewButton);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(100, 149, 237));
		panelCentro.setForeground(new Color(255, 220, 220));
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panelCentro.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/login.png"));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(100, 149, 237));
		panelCentro.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel_3.add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_1.setBackground(new Color(100, 149, 237));
		panel_3.add(panel_1);
		
		JLabel labelDni = new JLabel("Dni:            ");
		panel_1.add(labelDni);
		labelDni.setBackground(new Color(255, 255, 255));
		
		txtDni = new JTextField();
		panel_1.add(txtDni);
		txtDni.setColumns(10);
		
		JPanel panel_4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel_4.setBackground(new Color(100, 149, 237));
		panel_3.add(panel_4);
		
		JLabel labelContr = new JLabel("Contraseña:");
		panel_4.add(labelContr);
		
		txtContr = new JPasswordField();
		panel_4.add(txtContr);
		txtContr.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(100, 149, 237));
		panel_3.add(panel_5);
		
		setVisible(true);
		/**
		 * PROBLEMA. Duda = ¿Cómo establecemos la conexión con la BBDD?
		 */
		connection= BaseDatos.initBD("data/DeustoIkea");
		BaseDatos.crearTablasUsuario(connection);
		BaseDatos.crearTablasProducto(connection);
		BaseDatos.crearTablasCarrito(connection);
		BaseDatos.insertarUsuario(connection, "Admin","111A","admin@gmail.com","casa", "Aa00Za", 1 );
		

	}
	public static boolean getAdmin() {
		return admin;
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion frame = new VentanaInicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
