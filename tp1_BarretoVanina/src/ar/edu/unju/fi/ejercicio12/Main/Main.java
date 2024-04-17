package ar.edu.unju.fi.ejercicio12.Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio12.Model.Persona;

public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona();
		Scanner entrada = new Scanner(System.in);
		LocalDate fechaNac =null;
		System.out.print("Ingrese nombre: ");
		String nombre = entrada.nextLine();
		while (fechaNac == null) {
			System.out.print("Ingrese fecha de Nacimiento (Formato dd/mm/yyyy): ");
			String fecha = entrada.nextLine();
			try {
				DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy"); //como se hace en el caso de que la fecha sea ilogica? 30 de febrero 
				fechaNac = LocalDate.parse(fecha,formato);
			}catch(DateTimeParseException e) {
				System.out.println("\nError en el ingreso de la fecha de nacimeinto. Intentalo de nuevo\n");
			}
		}
		
		persona.setFechaNac(fechaNac);
		persona.setNombre(nombre);
		int edad =persona.calcularEdad();
		String signo = persona.ObtenerSignoZodiacal();
		String estacion = persona.ObtenerEstacionAnual();
		System.out.println("\n" + persona + "\nEdad: " + edad + " años\nSigno del zodiaco: "  + signo + "\nEstación: " + estacion);
		entrada.close();
	}

}
