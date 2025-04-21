package figuras;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<>();

        figuras.add(new Rectangulo(5.0, 3.0));
        figuras.add(new Circulo(4.0));
        figuras.add(new Rectangulo(2.5, 6.0));
        figuras.add(new Circulo(2.2));

        for (Figura figura : figuras) {
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            System.out.println();
        }
    }
}
