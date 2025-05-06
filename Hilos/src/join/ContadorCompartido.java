package join;

public class ContadorCompartido {
	
	private int valor = 0;

    public synchronized void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
    
}

class Incrementador implements Runnable {
    private final ContadorCompartido cont;

    public Incrementador(ContadorCompartido cont) {
        this.cont = cont;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            cont.incrementar();
        }
        System.out.println(Thread.currentThread().getName() + " ha terminado.");
    }

}
