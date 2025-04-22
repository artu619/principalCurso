package excepciones;

import java.util.Scanner ;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
		 
		 try {
	            System.out.print("Introduce el primer número: ");
	            int num1 = scanner.nextInt();

	            System.out.print("Introduce el segundo número: ");
	            int num2 = scanner.nextInt();

	            // Intentamos hacer la división
	            int resultado = num1 / num2;

	            System.out.println("El resultado de la división es: " + resultado);
	        } catch (ArithmeticException e) {
	            // Esta excepción se lanza si se divide entre cero
	            System.err.println("Error: No se puede dividir entre cero.");
	            e.printStackTrace();
	        }

	        scanner.close();
	    }

	

}
