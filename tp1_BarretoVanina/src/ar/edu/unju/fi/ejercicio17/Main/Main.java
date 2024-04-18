package ar.edu.unju.fi.ejercicio17.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio17.Model.Jugador;

public class Main {

	public static void main(String[] args) {
		int opcion=0;
		Scanner entrada = new Scanner(System.in);
		List<Jugador> jugadores = new ArrayList<>(); 
		do {
			System.out.println("\tMENU DE OPCIONES");
			System.out.println("1- Alta de jugador");
			System.out.println("2- Mostrar datos del jugador");
			System.out.println("3- Mostrar todos los jugadores");
			System.out.println("4- Modificar datos del jugador");
			System.out.println("5- Eliminar jugador");
			System.out.println("6- Mostrar cantidad total de jugadores");
			System.out.println("7- Mostrar cantidad de jugadores de una nacionalidad");
			System.out.println("8- Salir");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1: altaJugador(jugadores,entrada); break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6: System.out.println("La cantidad total de jugares es: " + jugadores.size()); break;
			case 7:
			case 8:
			default: System.out.println("\tADIOS *-*");
			}
		} while(opcion != 8);
		
		entrada.close();
	}

	private static void altaJugador(List<Jugador> jugadores, Scanner entrada) {
		Jugador jugador= new Jugador();
		System.out.print("Ingrese nombre del jugador: ");
		String nombre=entrada.nextLine();
		System.out.print("Ingrese apellido del jugador: ");
		String apellido=entrada.nextLine();
		
		
	}

}
