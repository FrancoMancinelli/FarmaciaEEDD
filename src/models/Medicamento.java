package models;

public class Medicamento {
	
	//Atributos
	private int id;
	private String nombre;
	private String tipo;
	private int cantidad;
	private double precio;
	
	//Constructores
	/**
	 * Construye un medicamento
	 * @param id Numero de identificación del medicamento
	 * @param nombre Nombre del medicamento
	 * @param tipo El tipo de medicamento
	 * @param cantidad La cantidad en stock del medicamento
	 * @param precio El precio del medicamento
	 */
	public Medicamento(int id, String nombre, String tipo, int cantidad, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

}
