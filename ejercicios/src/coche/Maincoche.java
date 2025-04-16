package coche;

public class Maincoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coche miCoche = new Coche(4, 5, 4);

        miCoche.arrancar();
        miCoche.acelerar();
        miCoche.acelerar();
        miCoche.decelerar();
        miCoche.frenar();

        // Mostrar estado completo del coche
        System.out.println();
        System.out.println(miCoche); // Aquí se invoca toString() automáticamente
    

	}

}
