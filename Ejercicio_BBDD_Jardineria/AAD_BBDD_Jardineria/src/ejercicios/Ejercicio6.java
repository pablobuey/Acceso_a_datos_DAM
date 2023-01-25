package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio6 {

	public static void run() {

		System.out.println("EJERCICIO 6: Muestra cuantos clientes existen en cada una de las ciudades.");
		System.out.println("");

		String sentenciaSql = "SELECT COUNT(clientes.NombreCliente) AS NumeroClientes, clientes.Ciudad FROM clientes GROUP BY clientes.Ciudad";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();
			System.out.println(
					"NOTA: HAY CIUDADES REPETIDAS MAL INSERTADAS CON ESPACIOS, COMO EL CASO DE BARCELONA O FENLABRADA");
			System.out.println("");

			while (resultado.next()) {

				System.out.println("Numero de clientes por Ciudad: " + resultado.getString(1));
				System.out.println("Ciudad: " + resultado.getString(2));

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
