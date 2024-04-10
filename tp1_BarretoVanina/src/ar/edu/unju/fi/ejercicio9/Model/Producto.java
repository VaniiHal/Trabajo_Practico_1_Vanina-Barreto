package ar.edu.unju.fi.ejercicio9.Model;

public class Producto {
	private String nombre;
	private int codigo;
	private double precio;
	private int descuento;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "\nProducto: " + nombre + "\nCodigo: " + codigo + "\nPrecio: " + precio + "\nDescuento: " + descuento;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public double calcularDescuento() {
		return precio - (precio* descuento /100.0);
	}
}
