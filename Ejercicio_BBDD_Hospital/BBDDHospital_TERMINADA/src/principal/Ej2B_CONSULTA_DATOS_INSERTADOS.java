package principal;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Ej2B_CONSULTA_DATOS_INSERTADOS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
////////////		
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

///////////////
				
		String sentenciaSql = "Select Inscripcion, Apellido, Direccion, Fecha_Nac, S, NSS from enfermo WHERE Inscripcion = 1";
		PreparedStatement sentencia = null;
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
		
//////////////
		
	}

}
