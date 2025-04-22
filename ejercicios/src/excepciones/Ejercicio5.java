package excepciones;
import java.util.Scanner;


public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("introduce un numero: ");
		String entrada = scanner.nextLine();
		
		try {
			int numero = Integer.parseInt(entrada);
			System.out.println("Has introducido el número: " + numero );
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.err.println("Erorr: No has introducido un numero valido");
		}
		
		scanner.close();

	}

}
