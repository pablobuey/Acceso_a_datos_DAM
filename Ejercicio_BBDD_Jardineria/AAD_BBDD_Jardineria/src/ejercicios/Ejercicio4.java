package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio4 {

	public static void run() {

		System.out.println("EJERCICIO 4: Muestra la cantidad de pedidos que ha realizado cada cliente (LEFT JOIN).");
		System.out.println("");

		String sentenciaSql = "SELECT clientes.NombreCliente, COUNT(pedidos.CodigoPedido) AS numeroPedidos, clientes.CodigoCliente "
				+ "FROM clientes " + "INNER JOIN pedidos " + "ON clientes.CodigoCliente = pedidos.CodigoCliente "
				+ "GROUP BY clientes.NombreCliente";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			while (resultado.next()) {

				System.out.println("Nombre del Cliente: " + resultado.getString(1));
				System.out.println("Numero de Pedidos: " + resultado.getString(2));
				System.out.println("Codigo del Cliente: " + resultado.getString(3));
				System.out.println("");

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
