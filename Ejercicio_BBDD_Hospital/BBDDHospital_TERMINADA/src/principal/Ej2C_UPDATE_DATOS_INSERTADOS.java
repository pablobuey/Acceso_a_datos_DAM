package principal;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Ej2C_UPDATE_DATOS_INSERTADOS {

	public static void main(String[] args) throws SQLException {
	
//////////		
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
/////////// UPDATE
		
		String sentenciaSql = "UPDATE enfermo SET Inscripcion = ?, Apellido = ?, Direccion=?, Fecha_Nac=?, S=?, NSS=? WHERE Inscripcion = ?";
		PreparedStatement sentencia = null;
		
		
		
		try {
			
			sentencia = (PreparedStatement) conexion.prepareStatement(sentenciaSql);
			
			sentencia.setInt(1, 2);
			sentencia.setString(2, "2Buey");
			sentencia.setString(3, "2Zaragoza");	
			sentencia.setString(4, "218-8-86");
			sentencia.setString(5, "2M");
			sentencia.setInt(6, 1);
			sentencia.setInt(7, 1);
			sentencia.executeUpdate();
			
		} finally { 
		if (sentencia !=null)
		
		try {
			sentencia.close();
		 
		} catch (SQLException sqle){
			
			sqle.printStackTrace();
		}
	}

	}

}
