package tienda;
import java.util.LinkedList;
import java.util.List;

public class Buffer {
	private final List<Integer> datos = new LinkedList<>();
    private final int capacidad = 2;
    
    public synchronized void producir(int x) throws InterruptedException {
        while (datos.size() == capacidad) {
            wait(); // Espera mientras el buffer esté lleno
        }
        datos.add(x);
        System.out.println("Producido: " + x);
        notifyAll(); // Notifica a los consumidores que hay nuevo dato disponible
    }
    
    public synchronized int consumir() throws InterruptedException {
        while (datos.isEmpty()) {
            wait();// Espera mientras el buffer esté vacío
        }
        int x = datos.remove(0);
        System.out.println("Consumido: " + x);
        notifyAll();// Notifica al productor que hay espacio disponible
        return x;
    }

}
