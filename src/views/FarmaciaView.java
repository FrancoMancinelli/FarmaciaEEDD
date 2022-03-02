package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import models.Medicamento;
import utils.Almacen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FarmaciaView {

	private JFrame frame;
	private JTextField tfNombreMed;
	private JTextField tfTipo;
	private JTextField tfPrecio;
	private JTextField tfCantidad;
	private JButton btnPedido;
	private JButton btnVenta;
	private JButton btnActualizar;
	private JButton btnVentaDia;
	private JButton btnSalir;
	private JButton btnSiguiente;
	private JButton btnAnterior;
	private int pagina;
	private JFrame frameLogin;
	private JButton btnGuardarAct;
	private JButton btnCancelarAct;
	private JTextField tfPedidoCant;
	private JButton btnConfirPedido;
	private int modo;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblTipo;
	private JLabel lblCantidad;
	private JLabel lblTextIndica;
	private JLabel lblFondo;
	private int ventas;
	private Medicamento medicamento;

	/**
	 * Crea la aplicación.
	 */
	public FarmaciaView(JFrame loginView, int pagina) {
		this.frameLogin = loginView;
		this.pagina = pagina;
		this.medicamento = Almacen.medicamentos.get(pagina);
		initialize();
	}

	/**
	 * Inicializa el contenido del Frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
		setPanelBase();
		printPagina();
		frame.setVisible(true);
		
	}
	
	/**
	 * Configura el diseño del Frame
	 */
	private void setUIComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNombreMed = new JTextField();
		tfNombreMed.setFont(new Font("Arial", Font.PLAIN, 16));
		tfNombreMed.setBounds(96, 97, 150, 30);
		frame.getContentPane().add(tfNombreMed);
		tfNombreMed.setColumns(10);
		
		tfTipo = new JTextField();
		tfTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTipo.setBounds(96, 160, 150, 30);
		frame.getContentPane().add(tfTipo);
		tfTipo.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
		tfPrecio.setBounds(286, 97, 150, 30);
		frame.getContentPane().add(tfPrecio);
		tfPrecio.setColumns(10);
		
		tfCantidad = new JTextField();
		tfCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		tfCantidad.setBounds(286, 160, 150, 30);
		frame.getContentPane().add(tfCantidad);
		tfCantidad.setColumns(10);
		
		btnPedido = new JButton("Pedido");
		btnPedido.setBackground(Color.WHITE);
		btnPedido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnPedido.setBounds(55, 239, 130, 30);
		frame.getContentPane().add(btnPedido);
		
		btnVenta = new JButton("Venta");
		btnVenta.setBackground(Color.WHITE);
		btnVenta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnVenta.setBounds(203, 239, 130, 30);
		frame.getContentPane().add(btnVenta);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnActualizar.setBounds(350, 239, 130, 30);
		frame.getContentPane().add(btnActualizar);
		
		btnVentaDia = new JButton("Ventas del Dia");
		btnVentaDia.setBackground(Color.WHITE);
		btnVentaDia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnVentaDia.setBounds(186, 280, 160, 30);
		frame.getContentPane().add(btnVentaDia);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(10, 11, 65, 23);
		frame.getContentPane().add(btnSalir);
		
		btnAnterior = new JButton("<");
		btnAnterior.setBackground(Color.WHITE);
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAnterior.setBounds(10, 65, 45, 160);
		frame.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSiguiente.setBounds(490, 65, 45, 160);
		frame.getContentPane().add(btnSiguiente);
		
		btnGuardarAct = new JButton("Guardar");
		btnGuardarAct.setBackground(Color.WHITE);
		btnGuardarAct.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnGuardarAct.setBounds(286, 239, 110, 30);
		frame.getContentPane().add(btnGuardarAct);
		
		btnCancelarAct = new JButton("Cancelar");
		btnCancelarAct.setBackground(Color.WHITE);
		btnCancelarAct.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnCancelarAct.setBounds(136, 239, 110, 30);
		frame.getContentPane().add(btnCancelarAct);
		
		tfPedidoCant = new JTextField();
		tfPedidoCant.setFont(new Font("Verdana", Font.BOLD, 30));
		tfPedidoCant.setHorizontalAlignment(SwingConstants.CENTER);
		tfPedidoCant.setText("0");
		tfPedidoCant.setBounds(211, 110, 110, 70);
		frame.getContentPane().add(tfPedidoCant);
		tfPedidoCant.setColumns(10);
		
		btnConfirPedido = new JButton("Confirmar");
		btnConfirPedido.setBackground(Color.WHITE);
		btnConfirPedido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnConfirPedido.setBounds(286, 239, 110, 30);
		frame.getContentPane().add(btnConfirPedido);
		
		lblTitulo = new JLabel("Almacen - Farmacia");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblTitulo.setBounds(0, 15, 534, 43);
		frame.getContentPane().add(lblTitulo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNombre.setBounds(96, 76, 110, 23);
		frame.getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblPrecio.setBounds(286, 76, 110, 23);
		frame.getContentPane().add(lblPrecio);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblTipo.setBounds(96, 138, 110, 23);
		frame.getContentPane().add(lblTipo);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblCantidad.setBounds(286, 138, 110, 23);
		frame.getContentPane().add(lblCantidad);
		
		lblTextIndica = new JLabel("Indica a continuaci\u00F3n la cantidad de productos");
		lblTextIndica.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTextIndica.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextIndica.setBounds(69, 201, 397, 17);
		frame.getContentPane().add(lblTextIndica);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 555, 321);
		frame.getContentPane().add(lblFondo);
		lblFondo.setIcon(new ImageIcon(FarmaciaView.class.getResource("/img/fondoalmacen.jpg")));

	}
	
	/**
	 * Configura las acciones de botones y de más
	 */
	private void setListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnSalir,
						"¿Estás seguro de que deseas salir?");
				if (confirmar == 0) { // Confirma salir
					frameLogin.setVisible(true);
					frame.dispose();
				}
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAnterior();
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printSiguiente();
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setActualizarON();
			}
		});
		
		
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = 1;
				setPedidoON();
			}
		});
		
		btnConfirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modo == 1) //Si el modo es 1 = La función es de Pedido
					confirmarPedido();
				if (modo == 2) {//Si el modo es 2 = La función es de Venta				
					confirmarVenta();
				}
			}
		});
		
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modo = 2;
				setPedidoON();
			}
		});
		
		btnVentaDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnVentaDia, "Cantidad ventas totales: "+ ventas);
			}
		});
		
		btnCancelarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelBase();
				printPagina();
			}
		});
		
		btnGuardarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comprobar = compruebaErroresActu(tfNombreMed.getText(), tfTipo.getText(), tfPrecio.getText());
				switch (comprobar) {
				case 0:
					JOptionPane.showMessageDialog(btnGuardarAct, "El Nombre del medicamento no puede estar vacio");
					break;
				case 1:
					JOptionPane.showMessageDialog(btnGuardarAct, "El Tipo del medicamento no puede estar vacio");
					break;
				case 2:
					JOptionPane.showMessageDialog(btnGuardarAct, "El Precio del medicamento no puede estar vacio");
					break;
				case 3:
					JOptionPane.showMessageDialog(btnGuardarAct, "El Precio del medicamento no puede ser 0 o negativo");
					break;
				case -1:
					guardarCambios();
					break;
				}
				
			}
		});
	}
	
	
	
	/**
	 * Imprime los datos del medicamento de la pagina actual
	 */
	private void printPagina() {
		this.medicamento = Almacen.medicamentos.get(pagina);
		if(Almacen.medicamentos.size() > 0) {
			tfNombreMed.setText(medicamento.getNombre());
			tfTipo.setText(medicamento.getTipo());
			tfPrecio.setText(String.valueOf(medicamento.getPrecio()));
			tfCantidad.setText(String.valueOf(medicamento.getCantidad()));
			this.medicamento = Almacen.medicamentos.get(pagina);
			if(!hayStock(medicamento.getCantidad())) {
				btnVenta.setEnabled(false);
			} else {
				btnVenta.setEnabled(true);
			}
		}
	}
	
	/**
	 * Imprime el siguiente formulario de manera circular
	 */
	private void printSiguiente() {
		pagina++;
		if(pagina == Almacen.medicamentos.size()) {
			pagina = 0;
		}
		printPagina();
	}
	
	/**
	 *Imprime el anterior formulario de manera circular
	 */
	private void printAnterior() {
		pagina--;
		if(pagina < 0) {
			pagina = Almacen.medicamentos.size() - 1;
		}
		printPagina();
	}
	
	/**
	 * Configura el diseño e interfaz del panel en modo Actualizar
	 */
	private void setActualizarON() {
		tfNombreMed.setEditable(true);
		tfTipo.setEditable(true);
		tfPrecio.setEditable(true);
		btnSiguiente.setVisible(false);
		btnAnterior.setVisible(false);
		btnActualizar.setVisible(false);
		btnPedido.setVisible(false);
		btnVenta.setVisible(false);
		btnVentaDia.setVisible(false);
		btnCancelarAct.setVisible(true);
		btnGuardarAct.setVisible(true);
		btnSalir.setVisible(false);		
	}
	
	/**
	 * Configura la UI al estado Base de inicio
	 */
	private void setPanelBase() {
		tfNombreMed.setEditable(false);
		tfTipo.setEditable(false);
		tfTipo.setVisible(true);
		tfPrecio.setEditable(false);
		tfCantidad.setEditable(false);
		btnSiguiente.setVisible(true);
		btnAnterior.setVisible(true);
		btnActualizar.setVisible(true);
		btnPedido.setVisible(true);
		btnVenta.setVisible(true);
		btnVentaDia.setVisible(true);
		btnCancelarAct.setVisible(false);
		btnGuardarAct.setVisible(false);
		btnSalir.setVisible(true);
		tfPedidoCant.setVisible(false);
		btnConfirPedido.setVisible(false);
		tfNombreMed.setVisible(true);
		tfTipo.setVisible(true);
		tfPrecio.setVisible(true);
		tfCantidad.setVisible(true);
		lblNombre.setVisible(true);
		lblPrecio.setVisible(true);
		lblTipo.setVisible(true);
		lblCantidad.setVisible(true);
		lblTextIndica.setVisible(false);
	}
	
	/**
	 * Guarda los cambios realizados en los TextFields y devuelve a la vista principal
	 */
	private void guardarCambios() {
		medicamento.setNombre(tfNombreMed.getText());
		medicamento.setTipo(String.valueOf(tfTipo.getText()));
		medicamento.setPrecio(Double.parseDouble(tfPrecio.getText()));
		medicamento.setCantidad(Integer.parseInt(tfCantidad.getText()));
		setPanelBase();
		printPagina();
	}
	
	/**
	 * Configura el diseño e interfaz del panel en modo Pedido
	 */
	private void setPedidoON() {
		tfPedidoCant.setText("0");
		tfNombreMed.setVisible(false);
		tfTipo.setVisible(false);
		tfPrecio.setVisible(false);
		tfCantidad.setVisible(false);
		btnSiguiente.setVisible(false);
		btnAnterior.setVisible(false);
		btnActualizar.setVisible(false);
		btnPedido.setVisible(false);
		btnVenta.setVisible(false);
		btnVentaDia.setVisible(false);
		btnCancelarAct.setVisible(true);
		btnGuardarAct.setVisible(false);
		btnSalir.setVisible(false);
		tfPedidoCant.setVisible(true);
		btnConfirPedido.setVisible(true);
		lblNombre.setVisible(false);
		lblPrecio.setVisible(false);
		lblTipo.setVisible(false);
		lblCantidad.setVisible(false);
		lblTextIndica.setVisible(true);
	}
	
	/**
	 * Modifica la cantidad de Stock sumando la cantidad pedida,
	 * reimprime el valor actual y devuelve a la vista principal
	 */
	private void confirmarPedido() {
		int comprueba = compruebaErroresPedido(tfPedidoCant.getText());
		
		switch (comprueba) {
		case 0:
			JOptionPane.showMessageDialog(btnConfirPedido, "Asegurate de rellenar todos los campos");
			break;
		case 1:
			JOptionPane.showMessageDialog(btnConfirPedido, "El pedido no puede ser 0 o negativo");
			break;
		case -1:
			int confirmar = JOptionPane.showConfirmDialog(btnGuardarAct,
					"¿Estás seguro de que deseas confirmar el pedido?");
			if (confirmar == 0) { // Confirma el pedido
				JOptionPane.showMessageDialog(btnConfirPedido, "El pedido ha sido realizado con éxito y ya ha sido entregado");
				medicamento.setCantidad(ingresaPedido(Integer.parseInt(tfPedidoCant.getText())));
				tfCantidad.setText(String.valueOf(ingresaPedido(Integer.parseInt(tfPedidoCant.getText()))));
				setPanelBase();
				printPagina();
			}
			break;
		}		
	}
	
	/**
	 * Modifica la cantidad de Stock restando la cantidad vendida,
	 * reimprime el valor actual y devuelve a la vista principal
	 */
	private void confirmarVenta() {
		int comprueba = compruebaErroresVenta(tfPedidoCant.getText());
		
		switch (comprueba) {
		case 0:
			JOptionPane.showMessageDialog(btnConfirPedido, "Asegurate de rellenar todos los campos");
			break;
		case 1:
			JOptionPane.showMessageDialog(btnConfirPedido, "La venta no puede ser 0 o negativo");
			break;
		case 2:
			JOptionPane.showMessageDialog(btnConfirPedido, "La venta es superior a la cantidad en stock");
			break;
		case -1:
			int confirmar = JOptionPane.showConfirmDialog(btnGuardarAct,
					"¿Estás seguro de que deseas confirmar la venta?");
			if (confirmar == 0) { // Confirma la venta
				JOptionPane.showMessageDialog(btnConfirPedido, "La venta ha sido realizada con éxito");
				medicamento.setCantidad(realizaVenta(Integer.parseInt(tfPedidoCant.getText())));
				tfCantidad.setText(String.valueOf(realizaVenta(Integer.parseInt(tfPedidoCant.getText()))));
				setPanelBase();
				printPagina();
				ventas++;
			}
			break;
		}		
	}
	
	private int ingresaPedido(int cantidad) {
		int cantActual = medicamento.getCantidad();
		int cantPedida = cantidad;
		int cantTotal = cantActual + cantPedida;
		return cantTotal;	
	}
	
	private int realizaVenta(int cantidad) {
		int cantActual = medicamento.getCantidad();
		int cantVendida = cantidad;
		int cantTotal = cantActual - cantVendida;
		return cantTotal;	
	}
	
	private boolean hayStock(int cantidad) {
		if(cantidad == 0)
			return false;
		return true;
	}
	
	/**
	 * Método que comprueba si se cumplen los requisitos de actualización
	 * @param nombre Nombre del medicamento
	 * @param tipo Tipo del medicamento
	 * @param precio Precio del medicamento
	 * @return 0 Si el campo Nombre esta vacio | 1 Si el campo tipo esta vacio | 
	 * 2 Si el precio esta vacio | 3 Si el precio es menor o igual a 0 |
	 * -1 Si no hubo ningun error
	 */
	private int compruebaErroresActu(String nombre, String tipo, String precio) {
		if(nombre.isEmpty())
			return 0;
		if(tipo.isEmpty()) 
			return 1;
		if (precio.isEmpty()) 
			return 2;
		if (Double.parseDouble(precio) <= 0)
			return 3;
		return -1;
	}
	
	/**
	 * Método que comprueba si se cumplen los requisitos para realizar un pedido
	 * @param cantidad Cantidad de unidades a solicitar
	 * @return 0 Si la cantidad esta vacia | 1 Si la cantidad es 0 o negativo | -1 Si no hay errores
	 */
	private int compruebaErroresPedido(String cantidad) {
		if(cantidad.isEmpty())
			return 0;
		if(Integer.parseInt(cantidad) <= 0)
			return 1;
		return -1;
	}
	
	/**
	 * Método que comprueba si se cumplen los requisitos para realizar una venta
	 * @param cantidad Cantidad de unidades a vender
	 * @return 0 Si la cantidad esta vacia | 1 Si la cantidad es 0 o negativo |
	 * 2 Si se quiere vender más de lo que hay en stock | -1 Si no hay errores
	 */
	private int compruebaErroresVenta(String cantidad) {
		if(cantidad.isEmpty())
			return 0;
		if(Integer.parseInt(cantidad) <= 0)
			return 1;
		if(Integer.parseInt(cantidad) > medicamento.getCantidad())
			return 2;
		return -1;
	}
}
