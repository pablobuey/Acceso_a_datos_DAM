package ejercicios;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conectar;

public class Ejercicio2 {

	public static void run() {

		System.out.println("EJERCICIO 2: Muestra por pantalla los diferentes puestos de la tabla de Empleados que hay. "
				+ "Elige uno de ellos y muestra el nombre, los dos apellidos y la ciudad (Tabla oficina) en la que trabajan ");
		System.out.println("");

		String sentenciaSql = "SELECT DISTINCT Puesto FROM empleados";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		Conectar conexion = new Conectar();
		conexion.Conectar();

		try {

			sentencia = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery();

			System.out.println("PRIMERA PARTE DEL EJERCICIO: ");
			System.out.println("");

			while (resultado.next()) {

				System.out.println("Puesto: " + resultado.getString(1));

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

////////SEGUNDA PARTE DEL EJERCICIO 
		System.out.println("");
		System.out.println("SEGUNDA PARTE DEL EJERCICIO: ");
		System.out.println("");
		String sentenciaSql2 = "Select empleados.Puesto, empleados.Nombre, empleados.Apellido1, empleados.Apellido2, oficinas.Ciudad "
				+ "from empleados " + "INNER JOIN oficinas " + "ON empleados.CodigoOficina = oficinas.CodigoOficina  "
				+ "WHERE Puesto = 'Director Oficina'";

		PreparedStatement sentencia2 = null;
		ResultSet resultado2 = null;

		try {

			sentencia2 = (PreparedStatement) conexion.conexionUrlLogPass.prepareStatement(sentenciaSql2);
			resultado2 = (ResultSet) sentencia2.executeQuery();

			while (resultado2.next()) {

				System.out.println("Puesto: " + resultado2.getString(1));
				System.out.println("Nombre empleado: " + resultado2.getString(2));
				System.out.println("Primer apellido: " + resultado2.getString(3));
				System.out.println("Segundo apellido: " + resultado2.getString(4));
				System.out.println("Ciudad: " + resultado2.getString(5));
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
