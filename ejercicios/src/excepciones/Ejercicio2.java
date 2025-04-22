package excepciones;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		try {
            System.out.print("Introduce tu edad: ");
            int edad = scanner.nextInt();

            System.out.println("Tu edad es: " + edad);
        } catch (InputMismatchException e) {
            // Esta excepción ocurre si el usuario introduce letras o símbolos en vez de números
            System.err.println("Error: Por favor, introduce un número entero válido para la edad.");
        }

        scanner.close();

	}

}
