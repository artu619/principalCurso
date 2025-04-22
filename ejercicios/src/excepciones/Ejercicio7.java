package excepciones;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Bienvenido al programa. Te ayudaré a encontrar un carácter en la posición que elijas.");
			System.out.println("Introduce una pañabra: ");
			String palabra = scanner.nextLine();
			
			System.out.println("introduce una posicion: ");
			int posicion = scanner.nextInt();
			
			if (posicion < 0 || posicion >= palabra.length()){
				throw new IndexOutOfBoundsException("La posición está fuera del rango de la palabra.");
			}
			System.out.println("Carácter en la posición " + posicion + ": " + palabra.charAt(posicion));
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			 System.out.println("Error: " + e.getMessage());
			 e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error inesperado: " + e.getMessage());
		}finally {
			scanner.close();
			System.out.println("Gracias por usar el programa. ¡Que tengas un excelente día!");
		}

	}

}
