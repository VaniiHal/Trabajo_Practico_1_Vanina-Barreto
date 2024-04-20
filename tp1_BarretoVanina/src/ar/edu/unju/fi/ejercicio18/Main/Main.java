package ar.edu.unju.fi.ejercicio18.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio18.Model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.Model.Pais;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		List<Pais> paises = new ArrayList<>();
		List<DestinoTuristico> destinos = new ArrayList<>();
		precargarPaises(paises);
		int opcion=0;
		
		do {
			try {
				System.out.println("\n\t*** MENU DE OPCIONES ***");
				System.out.println("1- Alta de destino turistico");
				System.out.println("2- Mostrar todos los destinos turisticos");
				System.out.println("3- Modificar el pais de un destino turistico");
				System.out.println("4- Limpiar la lista de destinos turisticos");
				System.out.println("5- Eliminar un destino turistico");
				System.out.println("6- Mostrar todos los destinos turisticos ordenados por nombre");
				System.out.println("7- Mostrar todos los paises");
				System.out.println("8- Mostrar los destinos turisticos de un pais");
				System.out.println("9- Salir");
				System.out.print("Elija una opcion: ");
				opcion = entrada.nextInt();
				entrada.nextLine(); //se limpia el buffer
				switch (opcion) {
				case 1: cargarDestino(destinos,entrada,paises); break;
				case 2: mostrarDestino(destinos); break;
				case 3: modificarDestino(destinos,entrada,paises); break;
				case 4: limpiarLista(destinos); break;
				case 5: eliminarDestino(destinos,entrada); break;
				case 6: mostrarPoNombres(destinos); break;
				case 7: mostrarPaises(paises); break;
				case 8: mostrarPorPais(destinos,entrada,paises); break;
				case 9: System.out.println("\tADIOS *-*"); break;
				default: System.out.println("Opcion invalida");
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso de opcion. Se esperaba un numero");
			}
		}while(opcion!=9);
			}

	
	private static void mostrarPorPais(List<DestinoTuristico> destinos, Scanner entrada, List<Pais> paises) {
		System.out.println("\n\t*** MOSTRAR DESTINOS POR PAIS ***");
		
		if(hayarDestino(destinos)==true) {
			Pais pais = ingresarPais(entrada,paises);
			for (DestinoTuristico destino : destinos) {
				if(destino.getPais().getCodigo()==pais.getCodigo()) {
					System.out.println(destino);
				}
			}
		}
	}

	//SE MUESTRAN TODOS LOS PAISES
	private static void mostrarPaises(List<Pais> paises) {
		System.out.println("\n\t*** MOSTRAR PAISES ***");
		for(Pais pais : paises) {
			System.out.println(pais);
		}
	}

	//SE MUESTRAN Y ORDENAN SIEMPRE Y CUANDO HAYN DESTINOS CARGADOS 
	private static void mostrarPoNombres(List<DestinoTuristico> destinos) {
		System.out.println("\n\t*** MOSTRAR DESTINOS ORDENADOS POR PAISES ***");
		if(hayarDestino(destinos)==true) {
			Collections.sort(destinos, (d1,d2)->d1.getNombre().compareToIgnoreCase(d2.getNombre()));
			for(DestinoTuristico destino : destinos) {
				System.out.println(destino);
			}
		}
	}

	//SE ELIMINA SIEMPRE Y CUANDO HAYAN DESTINOS CARGADOS
	private static void eliminarDestino(List<DestinoTuristico> destinos, Scanner entrada) {
		System.out.println("\n\t*** ELIMINAR DESTINO TURISTICO ***");
		if(hayarDestino(destinos)==true) {
			boolean band=false; int codigo=-1; 
			System.out.print("\nIngrese codigo de destino turistico: ");
			try {
				codigo=entrada.nextInt();
				for (Iterator<DestinoTuristico> iterator = destinos.iterator(); iterator.hasNext(); ) {
                    DestinoTuristico destino = iterator.next();
                    if (destino.getCodigo() == codigo) {
                        iterator.remove();
                        System.out.println("Destino turistico eliminado correctamente.");
                        band = true;
                    }
                }
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Se esperaba un numero");
			}
			if(band==false) {
				System.out.println("El codigo del destino no se encontro");
			}
		}
	}

	//SIEMPRE Y CUANDO HAYAN DESTINOS CARGADOS 
	//SE LIMPIA LA LISTA SIEMPRE Y CUANDO HAYA DESTINOS EN ELLA
	private static void limpiarLista(List<DestinoTuristico> destinos) {
		System.out.println("\n\t*** LIMPIAR LISTA DE DESTINOS TURISTICOS ***");
		if(hayarDestino(destinos)==true) {
			destinos.clear();
			System.out.println("La lista de destinos turisticos ha sido limpiada");
		}
	}

	//SIEMPRE Y CUANDO HAYAN DESTINOS CARGADOS
	private static void modificarDestino(List<DestinoTuristico> destinos, Scanner entrada, List<Pais> paises) {
		System.out.println("\n\t*** MODIFICAR DESTINO TURISTICO ***");
		int codigo=0; boolean valido=false;
		if(hayarDestino(destinos)==true) {
			do {
				System.out.print("\nIngrese codigo del destino turistico: ");
				try {
					codigo=entrada.nextInt();
					entrada.nextLine();
					valido=true;
				}catch(InputMismatchException ex){
					System.out.println("Error en el ingreso del dato. Se esperaba un numero");
				}
			}while(valido==false);
			if(valido==true) {
				for(DestinoTuristico destino : destinos) {
					if(destino.getCodigo()==codigo) {
						modificarDatos(destino,entrada,paises);
					}
				}
			}
		}
	}

	//METODO PARA CARGAR TODOS LOS DATOS DE NUEVO MENOS EL CODIGO DE DESTINO
	private static void modificarDatos(DestinoTuristico destino, Scanner entrada, List<Pais> paises) {
		String nombre=ingresarNombre(entrada);
		double precio=ingresarPrecio(entrada);
		Pais pais = ingresarPais(entrada,paises);
		System.out.println("Ingrese cantidad de dias: ");
		int cantidad=entrada.nextInt();
		entrada.nextLine();
		destino.setCantDias(cantidad);
		destino.setNombre(nombre);
		destino.setPais(pais);
		destino.setPrecio(precio);
	}
	
	//SIEMPRE Y CUANDO HAYA DESTINOS CARGADOS


	//SE MOSTRARAN LOS DESTINOS SI HAY DESTINOS CARGADOS
	private static void mostrarDestino(List<DestinoTuristico> destinos) {
		System.out.println("\n\t*** MOSTRAR DESTINOS TURISTICOS ***");
		if(hayarDestino(destinos)==true) {
			for (DestinoTuristico destino : destinos) {
				System.out.println(destino);
			}
		}
	}

	//METODO AUXILIAR SI LA LISTA ESTA VACIA SE MUESTRA UN CARTEL RETORNO LOGICO
	private static boolean hayarDestino(List<DestinoTuristico> destinos) {
		if(destinos.size()==0) {
			System.out.println("\nNo hay destinos turisticos cargados");
			return false;
		} else {
			return true;
		}
	}

	//METODO DE CARGA SE UTILIZAN METODOS AUXILIARES PARA UN MEJOR MANEJO
	private static void cargarDestino(List<DestinoTuristico> destinos, Scanner entrada, List<Pais> paises) {
		System.out.println("\n\t*** ALTA DE DESTINO TURISTICO ***");
		int codigoDT=ingrasarCodigoDT(destinos,entrada);
		String nombre=ingresarNombre(entrada);
		double precio=ingresarPrecio(entrada);
		Pais pais = ingresarPais(entrada,paises);
		System.out.println("Ingrese cantidad de dias: ");
		int cantidad=entrada.nextInt();
		DestinoTuristico destino = new DestinoTuristico(codigoDT, nombre, precio, pais, cantidad);
		destinos.add(destino);
		System.out.println("Destino turistico cargado" + destino + "\n");
		entrada.nextLine();
	}

	//SE SOLICITA EL INGRESO DEL CODIGO DE PAIS PARA EL DESTINO
	private static Pais ingresarPais(Scanner entrada, List<Pais> paises) {
		int codigo; boolean valido=false;
		Pais paisSeleccionado =null;
		do {
			System.out.println("Ingrese codigo de pais: ");
			try {
				codigo= entrada.nextInt();
				entrada.nextLine();
				paisSeleccionado = validarPais(codigo,paises);
				if (paisSeleccionado !=null) {
					valido=true;
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Se esperaba un numero");
			}
		}while(valido==false);
		return paisSeleccionado;
	}

	//METODO AUXILIAR SE BUSCA EL CODIGO PARA SABER SI EXISTE Y SE DEVUELVE EL PAIS PARA LA CARGA DEL DESTINO TURISTICO
	private static Pais validarPais(int codigo, List<Pais> paises) {
		for(Pais pais : paises) {
			if(pais.getCodigo()==codigo) {
				return pais;
			}
		}
		return null;
	}

	//SE SOLICITA EL INGRESO DEL PRECIO Y VALIDACION
	private static double ingresarPrecio(Scanner entrada) {
		double precio=0; boolean band=false;
		do {
			try {
				System.out.print("\nIngresar precio: ");
				precio=Double.parseDouble(entrada.nextLine());
				band=true;
			}catch(NumberFormatException ex) {
				System.out.println("Se esperaba un numero decimal. Revise el ingreso");
			}
		} while(band==false);
		entrada.nextLine();
		return precio;
	}

	//SE HACE UNA VALIDACION DEL NOMBRE
	private static String ingresarNombre(Scanner entrada) {
		String nombre=""; boolean valido=false;
		do {
			try {
				System.out.print("\nIngresar nombre de Destino Turistico: ");
				nombre= entrada.nextLine();
				verificarNombre(nombre);
				valido=true;
			}catch (InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Ingreselo nuevamente");
			}
		}while(!valido);
		entrada.nextLine();
		return nombre;
	}

	//METODO AUXILIAR VERIFICA LA LOGICA DEL NOMBRE INGRESADO
	private static void verificarNombre(String nombre) throws InputMismatchException {
		if(!nombre.matches("[a-zA-Z]")) {
			throw new InputMismatchException();
		}
	}

	//VALIDACION DEL CODIGO DEL DESTINO Y NO ESTE REPETIDO
	private static int ingrasarCodigoDT(List<DestinoTuristico> destinos, Scanner entrada) {
		int codigoDT=-1; boolean valido=false;
		do {
			try {
				System.out.print("\nIngrese codigo de Destino turistico (numerico)");
				codigoDT = entrada.nextInt();
				for (DestinoTuristico destino : destinos) {
					if (destino.getCodigo() == codigoDT) {
						System.out.println("El codigo ya se encuentra registrado. Ingrese otro\n");
					} else {
						valido=true;
					}
				}
			}catch(InputMismatchException ex){
				System.out.println("Error en el ingreso del dato. Se esperaba un numero");
			}
		}while(valido==false);
		entrada.nextLine();
		return codigoDT;
	}

	private static void precargarPaises(List<Pais> paises) {
		Pais pais1 = new Pais(01, "Paraguay");
		Pais pais2 = new Pais(02, "Francia");
		Pais pais3 = new Pais(03, "Colombia");
		Pais pais4 = new Pais(04, "Japon");
		Pais pais5 = new Pais(05, "Inglaterra");
		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		paises.add(pais4);
		paises.add(pais5);
	}

}
