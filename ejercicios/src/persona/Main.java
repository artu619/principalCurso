package persona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear un objeto de la clase Persona
        Persona persona1 = new Persona("Carlos", 28, 72.5);

        // Mostrar los atributos directamente desde el main
        System.out.println("Nombre: " + persona1.nombre);
        System.out.println("Edad: " + persona1.edad + " años");
        System.out.println("Peso: " + persona1.peso + " kg");
        
        Persona persona2 = new Persona("antonio", 50, 60.0);
        System.out.println("Nombre: " + persona2.nombre);
        System.out.println("edad: " + persona2.edad + " años");
        System.out.println("peso: " + persona2.peso + " kg");
        
        
    
		

	}

}
