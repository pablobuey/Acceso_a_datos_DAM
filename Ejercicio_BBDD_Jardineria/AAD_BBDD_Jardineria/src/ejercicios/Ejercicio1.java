package ejercicios;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio1 {

	public static void run() {

		// Conexión a la BBDD
		Conectar conexion = new Conectar();
		conexion.Conectar();

		// Descripción del ejercicio. Lo imprimo para que sea más claro.
		System.out.println(
				"EJERCICIO 1: 1. Pide dos fechas por teclado y muestra, para aquellos pedidos entre las dos fechas, el código del pedido, la fecha, el nombre del cliente y el nombre o gama del producto. ");
		System.out.println("");

		Scanner sc = new Scanner(System.in);

		// Introducción de los datos
		System.out.println("Introduce primera fecha con formato: 0000-00-00");
		String fecha = sc.next();
		System.out.println("Introduce segunda fecha con formato: 0000-00-00");
		String fecha2 = sc.next();

		// Meto los datos a través de las variables (fecha y fecha2) en la misma query.
		String sentenciaSql = "SELECT pedidos.CodigoPedido, pedidos.FechaPedido, clientes.NombreCliente, productos.Gama "
				+ "FROM pedidos " + "INNER JOIN clientes ON pedidos.CodigoCliente = clientes.CodigoCliente "
				+ "INNER JOIN detallepedidos ON pedidos.codigopedido = detallepedidos.codigopedido "
				+ "INNER JOIN productos ON detallepedidos.codigoproducto = productos.codigoproducto "
				+ "WHERE FechaPedido BETWEEN '" + fecha + "' AND '" + fecha2 + "'";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			System.out.println();

			while (resultado.next()) {

				System.out.println("Codigo de pedido: " + resultado.getInt(1) + "\n" + "Fecha de pedido: "
						+ resultado.getString(2) + "\n" + "Nombre del cliente: " + resultado.getString(3) + "\n"
						+ "Gama del producto: " + resultado.getString(4));

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} finally {
			if (sentencia != null)

				try {
					sentencia.close();
					resultado.close();
				} catch (SQLException sqle) {

					sqle.printStackTrace();
				}
		}

	}

}
