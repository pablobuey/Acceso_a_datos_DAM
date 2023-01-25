package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonPersona {
	
	//!!!! EL RESULTADO SALE DESORDENADO PERO ES NORMAL

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		// CREACIÓN DEL OBJETO PERSONA
		JSONObject persona = new JSONObject();

		// CREACIÓN DE ARRAY PARA LOS LENGUAJES
		JSONArray arrayLenguajes = new JSONArray();

		// CREACIÓN DEL OBJETO PARA RANGO PROFESIONAL
		JSONObject rangoProfesional = new JSONObject();

		rangoProfesional.put("aniosDeExperiencia", 12);
		rangoProfesional.put("nivel", "Senior");

		persona.put("nombre", "Jonh Doe");
		persona.put("profesion", "Programador");
		persona.put("edad", "25");

		arrayLenguajes.add("PHP");
		arrayLenguajes.add("Javascript");
		arrayLenguajes.add("Dart");

		persona.put("lenguajes", arrayLenguajes);
		persona.put("disponibilidadParaViajar", true);
		persona.put("rangoProfesional", rangoProfesional);

		// ESCRITURA

		try (FileWriter file = new FileWriter("persona.json")) {
			// We can write any JSONArray or JSONObject instance to the file
			file.write(persona.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// LECTURA

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("persona.json")) {

			Object obj = jsonParser.parse(reader);

			System.out.println(obj);

		}

	}

}
