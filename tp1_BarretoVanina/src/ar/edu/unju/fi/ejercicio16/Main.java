package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] nombres = new String[5];
		Scanner entrada = new Scanner(System.in);
		//INGRESO DE NOMBRES
		ingresarNombres(nombres,entrada);
		// MOSTRAR EL ARREGLO
		mostrarNombres(nombres);
		System.out.println("\nEl tamaño del arreglo es: " + nombres.length);
				
		//ELIMINAR NOMBRE DEL ARREGLO
		eliminarNombres(nombres,entrada);
		mostrarNombres(nombres);
		
		entrada.close();
	}

	private static void mostrarNombres(String[] nombres) {
		System.out.print("\n");
		for (int k=0; k<nombres.length; k++) {
			System.out.print(nombres[k] + "\t");
		}
		System.out.print("\n");
	}

	private static void eliminarNombres(String[] nombres, Scanner entrada) {
		int num;
		do {
			System.out.print("Ingrese un numero entre 1 y 5: ");
			num = entrada.nextInt();
		} while(num < 1 || num > 5);
		nombres[num-1]=""; //se elimina directamente. de ser el 5 no ingresa en el bucle 
		mostrarNombres(nombres); //se verifica el espacio vacio
		while(num-1<nombres.length-1) {//se hace un bucle desde el numero indicado menos 1 igual para length
			nombres[num-1]=nombres[num]; //se corre el nombre de a lado
			nombres[num]=""; // se elimina ese nombre o quedan copias 
			num++;
		}
	}

	private static void ingresarNombres(String[] nombres, Scanner entrada) {
		
		for (int k=0; k<nombres.length; k++) {
			System.out.print("Ingrese un nombre: ");
			nombres[k]=entrada.next();
		}
	}

}
