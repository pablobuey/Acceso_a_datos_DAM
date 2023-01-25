package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.SQLException;



public class Conectar {
	
	//Estos son los datos de mi BBDD. Para hacer la conexión a la tuya cambia los valores.
	
	static String bd = "jardineria";
	static String login ="root";
	static String password ="";
	static String url = "jdbc:mysql://localhost/"+bd;
	
    public Connection conexionUrlLogPass = null;
			
			
		
	public void Conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexionUrlLogPass = DriverManager.getConnection(url, login, password);
			System.out.println("(Conexion a "+ bd + " realizada con exito.)");
			System.out.println("");

		} catch (ClassNotFoundException e) {
			
			//Si la conexión falla saltará este mensaje.
			e.printStackTrace();
			System.out.println("conexion falla");
		}

		catch (SQLException sqle) {

			sqle.printStackTrace();
		}
		
		
		
	}
	

}
