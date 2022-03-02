package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import models.Farmaceutico;
import utils.Almacen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class RegistroView {

	private JFrame frame;
	private JLabel lblTitulo;
	private JButton btnRegist;
	private JPasswordField pfPIN;
	private JLabel lblFondo;
	private JLabel lblPin;
	private Farmaceutico usuario;
	private JPasswordField pfPIN2;
	private JLabel lblPin2;
	private JButton btnVolver;
	private JFrame loginView;

	/**
	 * Crea la aplicación
	 */
	public RegistroView(JFrame login) {
		this.loginView = login;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Inicializa el contenido del Frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
	}
	
	/**
	 * Configura el diseño del Frame
	 */
	private void setUIComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Farmacia");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		lblTitulo.setBounds(0, 31, 452, 78);
		frame.getContentPane().add(lblTitulo);
		
		btnRegist = new JButton("Registrarse");

		btnRegist.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnRegist.setBackground(Color.WHITE);
		btnRegist.setBounds(150, 223, 150, 40);
		frame.getContentPane().add(btnRegist);
		
		pfPIN = new JPasswordField();
		pfPIN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pfPIN.setHorizontalAlignment(SwingConstants.CENTER);
		pfPIN.setBounds(57, 152, 150, 40);
		frame.getContentPane().add(pfPIN);
				
		lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblPin.setBounds(57, 125, 150, 30);
		frame.getContentPane().add(lblPin);

		pfPIN2 = new JPasswordField();
		pfPIN2.setHorizontalAlignment(SwingConstants.CENTER);
		pfPIN2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pfPIN2.setBounds(246, 152, 150, 40);
		frame.getContentPane().add(pfPIN2);

		lblPin2 = new JLabel("CONFIRMA PIN:");
		lblPin2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblPin2.setBounds(246, 125, 150, 30);
		frame.getContentPane().add(lblPin2);	

		btnVolver = new JButton("Volver");

		btnVolver.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(10, 11, 80, 25);
		frame.getContentPane().add(btnVolver);	
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 452, 417);
		frame.getContentPane().add(lblFondo);
		lblFondo.setIcon(new ImageIcon(LoginView.class.getResource("/img/fondologin.png")));
	}
	
	/**
	 * Configura las acciones de botones y de más
	 */
	private void setListeners() {
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				devuelveLogin();
			}
		});
		
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String pin1 = new String(pfPIN.getPassword());
			String pin2 = new String(pfPIN2.getPassword());
			if(registroValido(pin1, pin2)) {
				JOptionPane.showMessageDialog(btnRegist, "Usuario registrado con éxito");
				Almacen.usuarios.add(new Farmaceutico(Almacen.usuarios.size(), pin1));
				devuelveLogin();
			}
			}
		});
	}
	
	// ~~~ MÉTODOS
	public boolean igualdadClaves(String pin1, String pin2) {
		if(pin1.equals(pin2))
			return true;
		return false;
		
	}
	
	public boolean hayVacios(String pin1, String pin2) {
		if(pin1.isEmpty() || pin2.isEmpty()) 
			return true;
		return false;
	}
	
	public boolean registroValido(String pin1, String pin2) {
		if(!hayVacios(pin1, pin2)) {
			if(igualdadClaves(pin1, pin2)) {
				return true;
			} else {
				JOptionPane.showMessageDialog(btnRegist, "Asegurate de que los PINs coincidan");
			}
		} else {
			JOptionPane.showMessageDialog(btnRegist, "Asegurate de rellenar todos los campos");
		}
		return false;
	}
	
	public void devuelveLogin() {
		frame.dispose();
		loginView.setVisible(true);
	}
	
} //CIERRE CLASE
