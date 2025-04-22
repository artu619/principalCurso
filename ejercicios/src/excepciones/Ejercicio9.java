package excepciones;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String filePath = "E:/descargas/prueba.txt"; // Cambia esto por la ruta de tu archivo

	        try (FileReader fileReader = new FileReader(filePath);
	             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

	            String linea;
	            while ((linea = bufferedReader.readLine()) != null) {
	                System.out.println(linea);
	            }

	        } catch (FileNotFoundException e) {
	            System.out.println("Error: El archivo '" + filePath + "' no existe.");
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	        }
	    }

	}


