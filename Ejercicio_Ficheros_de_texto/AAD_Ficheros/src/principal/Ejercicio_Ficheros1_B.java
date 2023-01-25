package principal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio_Ficheros1_B {

	public static void main(String[] args)  throws IOException {
		
		//pagina 28 del PDF "ficheros"

				PrintWriter out = null;
				String nomFich = "palabras.txt";			
				try {

					out = new PrintWriter(new FileWriter(nomFich));
					// escribe los datos en el fichero
					
					out.println("Palabra1 " + "Palabra2 " + "Palabra3 " + "Palabra4 " + "Palabra5 ");

				} finally {
					if (out != null)
						out.close(); // Cierra el fichero
				}
				
	
				Scanner in = new Scanner(new FileReader(nomFich)); //lectura de ficheros de texto con scanner
				
				
				
				
				Scanner sc = new Scanner(System.in);	
				System.out.println("Introduce una letra: ");
				
				char letra  = sc.next().charAt(0); //me faltaria pasarlo a minuscula 
				int contador = 0; 
				
				while (in.hasNext()) {
				
											
					String texto = in.next(); 
					texto.toLowerCase(); //por si se mete en mayuscula 
					
					System.out.println(texto);
					int length = texto.length();
					
					for(int i = 0; i < texto.length(); i++) {
						
						if (texto.charAt(i) == letra ) {
							 contador++; 
							
						}
						
					}
				
				}				
			
				System.out.println( contador);
				
				
				
				

			}

		}