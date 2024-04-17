package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num=0;
		Scanner entrada = new Scanner(System.in);
		while (num<3 || num>10) {
			System.out.print("Ingresa un numero entre 3 y 10: ");
			num=entrada.nextInt();
		}
		int numeros[] = new int[num];
		for(int k=0;k<num;k++) {
			System.out.print("Ingrese un número: ");
			numeros[k]=entrada.nextInt();
		}
		for(int k=0;k<num;k++) {
			System.out.println("Indice: " + k + "\tValor del indice: " + numeros[k]);
		}
		entrada.close();
	}
}
