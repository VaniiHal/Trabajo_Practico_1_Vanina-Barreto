package ar.edu.unju.fi.ejercicio7.Main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.Model.Empleado;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		
		System.out.println("Ingrese nombre:");
		String nombre = entrada.nextLine();
		System.out.println("Ingrese legajo:");
		int legajo = entrada.nextInt();
		System.out.println("Ingrese salario:");
		double salario = entrada.nextDouble();
		
		Empleado empleado= new Empleado(nombre, legajo, salario);
		System.out.println(empleado); // creo que  no importa como se lo invoca
		empleado.aumentarMerito();
		System.out.println("\n Aumento Salarial \n" + empleado);
		entrada.close();
	}

}
