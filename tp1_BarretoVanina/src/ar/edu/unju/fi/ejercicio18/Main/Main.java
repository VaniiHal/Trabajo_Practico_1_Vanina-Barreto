package ar.edu.unju.fi.ejercicio18.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio18.Model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.Model.Pais;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<Pais> paises = new ArrayList<>();
		List<DestinoTuristico> destinos = new ArrayList<>();
		precargarPaises(paises);
		int opcion=0;
		
		do {
			System.out.println("\n\t***MENU DE OPCIONES***");
			System.out.println("1- Alta de destino turistico");
			System.out.println("2- Mostrar todos los destinos turisticos");
			System.out.println("3- Modificar el pais de un destino turistico");
			System.out.println("4- Limpiar la lista de destinos turisticos");
			System.out.println("5- Eliminar un destino turistico");
			System.out.println("6- Mostrar todos los destinos turisticos ordenados por nombre");
			System.out.println("7- Mostrar todos los paises");
			System.out.println("8- Mostrar los destinos turisticos de un pais");
			System.out.println("9- Salir");
			System.out.print("Elija una opcion: ");
			opcion = entrada.nextInt();
			entrada.nextLine(); //se limpia el buffer
			switch (opcion) {
			case 1: cargarDestino(destinos,entrada); break;
			case 2: mostrarDestino(destinos); break;
			case 3: modifiarDestino(destinos,entrada); break;
			case 4: limpiarLista(destinos); break;
			case 5: eliminarDestino(destinos,entrada); break;
			case 6: mostrarPoNombres(destinos); break;
			case 7: mostrarPaises(paises); break;
			case 8: mostrarPorPais(destinos,entrada); break;
			case 9: System.out.println("\tADIOS *-*"); break;
			default: System.out.println("Opcion invalida");
			}
		}while(opcion!=9);
		
	}

	
	private static void mostrarPorPais(List<DestinoTuristico> destinos, Scanner entrada) {
		// TODO Auto-generated method stub
		
	}


	private static void mostrarPaises(List<Pais> paises) {
		// TODO Auto-generated method stub
		
	}


	private static void mostrarPoNombres(List<DestinoTuristico> destinos) {
		// TODO Auto-generated method stub
		
	}

	private static void eliminarDestino(List<DestinoTuristico> destinos, Scanner entrada) {
		// TODO Auto-generated method stub
		
	}

	private static void limpiarLista(List<DestinoTuristico> destinos) {
		// TODO Auto-generated method stub
		
	}

	private static void modifiarDestino(List<DestinoTuristico> destinos, Scanner entrada) {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarDestino(List<DestinoTuristico> destinos) {
		// TODO Auto-generated method stub
		
	}

	private static void cargarDestino(List<DestinoTuristico> destinos, Scanner entrada) {
		// TODO Auto-generated method stub
		
	}

	private static void precargarPaises(List<Pais> paises) {
		Pais pais1 = new Pais(01, "Paraguay");
		Pais pais2 = new Pais(02, "Francia");
		Pais pais3 = new Pais(03, "Colombia");
		Pais pais4 = new Pais(04, "Japon");
		Pais pais5 = new Pais(05, "Inglaterra");
		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		paises.add(pais4);
		paises.add(pais5);
	}

}
