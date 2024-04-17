package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] nombres = new String[5];
		Scanner entrada = new Scanner(System.in);
		for (int k=0; k<nombres.length; k++) {
			System.out.print("Ingrese un nombre: ");
			nombres[k]=entrada.next();
		}
		System.out.println("El tamaño del arreglo es: " + nombres.length);
		int num;
		do {
			System.out.print("Ingrese un numero entre 0 y 4: ");
			num = entrada.nextInt();
		} while(num < 0 || num > 4);
		entrada.close();
	}

}
