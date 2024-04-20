package ar.edu.unju.fi.ejercicio17.Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio17.Model.Jugador;

public class Main {

	public static void main(String[] args) {
		int opcion=-1;
		Scanner entrada = new Scanner(System.in);
		List<Jugador> jugadores = new ArrayList<>(); 
		do {
			try {
				System.out.println("\n\t***MENU DE OPCIONES***");
				System.out.println("0- Alta de 5 jugadores automatica"); //agilizar la prueba
				System.out.println("1- Alta de jugador");
				System.out.println("2- Mostrar datos del jugador");
				System.out.println("3- Mostrar todos los jugadores");
				System.out.println("4- Modificar datos del jugador");
				System.out.println("5- Eliminar jugador");
				System.out.println("6- Mostrar cantidad total de jugadores");
				System.out.println("7- Mostrar cantidad de jugadores de una nacionalidad");
				System.out.println("8- Salir");
				System.out.print("Elija una opcion: ");
				opcion = entrada.nextInt();
				entrada.nextLine(); //se limpia el buffer
				switch (opcion) {
				case 0: precargarJugadores(jugadores); break;
				case 1: cargarJugador(jugadores,entrada); break;
				case 2: buscarJugador(jugadores,entrada); break;
				case 3: mostrarJugadores(jugadores); break;
				case 4: modificarJugador(jugadores,entrada); break;
				case 5: eliminarJugador(jugadores,entrada); break;
				case 6: mostrarCantidad(jugadores); break;
				case 7: mostrarNacionalidad(jugadores,entrada); break;
				case 8: System.out.println("\tADIOS *-*"); break;
				default: System.out.println("Opcion invalida");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
			}
		} while(opcion != 8);
		
		entrada.close();
	}
	//SE VERIFICA QUE PRIMERO HAYA JUGADORES
	private static void mostrarNacionalidad(List<Jugador> jugadores, Scanner entrada) {
		System.out.println("\n\t*** MOSTRAR CANTIDAD DE JUGADORES POR NACION ***");
		if(hayarJugadores(jugadores)==true) {
			System.out.print("\nIngrese nacionalidad: ");
			String nacion = entrada.nextLine();
			int cont=0;
			for (Jugador j : jugadores) {
				if(j.getNacionalidad().equalsIgnoreCase(nacion)) {
					cont=cont+1;
				}
			}
			if(cont==0) {
				System.out.println("No se han encontrado jugadores para la nacionalidad " + nacion);
			}
			else {
				System.out.println("Hay " + cont + " jugadores con nacionalidad " + nacion);
			}
		}
	}
	
	//SE VERIFICA QUE PRIMERO HAYA JUGADORES
	private static void mostrarCantidad(List<Jugador> jugadores) {
		System.out.println("\n\t*** CANTIDAD DE JUGADORES ***");
		int cantidad=jugadores.size();
		if(hayarJugadores(jugadores)==true) {
			System.out.println("\nLa cantidad total de jugadorres es: " + cantidad + "\n");
		}
	}

	//SE VERIFICA QUE PRIMERO HAYA JUGADORES
	private static void eliminarJugador(List<Jugador> jugadores, Scanner entrada) {
		boolean encontrado=false;
		System.out.println("\n\t*** ELIMINACION DE JUGADOR ***");
		if(hayarJugadores(jugadores)==true) {
			System.out.print("\nIngrese nombre del jugador: ");
			String nombre=entrada.nextLine();
			System.out.print("Ingrese apellido del jugador: ");
			String apellido=entrada.nextLine();
			Iterator <Jugador> k = jugadores.iterator();
			while (k.hasNext()) {
				Jugador jugador = k.next();
				if (jugador.getApellido().equalsIgnoreCase(apellido) && jugador.getNombre().equalsIgnoreCase(nombre)) {
					k.remove();
					encontrado=true;
					System.out.println("Jugador eliminado");
					System.out.print("\n");
					//mostrarJugadores(jugadores);
				}
			}
			if (encontrado==false) {
				System.out.println("El jugador no se encuentra en la lista");
			}
		}
		
	}
	//SE VERIFICA QUE PRIMERO HAYA JUGADORES
	private static void modificarJugador(List<Jugador> jugadores, Scanner entrada) {
		boolean encontrado=false;
		System.out.print("\n\t*** MODIFICACION DE JUGADOR ***");
		if(hayarJugadores(jugadores)==true) {
			System.out.print("\nIngrese nombre del jugador: ");
			String nombre=entrada.nextLine();
			System.out.print("Ingrese apellido del jugador: ");
			String apellido=entrada.nextLine();
			int k=0; 
			while (k<jugadores.size() && encontrado==false) {
				Jugador jugador = jugadores.get(k);
				if (jugador.getApellido().equalsIgnoreCase(apellido) && jugador.getNombre().equalsIgnoreCase(nombre)) {
					modificarDatos(jugador,entrada);
					System.out.println("Datos del jugador modificados\n" + jugador);
					encontrado=true;
				}
				k++;
			}
			if (encontrado==false) {
				System.out.println("El jugador no se encuentra en la lista");
			}
		}
	}
	
	//SE ABRE UN MENU PARA QUE EL JUGADOR ELIJA QUE DATOS MODIFICAR
	private static void modificarDatos(Jugador jugador, Scanner entrada) {
		int opc=0;
		do {
			try {
				System.out.println("\n\tQue dato desea modificar?");
				System.out.println("1) Nombre");
				System.out.println("2) Apellido");
				System.out.println("3) Fecha de nacimiento");
				System.out.println("4) Estatura");
				System.out.println("5) Nacionalidad");
				System.out.println("6) Peso");
				System.out.println("7) Posicion");
				System.out.println("8) Menu anterior");
				System.out.print("Elija una opcion: ");
				opc=entrada.nextInt();
				entrada.nextLine();
				switch (opc) {
				case 1: System.out.print("Ingrese nombre del jugador: ");
						String nombre=entrada.nextLine();
						jugador.setNombre(nombre);
						break;
				case 2: System.out.print("Ingrese apellido del jugador: ");
						String apellido=entrada.nextLine();
						jugador.setApellido(apellido);
						break;
				case 3: LocalDate fechaNac =ingresarFecha(entrada); 
						jugador.setFechaNac(fechaNac);
						break;
				case 4: System.out.print("Ingrese nacionalidad del jugador: ");
						String nacionalidad= entrada.nextLine();
						jugador.setNacionalidad(nacionalidad);
						break;
				case 5: System.out.print("Ingrese altura del jugador en cm: ");
						double altura = entrada.nextDouble();
						jugador.setEstatura(altura);
						break;
				case 6: System.out.print("Ingrese peso del jugador: ");
						double peso = entrada.nextDouble();
						jugador.setPeso(peso);
						break;
				case 7: String posicion = ingresarPosicion(entrada);
						jugador.setPosicion(posicion);
						break;
				case 8: System.out.println("\tADIOS *-*"); break;
				default: System.out.println("Opcion invalida");
				}
			}catch(InputMismatchException ex) {
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
			}
		}while(opc!=8);
		
	}
	//SIEMPRE Y CUANDO HAYAN JUGADORES
	private static void mostrarJugadores(List<Jugador> jugadores) {
		System.out.println("\n\t*** MOSTRAR JUGADORES ***");
		if(hayarJugadores(jugadores)==true) {
			Collections.sort(jugadores,(j1,j2)-> j1.getApellido().compareToIgnoreCase(j2.getApellido()));
			for(int k=0; k<jugadores.size(); k++) {
				System.out.println(jugadores.get(k) + "\tEdad: " + jugadores.get(k).calcularEdad());
			}
		}
	}

	private static void buscarJugador(List<Jugador> jugadores, Scanner entrada) {
		boolean encontrado=false;
		System.out.print("\n\t*** BUSQUEDA DE JUGADOR ***");
		if(hayarJugadores(jugadores)==true)
		if(jugadores.size()!=0) {
			System.out.print("\nIngrese nombre del jugador: ");
			String nombre=entrada.nextLine();
			System.out.print("Ingrese apellido del jugador: ");
			String apellido=entrada.nextLine();
			for (int k=0; k<jugadores.size(); k++) {
				Jugador jugador = jugadores.get(k);
				if (jugador.getApellido().equalsIgnoreCase(apellido) && jugador.getNombre().equalsIgnoreCase(nombre)) {
					System.out.println("Jugador encontrado\n" + "\n" + jugador + "\tEdad: " + jugador.calcularEdad() +"\n");
					encontrado=true;
				}
			}
			if (encontrado==false) {
				System.out.println("El jugador no se encuentra en la lista");
			}
		}
	}
	
	//SE TRATA DE EVITAR HACER ESTA PREGUNTA EN CADA METODO Y AHORRAR LINEAS DE CODIGO
	private static boolean hayarJugadores(List<Jugador> jugadores) {
		if(jugadores.size()==0) {
			System.out.println("\nNo hay jugadores cargados");
			return false;
		} else {
			return true;
		}

	}
	private static void cargarJugador(List<Jugador> jugadores, Scanner entrada) {
		System.out.println("\n\t*** ALTA DE JUGADOR ***");
		System.out.print("\nIngrese nombre del jugador: ");
		String nombre=entrada.nextLine();
		
		System.out.print("Ingrese apellido del jugador: ");
		String apellido=entrada.nextLine();

		LocalDate fechaNac =ingresarFecha(entrada);
		
		System.out.print("Ingrese nacionalidad del jugador: ");
		String nacionalidad= entrada.nextLine();

		
		double altura=ingresarDato(entrada, "altura"); 
		double peso=ingresarDato(entrada,"peso");
		String posicion = ingresarPosicion(entrada);
		
		Jugador jugador = new Jugador(nombre, apellido, fechaNac, nacionalidad, altura, peso, posicion);
		jugadores.add(jugador);
	}

	private static double ingresarDato(Scanner entrada, String cad) {
		double dato=0;
		while (dato==0) {
			try {
				System.out.print("Ingrese " + cad + " del jugador: ");
				dato = Double.parseDouble(entrada.nextLine());
			}catch(NumberFormatException ex) {
				System.out.println("Se esperaba un numero decimal. Revise el ingreso");
			}
		}
		return dato;
	}

	private static String ingresarPosicion(Scanner entrada) {
		String posicion=null;
		boolean band=false;
		do {
			try {
				System.out.println("Posicion del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO) ");
				System.out.println("1) DELANTERO");
				System.out.println("2) MEDIO");
				System.out.println("3) DEFENSA");
				System.out.println("4) ARQUERO");
				System.out.print("Elija una opcion: ");
				int opc = entrada.nextInt();
				entrada.nextLine();
				switch (opc){
				case 1: posicion= "DELANTERO"; band=true; break;
				case 2: posicion= "MEDIO"; band=true; break;
				case 3: posicion= "DEFENSA"; band=true; break;
				case 4: posicion= "ARQUERO"; band=true; break;
				default: System.out.println("Posicion invalida");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
			}
		}while(band==false);
		return posicion;
	}

	private static LocalDate ingresarFecha(Scanner entrada) {
		LocalDate fechaNac=null;
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
		return fechaNac;
	}
	
	private static void precargarJugadores(List<Jugador> jugadores) {
		Jugador jugador1 = new Jugador("Chris", "Hemsworth", LocalDate.of(1995, 10, 10), "Estadounidense", 1.74, 61, "MEDIO");
		Jugador jugador2 = new Jugador("Martin", "Palermo", LocalDate.of(1995, 12, 30), "Argentina", 1.77, 62, "DEFENSA");
		Jugador jugador3 = new Jugador("Angel", "DiMaria", LocalDate.of(1997, 9, 1), "Argentina", 1.77, 62, "DELANTERO");
		Jugador jugador4 = new Jugador("Emilio", "Martinez", LocalDate.of(1993, 3, 9), "Argentina", 1.81, 67, "ARQUERO");
		Jugador jugador5 = new Jugador("Brad", "Pitters", LocalDate.of(1994,9, 12), "Estadounidense", 1.74, 59, "ARQUERO");
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);
		jugadores.add(jugador5);
		System.out.println("Jugadores cargados");
	}

}
