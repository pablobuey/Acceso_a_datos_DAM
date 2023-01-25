package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class FicheroProperties {

	public static void main(String[] args) throws IOException {
		int opcion = 0;
		while (opcion != 4) {

			System.out.println("Elije una opcion: ");
			System.out.println("1-Creacion fichero propiedades.");
			System.out.println("2-Lectura fichero propiedades.");
			System.out.println("3-Busqueda del valor de una determinada propiedad.");
			System.out.println("4-Salir.");

			Scanner sc = new Scanner(System.in);

			opcion = sc.nextInt();

			Properties archivoProp = new Properties();

			switch (opcion) {

			case 1:

				try {

					File archivo = new File("config.properties");
					FileOutputStream fos = new FileOutputStream(archivo, true);

					archivoProp.setProperty("USUARIO", "PABLO");
					archivoProp.setProperty("CONTRASEÑA", "PABLOPASS");

					archivoProp.store(fos, "Archivo de configuración");

				} catch (IOException ex) {
					System.out.println("Error de escritura: " + ex.getMessage());

				}

				break;
			case 2:
				try {
					archivoProp.load(new FileInputStream(new File("config.properties")));

					System.out.println(archivoProp.get("USUARIO"));
					System.out.println(archivoProp.get("CONTRASEÑA"));

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

				break;
			case 3:

				System.out.println("introduce propiedad: 1-USUARIO 2-CONTRASEÑA ");
				int propiedad = sc.nextInt();

				switch (propiedad) {
				case 1:

					try {
						archivoProp.load(new FileInputStream(new File("config.properties")));

						System.out.println(archivoProp.get("USUARIO"));

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					break;

				case 2:
					try {
						archivoProp.load(new FileInputStream(new File("config.properties")));

						System.out.println(archivoProp.get("CONTRASEÑA"));

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}

				}

				break;

			}
		}

		// TODO Auto-generated method stub
System.out.println("Saliste del programa."); 
	}

}
