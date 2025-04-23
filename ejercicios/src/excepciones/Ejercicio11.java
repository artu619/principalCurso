package excepciones;

import java.util.Scanner;
import java.util.InputMismatchException;

class EdadNegativaException extends Exception {
    public EdadNegativaException(String mensaje) {
        super(mensaje);
    }
}


public class Ejercicio11 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        boolean condition = true;
       do {
		
    	   try {
    		   System.out.print("Introduce tu edad: ");
    		   int edad = scanner.nextInt();
    		   if (edad < 0) {
    			   throw new EdadNegativaException("La edad no puede ser negativa.");
    		   }
    		   System.out.println("Edad válida: " + edad);
    		   condition = false;
    	   }catch (InputMismatchException y) {
    		   // TODO: handle exception
    		   System.err.println("introduca un numero");
    		   scanner.nextLine();
    	   } catch (EdadNegativaException e) {
    		   System.out.println("Error: " + e.getMessage());
    	   }
	} while (condition);
        scanner.close();

	}

}
