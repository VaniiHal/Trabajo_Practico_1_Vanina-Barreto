package ar.edu.unju.fi.ejercicio6.Main;

import java.util.Scanner;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio6.Model.Persona;

public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona();
		Scanner entrada = new Scanner(System.in);
				
		cargarDatos(persona,entrada); //primer paso
		cargarDatos2(entrada); //segundo paso tambien se puede traer el modulo a esta parte
		cargarDatos3(entrada); // tercer paso tambien se lo puede traer
		entrada.close();;
		
	}

	private static void cargarDatos3(Scanner entrada) {
		System.out.println("Ingrese dni:");
		long dni = entrada.nextLong();
		entrada.nextLine();
		
		System.out.println("Ingrese nombre: ");
		String nombre = entrada.next();
		entrada.nextLine();
		
		LocalDate fechaNac = ingresarFecha(entrada);
		
		Persona persona = new Persona(dni, nombre, fechaNac);
		System.out.println(persona);
		persona.mostrarDatos(fechaNac);
		
	}

	private static void cargarDatos2(Scanner entrada) {
		System.out.println("Ingrese dni:");
		long dni = entrada.nextLong();
		entrada.nextLine();
		
		System.out.println("Ingrese nombre: ");
		String nombre = entrada.next();
		entrada.nextLine();
		
		LocalDate fechaNac = ingresarFecha(entrada);
		
		System.out.println("Ingrese provincia:");
		String provincia = entrada.next();
		entrada.nextLine();
		
		Persona persona = new Persona(dni, nombre, fechaNac, provincia);
		System.out.println(persona);
		persona.mostrarDatos(fechaNac);
		
	}

	private static void cargarDatos(Persona persona, Scanner entrada) {
		System.out.println("Ingrese dni:");
		long dni = entrada.nextLong();
		entrada.nextLine();
		
		System.out.println("Ingrese nombre: ");
		String nombre = entrada.next();
		entrada.nextLine();
		
		LocalDate fechaNac = ingresarFecha(entrada);
		
		System.out.println("Ingrese provincia:");
		String provincia = entrada.next();
		
		persona.setDni(dni);
		persona.setFechaNac(fechaNac);
		persona.setNombre(nombre);
		persona.setProvincia(provincia);
		//persona.toString(); //POR ALGUNA RAZON EL TO STRING NO ME FUNCIONA BIEN
		System.out.println(persona); 
		persona.mostrarDatos(fechaNac);		
	}

	

	private static LocalDate ingresarFecha(Scanner entrada) {
		System.out.println("Ingrese su dia de nacimiento (formato dd)");
		int dia = entrada.nextInt();
		System.out.println("Ingrese su mes de nacimiento (formato mm)");
		int mes = entrada.nextInt();
		System.out.println("Ingrese su año de nacimiento (formato yyyy)");
		int anio = entrada.nextInt();
		entrada.nextLine();
		LocalDate fechaNac = LocalDate.of(anio, mes, dia);
			
		return fechaNac;
	}

}
