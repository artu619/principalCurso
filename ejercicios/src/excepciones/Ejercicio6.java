package excepciones;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Introduce el temaño del array: ");
			int size = scanner.nextInt();
			
			if (size < 0) {
				throw new IllegalArgumentException("El tamaño del array no puede ser negativo.");
				
			}
			int[] array = new int[size];
			System.out.println("Array creado Tamaño: " + size);
			
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			 System.out.println("Error: " + e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error inesperado: " + e.getMessage());
		}finally {
			scanner.close();
		}

	}

}
