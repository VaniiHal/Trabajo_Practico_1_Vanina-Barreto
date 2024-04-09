package ar.edu.unju.fi.ejercicio7.Model;

import java.text.DecimalFormat;

public class Empleado {
	private String nombre;
	private int legajo;
	private double salario;
	private final double SALARIO_MINIMO = 210000.00;
	private final double MERITO = 20000.00;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	
	public Empleado(String nombre, int legajo, double salario) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
		if (salario >= SALARIO_MINIMO) {
			this.salario = salario;
		}
		else {
			this.salario = SALARIO_MINIMO;
		}
	}
	
	public void aumentarMerito() {
		salario += (salario>= SALARIO_MINIMO)? MERITO:0;
	}

	@Override
	public String toString() {//considero que contrui un metodo para que los datos e muestren correctamente
		DecimalFormat decimal = new DecimalFormat("#,##0.00");
		return "\n" + "Nombre del empleado: " + nombre + "\n" + "Legajo: " + legajo + "\n" + "Salario: $" + decimal.format(salario);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
