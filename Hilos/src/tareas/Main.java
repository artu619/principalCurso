package tareas;

public class Main {

	public static void main(String[] args) {
		Thread hA = new Thread(new TareaA());
        Thread hB = new Thread(new TareaB());
        Thread hC = new Thread(new TareaC());
        
        
     // Modificación con join() para garantizar el orden de ejecución
        try {
            hA.start();
            hA.join();
            hB.start();
            hB.join();
            hC.start();
            hC.join();
            System.out.println("Todas las tareas han finalizado");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
