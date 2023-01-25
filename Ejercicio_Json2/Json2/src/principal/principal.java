package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class principal {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		// LEES EL ARCHIVO JSON:
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("generated.json")) {

			Object obj = jsonParser.parse(reader);
			// System.out.println(obj);

			// COGES EL ARCHIVO Y LO HACES OBJETO TIPO ARRAY JSON, PARA RECORRERLO COMO UN
			// ARRAY DE OBJETOS

			JSONArray json = (JSONArray) obj;

			System.out.println("----EJERCICIO 1:");
			for (int i = 0; i < json.size(); i++) {

				JSONObject object = (JSONObject) json.get(i);

				// DE ESTA MANERA VAS COGIENDO LOS GETS DE CADA MALDITO OBJETO

				String eyeColor = object.get("eyeColor").toString();
				String nombre = object.get("name").toString();

				if (eyeColor.contentEquals("brown")) {

					System.out.println(nombre + "Tiene los ojos marrones");
				}

			}
			System.out.println("");
			System.out.println("----EJERCICIO 2:");
			for (int i = 0; i < json.size(); i++) {

				JSONObject object = (JSONObject) json.get(i);
				String nombre = object.get("name").toString();
				String gender = object.get("gender").toString();
				String friends = object.get("friends").toString();
				String name = object.get("name").toString();
				// para este ejercicio igual tengo que recorrer arrays, pq me pide datos q está
				// dentro de []

				if (gender.contentEquals("male")) {

					System.out.println("NOMBRE MALE " + nombre + " tiene el amigo " + name);

				}

			}
			System.out.println("");
			System.out.println("----EJERCICIO 3:");

			for (int i = 0; i < json.size(); i++) {

				JSONObject object = (JSONObject) json.get(i);
				String id = object.get("_id").toString();

				String fruta = object.get("favoriteFruit").toString();
				// para este ejercicio igual tengo que recorrer arrays, pq me pide datos q está
				// dentro de []

				if (fruta.contentEquals("apple")) {

					System.out.println("Al id " + id + " le gusta la manzana.");

				}

				else if (fruta.contentEquals("strawberry")) {

					System.out.println("Al id " + id + " le gusta la fresa. ");
				}

			}

			System.out.println("");
			System.out.println("----EJERCICIO 4:");

			for (int i = 0; i < json.size(); i++) {

				JSONObject object = (JSONObject) json.get(i);
				String nombre = object.get("name").toString();
				String phone = object.get("phone").toString();

				String fruta = object.get("favoriteFruit").toString();
				// para este ejercicio igual tengo que recorrer arrays, pq me pide datos q está
				// dentro de []

				if (phone.contains("8") || phone.contains("6")) {

					System.out.println("El telefono de " + nombre + " contiene un 6 o un 8.");

				}

			}

			System.out.println("");
			System.out.println("----EJERCICIO 5:");

			for (int i = 0; i < json.size(); i++) {

				JSONObject object = (JSONObject) json.get(i);

				String id = object.get("_id").toString();
				String edad = object.get("age").toString();
				int edadint = Integer.parseInt(edad);

				String genero = object.get("gender").toString();

				if (genero.contentEquals("female")) {

					if (edadint > 30) {

						System.out.println("La edad del id " + id + "es igual o mayor que 30. ");

					}

				}

			}

			System.out.println("");
			System.out.println("----EJERCICIO 6:");

			for (int i = 0; i < json.size(); i++) {

				JSONObject object = (JSONObject) json.get(i);

				String name = object.get("name").toString();
				String about = object.get("about").toString();

				if (about.contains("bor")) {

					System.out.println("El nombre " + name + " contiene bor en su about. ");

				}

			}

		}

	}

}
