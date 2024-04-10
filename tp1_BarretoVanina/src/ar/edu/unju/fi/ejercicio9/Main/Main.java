package ar.edu.unju.fi.ejercicio9.Main;

import java.util.Scanner;
import ar.edu.unju.fi.ejercicio9.Model.Producto;

public class Main {

	public static void main(String[] args) {
		int k=0;
		Scanner entrada = new Scanner(System.in);
		Producto producto = new Producto();
		
		while(k<3) {
			System.out.println("Ingrese nombre del producto:");
			String nombre = entrada.nextLine();
			System.out.println("Ingrese codigo:");
			int codigo=entrada.nextInt();
			entrada.nextLine();
			System.out.println("Ingrese precio:");
			double precio = entrada.nextDouble();
			entrada.nextLine();
			System.out.println("Ingrese descuento entre 0 y 50");
			int descuento = entrada.nextInt();
			entrada.nextLine();
			cargarDatos(producto,nombre,codigo,precio,descuento);
			System.out.println(producto);
			System.out.println("Precio con descuento: " + producto.calcularDescuento() + "\n");
			k++;
		}
		entrada.close();
	}

	private static void cargarDatos(Producto producto, String nombre, int codigo, double precio, int descuento) {
		producto.setCodigo(codigo);
		producto.setDescuento(descuento);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
	}

}
