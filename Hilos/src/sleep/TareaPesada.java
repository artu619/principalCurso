package sleep;

public class TareaPesada implements Runnable {
	 @Override
	    public void run() {
	        for (int i = 1; i <= 20; i++) {
	            try {
	                Thread.sleep(1000); // Pausa de 1 segundo
	                System.out.println("Iteración " + i + " completada");
	            } catch (InterruptedException e) {
	                System.out.println("Tarea interrumpida en iteración " + i);
	                return; // Termina la ejecución tras la interrupción
	            }
	        }
	    }
	
}
