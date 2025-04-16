package coche;

public class Coche {
	 // Atributos
    int ventanas;
    int puertas;
    int ruedas;
    int velocidad;
    boolean circulando;
    boolean frenado;
    boolean enMarcha;
    
    // Constructor
    public Coche(int ventanas, int puertas, int ruedas) {
        this.ventanas = ventanas;
        this.puertas = puertas;
        this.ruedas = ruedas;
        this.velocidad = 0;
        this.circulando = false;
        this.frenado = true;
        this.enMarcha = false;
    }
    
    // Método arrancar
    public void arrancar() {
        if (!enMarcha) {
            enMarcha = true;
            frenado = false;
            System.out.println("El coche ha arrancado.");
        } else {
            System.out.println("El coche ya está en marcha.");
        }
    }
    
 // Método acelerar
    public void acelerar() {
        if (enMarcha) {
            velocidad += 5;
            circulando = true;
            frenado = false;
            System.out.println("Acelerando. Velocidad actual: " + velocidad + " km/h");
        } else {
            System.out.println("No puedes acelerar. El coche no está en marcha.");
        }
    }
    
 // Método decelerar
    public void decelerar() {
        if (enMarcha) {
            if (velocidad >= 5) {
                velocidad -= 5;
                System.out.println("Decelerando. Velocidad actual: " + velocidad + " km/h");
                if (velocidad == 0) {
                    circulando = false;
                    frenado = true;
                }
            } else {
                System.out.println("La velocidad ya es mínima o cero.");
            }
        } else {
            System.out.println("No puedes decelerar. El coche no está en marcha.");
        }
    }
    
 // Método frenar
    public void frenar() {
        if (velocidad > 0) {
            velocidad = 0;
            frenado = true;
            circulando = false;
            System.out.println("Coche frenado. Velocidad actual: 0 km/h");
        } else {
            System.out.println("El coche ya está detenido.");
        }
    }
    
    @Override
    public String toString() {
        return "Estado del Coche:\n" +
               "Ventanas: " + ventanas + "\n" +
               "Puertas: " + puertas + "\n" +
               "Ruedas: " + ruedas + "\n" +
               "Velocidad: " + velocidad + " km/h\n" +
               "En marcha: " + enMarcha + "\n" +
               "Circulando: " + circulando + "\n" +
               "Frenado: " + frenado;
    }

}
