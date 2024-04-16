package ar.edu.unju.fi.ejercicio12.Model;

import java.time.LocalDate;

public class Persona {
	private String nombre;
	private LocalDate fechaNac;
	
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNac=" + fechaNac + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public int calcularEdad()
	{
		return 0;
	}
	
	public String SignoZodiacal() {
		String signo="HOLA"; //sacar iniciliazacion
		return signo;
	}
	
	public String EstacionAnual() {
		String estacion="HOLA";//sacar iniciliazacion
		return estacion;
	}
}


