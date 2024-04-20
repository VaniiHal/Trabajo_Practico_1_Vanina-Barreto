package ar.edu.unju.fi.ejercicio18.Model;

public class Pais {
	private int codigo;
	private String nombre;
	
	public Pais() {
		// TODO Auto-generated constructor stub
	}
	
	public Pais(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Pais:" + nombre + "\tCodigo: " + codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
