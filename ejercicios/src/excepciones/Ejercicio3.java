package excepciones;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		 String[] nombres = {"Ana", "Luis", "María", "Carlos"};
		 
		try {
			System.out.print("Introduce un numero del 0 al 3 para ver el nombre: ");
			int indice = scanner.nextInt();
			
			System.out.println("el nombre en la posicion " + indice + " es: " + nombres[indice] );
			
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.err.println("Error: El número debe estar entre 0 y 3.");
			e.printStackTrace();
		}
		
		scanner.close();
		 

	}

}
