package principal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjercicioFicheros1_A {

	public static void main(String[] args) throws IOException {
		
		//Ejercicio que crea un fichero y escribe 10 números en él.
        //Anotación para mi: pagina 28 del PDF "ficheros"

		PrintWriter out = null;
		String nomFich = "numeros.txt";
		int i = 0;
		try {

			out = new PrintWriter(new FileWriter(nomFich));
			
			// escribe los datos en el fichero
			for (i = 0; i < 10; i++) {
				out.println(i);
			}

		} finally {
			if (out != null)
				out.close(); // Cierra el fichero
		}

		boolean impar = true;
		int suma = 0;
		
		
		Scanner in = new Scanner(new FileReader(nomFich));
		while (in.hasNext()) {
			int numero = in.nextInt();

			if (impar) { //Al poner una variable booleana en la condicion del if, es como si pusieras "si impar = true"
				suma += numero;
				impar = false;

			} else {
				impar = true;
			}

		}
		
		System.out.println("La suma es: "+ suma); 
		
		

	}

}