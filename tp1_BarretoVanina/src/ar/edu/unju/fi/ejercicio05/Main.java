package ar.edu.unju.fi.ejercicio05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numero=0;
		numero=ingresarValor(numero);
		multiplicarNumero(numero);
	}
	
	public static int ingresarValor(int num) {
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Ingrese un numero entre 1 y 9");
			while(entrada.hasNextInt() == false) {
				System.out.println("El valor ingresado no es un numero");
				entrada.next();
			}
			num=entrada.nextInt();
			if (num<1 || num>9) {
				System.out.println("El valor no se encuentra en el rango");
				}
		}while(num<1 || num>9);
		entrada.close();
		return num;
	}
	
	public static void multiplicarNumero(int num) {
		for (int k=0;k<=10;k++) {
			System.out.println(num + " x " + k + " = " + num*k);
		}
	}
}
