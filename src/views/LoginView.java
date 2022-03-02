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

public class LoginView {

	private JFrame frame;
	private JLabel lblTitulo;
	private JButton btnLogin;
	private JPasswordField pfPIN;
	private JLabel lblFondo;
	private JLabel lblPin;
	private Farmaceutico usuario;
	private JButton btnRegistro;


	/**
	 * Crea la aplicación
	 */
	public LoginView() {
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
		
		btnLogin = new JButton("Entrar");
		btnLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(50, 225, 150, 40);
		frame.getContentPane().add(btnLogin);
		
		pfPIN = new JPasswordField();
		pfPIN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pfPIN.setHorizontalAlignment(SwingConstants.CENTER);
		pfPIN.setBounds(150, 151, 150, 40);
		frame.getContentPane().add(pfPIN);
				
		lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblPin.setBounds(150, 123, 152, 30);
		frame.getContentPane().add(lblPin);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnRegistro.setBackground(Color.WHITE);
		btnRegistro.setBounds(255, 225, 150, 40);
		frame.getContentPane().add(btnRegistro);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 452, 417);
		frame.getContentPane().add(lblFondo);
		lblFondo.setIcon(new ImageIcon(LoginView.class.getResource("/img/fondologin.png")));
		
	}
	
	/**
	 * Configura las acciones de botones y de más
	 */
	private void setListeners() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analizarPinAcceso(new String(pfPIN.getPassword()));
			}
		});
		
		pfPIN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 analizarPinAcceso(new String(pfPIN.getPassword()));
				}
		});
		
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new RegistroView(frame);
			}
		});
	}
	
	/**
	 * Verifica los datos introducidos para acceder a la farmacia
	 */
	private boolean analizarPinAcceso(String pin) {
		for(int i = 0; i < Almacen.usuarios.size(); i++) {
			if(pin.equals(Almacen.usuarios.get(i).getPin())) {
				JOptionPane.showMessageDialog(btnLogin, "Login Correcto. Bienvenid@");
				new FarmaciaView(frame, 0);
				frame.setVisible(false);
				return true;
			}
		}
		JOptionPane.showMessageDialog(btnLogin, "                       ERR0R 203 - PIN Invalido\nAsegurate de haber introducido el PIN correctamente");
		return false;
	}
	
} //CIERRE CLASE
