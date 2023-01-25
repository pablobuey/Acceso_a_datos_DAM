package principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void ejemploEscribeFichTexto(String nomFich, int i, double x, String str) throws IOException {
		PrintWriter out = null;
		try {
			// Abre el fichero
			out = new PrintWriter(new FileWriter(nomFich));
			// escribe los datos en el fichero
			out.println("Entero: " + i + " Real: " + x);
			out.println("String: " + str);
		} finally {
			if (out != null)
				out.close(); // Cierra el fichero
		}

	}

}