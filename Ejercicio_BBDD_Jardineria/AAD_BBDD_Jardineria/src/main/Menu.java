package main;

import java.util.Scanner;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;
import ejercicios.Ejercicio5;
import ejercicios.Ejercicio6;
import ejercicios.Ejercicio7;
import ejercicios.Ejercicio8;
import ejercicios.Ejercicio9;

public class Menu {

	static String menu = "go";
	static int opt = 0;
	static Scanner sc = new Scanner(System.in);

	public static void menuEjercicios() {

		while (!menu.contentEquals("quit")) {

			System.out.println("INTRODUCE NUMERO DE CONSULTA A EJECUTAR:\n");

			System.out.println("1: Pide dos fechas por teclado y muestra, para aquellos pedidos entre las dos fechas, "
					+ "el código del pedido, la fecha, el nombre del cliente y el nombre o gama del producto. ");
			System.out.println("");

			System.out.println("2: Muestra por pantalla los diferentes puestos de la tabla de Empleados que hay. "
					+ "Elige uno de ellos y muestra el nombre, los dos apellidos y la ciudad (Tabla oficina) en la que trabajan ");
			System.out.println("");

			System.out.println(
					"3: Muestra, para cada uno de los pedidos, el nombre del cliente que ha realizado el pedido, "
							+ "la fecha del pedido, cuál es el nombre de los productos que se han comprado y su precio por unidad ");
			System.out.println("");

			System.out.println("4: Muestra la cantidad de pedidos que ha realizado cada cliente (LEFT JOIN).");
			System.out.println("");

			System.out.println("5: Muestra cuantos empleados hay por puesto.");
			System.out.println("");

			System.out.println("6: Muestra cuantos clientes existen en cada una de las ciudades.");
			System.out.println("");

			System.out.println(
					"7: Muestra el nombre y el precio de venta del producto más caro y el nombre el precio de venta del producto más barato.");
			System.out.println("");

			System.out.println(
					"8: Muestra el codigo de cada pedido, cuantos productos hay en el pedido y cuanto ha costado (suma de las cantidades*precio_unidad)");
			System.out.println("");

			System.out.println(
					"9: Mostrar el código de los pedidos donde se haya vendido el producto de la gama ‘Aromáticas’ más caro.");

			System.out.println("");

			opt = sc.nextInt();

			switch (opt) {

			case 1:

				Ejercicio1.run();
				subMenu();
				break;

			case 2:

				Ejercicio2.run();
				subMenu();
				break;

			case 3:

				Ejercicio3.run();
				subMenu();
				break;

			case 4:

				Ejercicio4.run();
				subMenu();
				break;

			case 5:

				Ejercicio5.run();
				subMenu();
				break;

			case 6:

				Ejercicio6.run();
				subMenu();
				break;

			case 7:

				Ejercicio7.run();
				subMenu();
				break;

			case 8:

				Ejercicio8.run();
				subMenu();
				break;

			case 9:
				Ejercicio9.run();
				break;

			}//switch

		}//while
		
		System.out.println("ADIOS!");

	}//menuEjercicios

	static void subMenu() {

		System.out.println("PARA VOLVER AL MENU INTRODUCE go");
		System.out.println("PARA SALIR INTRODUCE quit");
		menu = sc.next();
	
		
		

	}

}
