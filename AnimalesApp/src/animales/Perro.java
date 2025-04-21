package animales;

public class Perro extends Animal {

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + ": Guau guau");
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + ": El perro camina con cuatro patas");
    }
}