public class Pajaro extends Animal {
    public Pajaro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Pío pío");
    }

    @Override
    public void desplazarse() {
        System.out.println(nombre + " se mueve: El pájaro vuela");
    }
}
