package principal;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Ej3_Insert_Update_Delete_Query {

	public static void main(String[] args) throws SQLException {

///////// CONEXION

		Connection conexion = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			System.out.println("(conexion realizada con exito)");
			System.out.println("");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("conexion falla");
		}

		catch (SQLException sqle) {

			sqle.printStackTrace();
		}

//////////

///////// MENU 

		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean salir = false;

		while (!salir) {

			System.out.println("Selecciona una opcion: ");
			System.out.println("1: Inserta un nuevo doctor en la tabla.");
			System.out.println("2: Actualiza los datos de un doctor.");
			System.out.println("3: Elimina un doctor que hayas insertado con el apartado a.");
			System.out.println("4: Muestra los doctores de la tabla.");
			System.out.println("5: Salir.");

			option = sc.nextInt();

			switch (option) {
////////////INSERT
			case 1:

				System.out.println("Introduce Doctor_no:");
				int doctor_no = sc.nextInt();

				System.out.println("Introduce Hospital_Cod entre: 18, 19, 22 o 45: "); // pq es foreign key y está
																						// relacionado
				int hospital_cod = sc.nextInt();

				System.out.println("Introduce Apellido:");
				String apellido = sc.next();

				System.out.println("Introduce Especialidad:");
				String especialidad = sc.next();

				String sentenciaSql = "Insert into doctor (Doctor_No, Hospital_Cod, Apellido, Especialidad)"
						+ " VALUES (?,?,?,?)";

				PreparedStatement sentencia = null;

				try {
					sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);
					sentencia.setInt(1, doctor_no);
					sentencia.setInt(2, hospital_cod);
					sentencia.setString(3, apellido);
					sentencia.setString(4, especialidad);

					sentencia.executeUpdate();

				} catch (SQLException sqle) {
					sqle.printStackTrace();

				} finally {

					if (sentencia != null) {

						try {
							sentencia.close();
							// resultado.close();
						} catch (SQLException sqle) {
							sqle.printStackTrace();
						}
					}
				}

				break;
/////////////UPDATE
			case 2:

				sentenciaSql = "UPDATE doctor SET Doctor_No = ?, Hospital_Cod = ?, Apellido=?, Especialidad=? WHERE Doctor_No = ?";
				sentencia = null;

				try {

					sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);

					sentencia.setInt(1, 2);
					sentencia.setInt(2, 22);
					sentencia.setString(3, "DoctorPepeActualizado");
					sentencia.setString(4, "EspecialistaActualizado");
					sentencia.setInt(5, 1);
					sentencia.executeUpdate();

				} finally {
					if (sentencia != null)

						try {
							sentencia.close();

						} catch (SQLException sqle) {

							sqle.printStackTrace();
						}
				}
				break;
////////////DELETE
			case 3:
				sentenciaSql = "DELETE FROM doctor WHERE Doctor_No = ?";
				sentencia = null;

				try {

					sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);

					sentencia.setInt(1, 2);

					sentencia.executeUpdate();

				} finally {
					if (sentencia != null)

						try {
							sentencia.close();

						} catch (SQLException sqle) {

							sqle.printStackTrace();
						}
				}
				break;
////////////QUERY				
			case 4:

				sentenciaSql = "Select Doctor_No, Hospital_Cod, Apellido, Especialidad FROM doctor";

				ResultSet resultado = null; // ESTO ES LO UNICO DISTINTO EN EL QUERY
				sentencia = null;

				try {
					sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);
					resultado = (ResultSet) sentencia.executeQuery();

					while (resultado.next()) {

						System.out.println("Doctor_No: " + resultado.getInt(1));
						System.out.println("Hospital_Cod: " + resultado.getInt(2));
						System.out.println("Apellido: " + resultado.getString(3));
						System.out.println("Especialidad: " + resultado.getString(4));
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
				break;

			case 5:
				System.out.println("Hasta la proxima.");
				salir = true;

				break;

			}// switch

		} // while menu

	}

}
