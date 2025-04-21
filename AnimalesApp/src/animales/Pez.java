package animales;

public class Pez extends Animal {

    public Pez(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + ": Glub glub");
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + ": El pez nada");
    }
}