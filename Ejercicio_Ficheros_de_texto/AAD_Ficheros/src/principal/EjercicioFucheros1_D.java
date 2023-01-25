package principal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjercicioFucheros1_D {

	public static void main(String[] args) throws IOException {
	
		PrintWriter out = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre de fichero: ");

		String nomFich = sc.nextLine();

		try {

			out = new PrintWriter(new FileWriter(nomFich));
			
			// escribe los datos en el fichero
			System.out.println("Introduce el contenido del fichero ");
			out.println(sc.nextLine());

		} finally {
			if (out != null)
				out.close(); // Cierra el fichero
		}

		Scanner in = new Scanner(new FileReader(nomFich)); // lectura de ficheros de texto con scanner
		String frasefinal = "";

		while (in.hasNext()) {

			String texto = in.nextLine();

			for (int i = 0; i < texto.length(); i++) {

				if (Character.isUpperCase(texto.charAt(i))) {
					char x = texto.charAt(i); //para añadirlo a frasefinal tengo que meterlo primero en una variable nueva
					char y = Character.toLowerCase(x);
				
					frasefinal = frasefinal + y;
				}
				
				else if (Character.isLowerCase(texto.charAt(i))) {
					char x = texto.charAt(i); //para añadirlo a frasefinal tengo que meterlo primero en una variable nueva
				
					char y = Character.toUpperCase(x);
					frasefinal = frasefinal + y;
					
						
				}
				else {
					
					frasefinal = frasefinal+ texto.charAt(i); 
				}

			}

		}
System.out.println(frasefinal);
	}

}
