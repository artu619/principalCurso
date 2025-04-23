package excepciones;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el nombre del archivo: ");
		String filepath = scanner.nextLine();
		
		try (FileReader fileReader = new FileReader(filepath);
				BufferedReader bufferedReader = new BufferedReader(fileReader)){
			
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("El archivo: `" + filepath + "` no exite.");
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al leer el archivo: `" + e.getMessage());
		}finally {
			scanner.close();
		}
		

	}

}
