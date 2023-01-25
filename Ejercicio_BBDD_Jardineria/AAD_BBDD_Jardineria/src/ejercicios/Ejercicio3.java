package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio3 {

	public static void run() {

		System.out.println(
				"EJERCICIO 3: Muestra, para cada uno de los pedidos, el nombre del cliente que ha realizado el pedido, "
						+ "la fecha del pedido, cuál es el nombre de los productos que se han comprado y su precio por unidad ");
		System.out.println("");

		String sentenciaSql = "SELECT pedidos.FechaPedido, clientes.NombreCliente, productos.Nombre, productos.PrecioVenta "
				+ "FROM pedidos " + "INNER JOIN clientes " + "INNER JOIN productos " + "INNER JOIN detallepedidos "
				+ "WHERE pedidos.CodigoCliente = clientes.CodigoCliente "
				+ "AND pedidos.CodigoPedido = detallepedidos.CodigoPedido "
				+ "AND detallepedidos.CodigoProducto = productos.CodigoProducto";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			while (resultado.next()) {

				System.out.println("Fecha del pedido: " + resultado.getString(1));
				System.out.println("Nombre del cliente: " + resultado.getString(2));
				System.out.println("Nombre del producto: " + resultado.getString(3));
				System.out.println("Precio del producto: " + resultado.getString(4));

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
