package excepciones;

import java.util.Scanner;

public class Ejercicio8 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            System.out.print("Introduce una temperatura en grados Celsius: ");
	            double temperatura = scanner.nextDouble();

	            if (temperatura < -273) {
	                throw new IllegalArgumentException("Temperatura imposible: inferior al cero absoluto.");
	            }

	            System.out.println("Temperatura ingresada: " + temperatura + " °C");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.println("Error inesperado: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	

}
