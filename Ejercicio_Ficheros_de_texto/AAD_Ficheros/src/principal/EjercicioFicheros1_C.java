package principal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjercicioFicheros1_C {

	public static void main(String[] args )throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		String nomFich = "text.txt";			
		try {

			out = new PrintWriter(new FileWriter(nomFich));
			
			// escribe los datos en el fichero			
			out.println("Tres tristes tigres");

		} finally {
			if (out != null)
				out.close(); // Cierra el fichero
		}
		

		Scanner in = new Scanner(new FileReader(nomFich)); //lectura de ficheros de texto con scanner

		
		while (in.hasNext()) {
		
									
			String texto = in.next(); 
			
			
			for(int i = 0; i < texto.length(); i++) {
				
				System.out.print(texto.charAt(i)); 
					
				}
				
		}
		
						
	
	}

}
