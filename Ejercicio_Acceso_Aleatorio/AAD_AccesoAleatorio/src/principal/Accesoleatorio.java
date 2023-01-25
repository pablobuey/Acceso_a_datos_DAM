package principal;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;
 
 
public class Accesoleatorio {
 
    public static void programaAccesoAleatorio(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
 
            System.out.println("1.-Añadir numero al principio del fichero");
            System.out.println("2. Anadir numero al final del fichero");
            System.out.println("3. Mostrar el fichero");                    
            System.out.println("4. Sustituir un numero del fichero por un número nuevo");                        
            System.out.println("5.- Salir del programa");
            opcion = sc.nextInt();
 
            switch (opcion) {
                case 1: {
                    crearFichero();
 
                    break;
                }
                case 2: {
                    crearFichero2();
 
                    break;
                }
                case 3: {
                    leerFichero();
                    break;
                }
                case 4: {
                    sustituir();
                    break;
                }
                case 5: {
                    System.out.println("Adios!");
                    break;
                }
                default: {
                    System.out.println("Tienes que elegir una de las 5 opciones");
                }
            }
        } while (opcion != 5);
 
    }
 
    public static void crearFichero() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File("fichero.obj");
            raf = new RandomAccessFile(fichero, "rw");
            añadirNumenosAlPrincipio(raf);
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
 
    public static void añadirNumenosAlPrincipio(RandomAccessFile raf) throws Exception {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.println("Introduce un numero para añadir al principio del fichero ");
        numero = sc.nextDouble();
        raf.seek(0);
        raf.writeDouble(numero);
 
    }
 
    public static void crearFichero2() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File("fichero.obj");
            raf = new RandomAccessFile(fichero, "rw");
            añadirNumenosAlFinal(raf);
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
 
    public static void añadirNumenosAlFinal(RandomAccessFile raf) throws Exception {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.println("Introduce un numero para añadir al final del fichero: ");
        numero = sc.nextDouble();
        raf.seek(raf.length());
        raf.writeDouble(numero);
 
    }
 
    public static void leerFichero() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File("fichero.obj");
            raf = new RandomAccessFile(fichero, "r");
            mostrarFichero(raf);
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
 
    public static void mostrarFichero(RandomAccessFile raf) throws Exception {
        double numero;
        raf.seek(0);
        while (true) {
            numero = raf.readDouble();
            System.out.println(numero);
        }
    }
 
    public static void sustituir() {
        Scanner sc = new Scanner(System.in);
        double sustituir, nuevo, numero;
        int i = 0;
 
        RandomAccessFile raf = null;
 
        try {
            File fichero = new File("fichero.obj");
            raf = new RandomAccessFile(fichero, "rw");
            raf.seek(0);
 
            System.out.println("Introduce el valor que desea sustituir");
            sustituir = sc.nextDouble();
 
            System.out.println("Introduce el nuevo valor");
            nuevo = sc.nextDouble();
 
            while (true) {
                numero = raf.readDouble();
                if (numero == sustituir) {
                    System.out.println("Encontrado en la posicion " + i);
                    raf.seek(i * 8);
                    raf.writeDouble(nuevo);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
 
    }
 
    public static void main(String[] args) {
    	
        programaAccesoAleatorio();
    }
 
}