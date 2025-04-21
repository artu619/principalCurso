public class Pez extends Animal {
    public Pez(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Glub glub");
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + " se mueve: El pez nada");
    }
}
