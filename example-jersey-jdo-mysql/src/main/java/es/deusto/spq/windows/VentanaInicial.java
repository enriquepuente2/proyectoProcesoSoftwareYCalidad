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

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class VentanaInicial extends JFrame {
	public static String dni;
	public static String dniA;
	private static Logger logger = Logger.getLogger("VentanaInicial");
	public VentanaInicial() {
		
		setBounds(250, 225, 1000, 508);
		setResizable(false);
		
		getContentPane().setFont(new Font("Sitka Small", Font.PLAIN, 10));
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(new Color(100, 149, 237));
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 1, 0, 0));
		

		/*JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelCentro.add(panel);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("imagenes/ikea.gif"));
		panel.add(imagen);*/
		/**
		 * DESCOMENTAR JPANEL 
		 */
		JPanel panel = new PanelConFondo((new ImageIcon("imagenes/ikea.gif").getImage()));
		panelCentro.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panelCentro.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(100, 149, 237));
		panel_1.add(panel_3);
		
		JButton btnsignup = new JButton("SIGN UP");
		panel_3.add(btnsignup);
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnsignup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegis v1 = new VentanaRegis();
				logger.log(Level.INFO, "Estamos registrandonos");
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(100, 149, 237));
		panel_1.add(panel_4);
		
		JButton btnlogin = new JButton("LOG IN");
		panel_4.add(btnlogin);
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion v1 = new VentanaInicioSesion();
				logger.log(Level.INFO, "Estamos logeandonos");
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(100, 149, 237));
		panel_1.add(panel_5);
		
		JButton btnMenuPrincipal = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_5.add(btnMenuPrincipal);
		
		btnMenuPrincipal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(VentanaInicioSesion.dni == null && !VentanaInicioSesion.getAdmin()) {
					VentanaInicioSesion.dni = VentanaInicial.dni;
					/**
					 * DESCOMENTAR VENTANA PRINCIOPAL
					 */
					//VentanaPrincipal v1 = new VentanaPrincipal();
					System.out.println("Usuario");
					logger.log(Level.INFO, "accediendo al menu");
					
				}else if(VentanaInicioSesion.dniA == null) {
					VentanaInicioSesion.dniA = VentanaInicial.dniA;
					System.out.println("ADMIN");
					logger.log(Level.INFO, "accediendo a ADMIN");
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO PULSA LO QUE DESEA REALIZAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel);
				
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
