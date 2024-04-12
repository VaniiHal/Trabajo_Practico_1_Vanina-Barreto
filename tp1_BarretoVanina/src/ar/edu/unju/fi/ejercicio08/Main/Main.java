package ar.edu.unju.fi.ejercicio08.Main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio08.Model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese un numero:");
		int num = entrada.nextInt();
		CalculadoraEspecial calculadora = new CalculadoraEspecial();
		calculadora.setN(num);
		System.out.println("\nEl resultado de la sumatoria es: " + calculadora.calcularSumatoria() +"\nEl resultado de la productoria es: " + calculadora.calcularProductoria());
		entrada.close();
		
		
	}

}
