import java.util.ArrayList;

public class Enunciado {
    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();

        animales.add(new Perro("Firulais"));
        animales.add(new Pajaro("Piolín"));
        animales.add(new Pez("Nemo"));

        for (Animal animal : animales) {
            animal.hacerSonido();
            animal.desplazarse();
            System.out.println();
        }
    }
}
