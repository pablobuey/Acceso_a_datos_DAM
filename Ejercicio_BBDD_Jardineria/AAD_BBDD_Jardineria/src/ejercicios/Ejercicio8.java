package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio8 {

	public static void run() {

		System.out.println(
				"EJERCICIO 8: Muestra el codigo de cada pedido, cuantos productos hay en el pedido y cuanto ha costado (suma de las cantidades*precio_unidad)");
		System.out.println("");

		String sentenciaSql = "SELECT detallepedidos.CodigoPedido, COUNT(detallepedidos.CodigoPedido) AS numeroProductos, SUM(detallepedidos.Cantidad)*detallepedidos.PrecioUnidad AS PrecioTotal FROM detallepedidos GROUP BY detallepedidos.CodigoPedido";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			while (resultado.next()) {

				System.out.println("Codigo del pedido: " + resultado.getString(1));
				System.out.println("Numero de productos: " + resultado.getString(2));
				System.out.println("Precio Total: " + resultado.getString(3));

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
