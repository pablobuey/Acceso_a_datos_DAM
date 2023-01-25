package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio5 {

	public static void run() {

		System.out.println("EJERCICIO 5: Muestra cuantos empleados hay por puesto.");
		System.out.println("");

		String sentenciaSql = "SELECT COUNT(empleados.Nombre) AS NumeroEmpleados, empleados.Puesto FROM empleados GROUP BY empleados.Puesto";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			while (resultado.next()) {

				System.out.println("Numero de Empleados por puesto: " + resultado.getString(1));
				System.out.println("Puesto: " + resultado.getString(2));

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
