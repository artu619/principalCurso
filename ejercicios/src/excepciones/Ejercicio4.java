package excepciones;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto = null;
		
		try {
			System.out.println("La longitud del texto es: " + texto.length());
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println("error: Intentas acceder a la longitud de un string que es null.");
		}

	}

}
