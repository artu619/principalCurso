package sleep;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread hiloPesado = new Thread(new TareaPesada(), "Pesado");
		hiloPesado.start();
		
		try {
            Thread.sleep(3000); // Espera 3 segundos antes de interrumpir el hilo
            hiloPesado.interrupt(); // Interrumpe la tarea
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

	}

}
