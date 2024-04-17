package ar.edu.unju.fi.ejercicio12.Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
	private String nombre;
	private LocalDate fechaNac;
	
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Nombre: " + nombre + "\nFecha de nacimiento: " + fechaNac.format(formato);
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
		LocalDate hoy =LocalDate.now();
		int edad = Period.between(fechaNac, hoy).getYears();
		return edad;
	}
	
	public String ObtenerSignoZodiacal() {
		String signo="";
		int dia=fechaNac.getDayOfMonth();
		int mes=fechaNac.getMonthValue();
		if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)){
			signo="Acuario";
		}
		else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
			signo="Piscis";
		}
		else if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
			signo="Aries";
		}
		else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
			signo="Tauro";
		}
		else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
			signo="Geminis";
		}
		else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
			signo="Cancer";
		}
		else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
			signo="Leo";
		}
		else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
			signo="Virgo";
		}
		else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
			signo="Libra";
		}
		else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
			signo="Escorpio";
		}
		else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
			signo="Sagitario";
		}
		else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
			signo="Capricornio";
		}
		return signo;
	}
	
	public String ObtenerEstacionAnual() {
		String estacion="";
		int dia=fechaNac.getDayOfMonth();
		int mes=fechaNac.getMonthValue();
		if ((mes == 12 && dia >= 21) || (mes >= 1 && mes <= 2) || (mes==3 && dia<=20)) {
			estacion="Verano";
		}
		else if((mes == 3 && dia >= 21) || (mes >= 4 && mes <= 5) || (mes==6 && dia<=20)) {
			estacion="Otoño";
		}
		else if((mes == 6 && dia >= 21) || (mes >= 7 && mes <= 8) || (mes==9 && dia<=20)) {
			estacion="Invierno";
		}
		else {
			estacion="Primavera";			
		}
		return estacion;
	}
}


