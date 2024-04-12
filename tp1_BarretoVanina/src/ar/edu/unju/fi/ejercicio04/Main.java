package ar.edu.unju.fi.ejercicio04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int numero=0, factorial=0;
		numero = ingresarValor(numero);
		factorial = calcularFactorial(numero);
		System.out.println("El factorial de " + numero + " es: " + factorial);
	}
	
	public static int ingresarValor(int num) {
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Ingrese un numero entre 0 y 10");
			while(entrada.hasNextInt() == false) {
				System.out.println("El valor ingresado no es un numero");
				entrada.next();
			}
			num=entrada.nextInt();
			if (num<0 || num>10) {
				System.out.println("El valor no se encuentra en el rango");
				}
		}while(num<0 || num>10);
		entrada.close();
		return num;
	}
	
	public static int calcularFactorial(int num) {
		int fact=1, cont=1;
		while(cont<=num) {
			fact=fact*cont;
			cont++;
		}
		return fact;
	}

}
