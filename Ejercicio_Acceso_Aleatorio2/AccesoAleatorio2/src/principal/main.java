package principal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class main {
	private static Scanner lectura = new Scanner(System.in);

	private static String id = "";
	private static String titulo = "";
	private static String director = "";
	private static String duracion = "";
	private static String destinada = "";

	private static Pelicula nuevaPelicula = new Pelicula();

	private static RandomAccessFile archivo = null;

	// variables para poder escribir en el fichero;
	private static byte[] array = null;

	private static ByteArrayOutputStream escribir = null;
	private static ObjectOutputStream salida = null;

	// variables para poder leer el fichero:
	private static ByteArrayInputStream leer = null;
	private static ObjectInputStream entrada = null;

	private static boolean pedirDatos() {

		do {
			System.out.println("Introduce el ID: ");
			id = lectura.nextLine();

		} while (id.isEmpty());

		do {
			System.out.println("Introduce titulo: ");
			titulo = lectura.nextLine();

		} while (id.isEmpty());

		do {
			System.out.println("Introduce nombre director: ");
			director = lectura.nextLine();

		} while (id.isEmpty());

		do {
			System.out.println("Introduce duracion en minutos: ");
			duracion = lectura.nextLine();

		} while (id.isEmpty());

		do {
			System.out.println("Introduce destinada A para adultos o T para todos los publicos: ");
			destinada = lectura.nextLine();

		} while (id.isEmpty());

		// Pasamos los datos al objeto Pelicula:

		nuevaPelicula.setId(id);
		nuevaPelicula.setTitulo(titulo);
		nuevaPelicula.setDirector(director);
		nuevaPelicula.setDuracion(duracion);
		nuevaPelicula.setDestinada(destinada);

		return true;

	}

	private static void escribirEnArchivoAleatorio() {
		try {
			/*
			 * Creamos o abrimos un nuevo archivo. En este caso: El primer parámetro hace
			 * referencia a la ruta del archivo. El segundo parametro es el siguiente: - r -
			 * read. Solo lectura. - rw - read/wirte. Lectura y escritura
			 */
			archivo = new RandomAccessFile("Registrar_peliculas.txt", "rw");

			// Ponemos el puntero al final del archivo
			archivo.seek(archivo.length());

			// Serializamos el objeto Persona
			// Lo convertimos en una secuencia de bytees.
			escribir = new ByteArrayOutputStream();
			salida = new ObjectOutputStream(escribir);
			salida.writeObject(nuevaPelicula);

			// Cerramos el objeto.
			salida.close();

			// obtenemos los bytes del libro serializado
			array = escribir.toByteArray();

			// Escribimos los bytes en el archivo.
			archivo.write(array);

			// Cerramos el archivo
			archivo.close();
		} catch (Exception e) {
			System.out.println("No se puede escribir en el archivo" + e.getMessage());
		}

	}

	// Metodo para leer el archivo de acceso aleatorio
	private static void leerArchivoAleatorio() {
		try {
			/*
			 * Creamos o abrimos un nuevo archivo. Este archivo lo crearemos dentro de la
			 * carpeta src de nuestro proyecto. Además debemos tener en cuenta que el
			 * constructor de la clase RandomAccessFile recibe 2 parámetros: El primero hace
			 * referencia a la ruta del archivo. El segundo hace referencia al modo de
			 * apertura del archivo: - r - read. Solo lectura. - rw - read/wirte. Lectura y
			 * escritura
			 */
			archivo = new RandomAccessFile("Registrar_peliculas.txt", "r");

			// Nos posicionamos al principio del fichero
			archivo.seek(0);

			// Almacenamos los bytes del fichero en un array de bytes
			array = new byte[(int) archivo.length()];

			// Leemos todos los bytes del fichero
			archivo.readFully(array);

			// Convertimos ese array de bytes en un objeto.
			leer = new ByteArrayInputStream(array);
			entrada = new ObjectInputStream(leer);

			/*
			 * Hacemos una conversion de lo que lee el ObjectInputStream a un objeto de tipo
			 * Persona y lo almacenamos en la variable objeto nuevaPersona
			 */
			nuevaPelicula = (Pelicula) entrada.readObject(); 
			System.out.println(nuevaPelicula);
			// Cerramos el objeto ObjectInputStream
			entrada.close();

		} catch (Exception e) {
			System.out.println("No se puede leer el archivo" + e.getMessage());
		}
	}

	public static void programaAccesoAleatorio() throws FileNotFoundException {

		// creación del fichero:
		RandomAccessFile raf = null;
		try {
			File fichero = new File("ficheropeliculas.obj");
			raf = new RandomAccessFile(fichero, "rw");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Si a la hora de pedir los datos devuelve true, es que los datos se han
		 * introducido de forma correcta.
		 */
		if (pedirDatos()) {

			// Si los datos son correctos, intentamos...
			try {
				escribirEnArchivoAleatorio();
				// Escribimos en el archivo.
				// escribirEnArchivoAleatorio(nuevaPersona);
			} catch (Exception e) {
				System.out.println("No se ha podido registrar la persona.");
			}
		}

		/*
		 * Si se quiere leer el archivo, solo debemos llamarlo desde este método, de la
		 * siguiente manera
		 */
		leerArchivoAleatorio();

		/*
		 * Scanner sc = new Scanner(System.in); int opcion; do {
		 * 
		 * System.out.println("1.-Crear pelicula"); System.out.
		 * println("2. Sustitucion del valor del campo de una pelicula por otro");
		 * System.out.println("3. Listado de peliculas");
		 * System.out.println("5.- Salir"); opcion = sc.nextInt();
		 * 
		 * switch (opcion) { case 1: {
		 * 
		 * 
		 * // crearFichero();
		 * 
		 * break; } case 2: { // crearFichero2();
		 * 
		 * break; } case 3: { // leerFichero(); break; } case 4: { // sustituir();
		 * break; }
		 * 
		 * default: { System.out.println("Tienes que elegir una de las 4 opciones"); } }
		 * } while (opcion != 4);
		 * 
		 */

	}

}
