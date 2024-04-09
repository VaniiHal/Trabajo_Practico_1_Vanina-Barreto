package ar.edu.unju.fi.ejercicio6.Model;

import java.time.LocalDate;

public class Persona {
	private long dni;
	private String nombre;
	private LocalDate fechaNac;
	private String provincia;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Persona(long dni, String nombre, LocalDate fechaNac, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.provincia = provincia;
	}
	
	public Persona(long dni, String nombre, LocalDate fechaNac) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.provincia = "Jujuy";
	}

	
	@Override
	public String toString() {
		int edad = calcularEdad(fechaNac);
		boolean mayor= verificarMayoria(edad);
		return "\n" + "Nombre: " + nombre + "\n" + "DNI: " + dni + "\n" + "Fecha de nacimiento: " + fechaNac + "\n" + "Edad: " + edad + "\n" + "Provincia: " + provincia + "\n" + (mayor == true ? "La persona es mayor de edad": "La persona no es mayor de edad") + "\n";
	}


	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int calcularEdad(LocalDate fechaNac) {
		
		LocalDate fecha = LocalDate.now();
		int edad= fecha.getYear() - fechaNac.getYear();
		if (fechaNac.getMonthValue() > fecha.getMonthValue() || (fechaNac.getMonthValue() == fecha.getMonthValue() && fechaNac.getDayOfMonth() > fecha.getDayOfMonth())) {
			edad--;
		}
			
		return edad;
	}
	
	public boolean verificarMayoria(int edad) {
		if (edad<18) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}
