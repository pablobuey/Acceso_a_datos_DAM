package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio7 {

	public static void run() {

		System.out.println(
				"EJERCICIO 7: Muestra el nombre y el precio de venta del producto más caro y el nombre el precio de venta del producto más barato.");
		System.out.println("");

		String sentenciaSql = "SELECT productos.Nombre, productos.PrecioVenta " + "FROM productos "
				+ "WHERE productos.PrecioVenta = (SELECT MAX(productos.PrecioVenta)FROM productos)";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			while (resultado.next()) {

				System.out.println("Nombre del producto más caro: " + resultado.getString(1));
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

		String sentenciaSql2 = "SELECT productos.Nombre, productos.PrecioVenta " + "FROM productos "
				+ "WHERE productos.PrecioVenta = (SELECT MIN(productos.PrecioVenta)FROM productos)";

		PreparedStatement sentencia2 = null;
		ResultSet resultado2 = null;
		Conectar conexion2 = new Conectar();
		conexion2.Conectar();

		try {

			sentencia2 = (PreparedStatement) conexion2.conexionUrlLogPass.prepareStatement(sentenciaSql2);
			resultado2 = (ResultSet) sentencia2.executeQuery();

			while (resultado2.next()) {

				System.out.println("Nombre del producto más barato: " + resultado2.getString(1));
				System.out.println("Precio: " + resultado2.getString(2));

				System.out.println("");

			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} finally {
			if (sentencia2 != null)

				try {
					sentencia2.close();
					resultado2.close();

				} catch (SQLException sqle) {

					sqle.printStackTrace();
				}
		}

	}

}
