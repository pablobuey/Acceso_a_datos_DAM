package principal;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import java.sql.SQLException;

public class Ej2A_INSERTAR_DATOS {

	public static void main(String[] args) throws SQLException {
		
/////////CONEXIÓN	
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
		
/////////INTRODUCIENDO DATOS NUEVOS:
		
		String sentenciaSql = "Insert into enfermo (Inscripcion, Apellido, Direccion, Fecha_Nac, S, NSS)"
				+ " VALUES (?,?,?,?,?,?)"; 
		
		PreparedStatement sentencia = null; 
		
		try {
			sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);
			sentencia.setInt(1, 1);
			sentencia.setString(2, "Buey");
			sentencia.setString(3, "Zaragoza");	
			sentencia.setString(4, "18-8-86");
			sentencia.setString(5, "M");
			sentencia.setInt(6, 1);
			
			sentencia.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
			
		} finally {
			
			if (sentencia !=null) {
				
				try {
					sentencia.close();
				//	resultado.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		}
		
/////////CONSULTA DE DATOS INSERTADOS
		
		sentenciaSql = "Select Inscripcion, Apellido, Direccion, Fecha_Nac, S, NSS from enfermo WHERE Inscripcion = 1";
		sentencia = null;
		ResultSet resultado = null;
	
		
		try {
			sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);
			resultado = (ResultSet) sentencia.executeQuery(); 
			
			while (resultado.next()) {
				
				System.out.println("Inscripción: " + resultado.getInt(1));
				System.out.println("Apellido: " + resultado.getString(2));
				System.out.println("Dirección: " + resultado.getString(3));
				System.out.println("Fecha nacimiento: " + resultado.getString(4));
				System.out.println("S: " + resultado.getString(5));
				System.out.println("NSS: " + resultado.getInt(6));
				System.out.println("");
			}
			
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			
		} finally { 
			if (sentencia !=null)
			
			try {
				sentencia.close();
				resultado.close(); 
			} catch (SQLException sqle){
				
				sqle.printStackTrace();
			}
		}
		
/////////////////		
		
	}

}
