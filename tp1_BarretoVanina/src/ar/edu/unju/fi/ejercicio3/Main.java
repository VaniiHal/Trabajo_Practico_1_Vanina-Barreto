package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese un numero: ");
		if (entrada.hasNextInt()) {
			int num =entrada.nextInt();
			if (num%2 == 0)
			{
				System.out.println(num*3);
			}
			else
			{
				System.out.println(num*2);
			}
		}
		else
		{
			System.out.println("El valor ingresado es incorrecto");
		}
		entrada.close();
	}

}
