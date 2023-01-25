package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio9 {

	public static void run() {

		System.out.println(
				"EJERCICIO 9: Mostrar el código de los pedidos donde se haya vendido el producto de la gama ‘Aromáticas’ más caro.");
		System.out.println("");

		String sentenciaSql = "SELECT detallepedidos.CodigoPedido, MAX(productos.PrecioVenta) " + "FROM detallepedidos "
				+ "INNER JOIN productos " + "WHERE productos.Gama = 'Arom?ticas' GROUP BY detallepedidos.CodigoPedido";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			while (resultado.next()) {

				System.out.println("Codigo del pedido: " + resultado.getString(1));
				System.out.println("Precio: " + resultado.getString(2));

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
