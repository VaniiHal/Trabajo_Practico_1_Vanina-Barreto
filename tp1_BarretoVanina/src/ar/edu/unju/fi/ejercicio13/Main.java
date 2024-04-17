package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] numeros = new int[8];
		Scanner entrada = new Scanner(System.in);
		for(int k=1;k<=8;k++) {
			System.out.println("Ingrese un número entero: ");
			numeros[k-1] = entrada.nextInt();
		}
		for(int k=0;k<8;k++) {
			System.out.println("Indice: " + k + "\tValor del indice: " + numeros[k]);
		}
		entrada.close();
	}

}
