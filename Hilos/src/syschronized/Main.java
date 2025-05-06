package syschronized;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Syschronized contador = new Syschronized();
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    contador.incrementar();
                }
                System.out.println(Thread.currentThread().getName() + " ha terminado.");
            }, "Hilo-" + (i + 1));
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final del contador: " + contador.getValor());
    }


	}


