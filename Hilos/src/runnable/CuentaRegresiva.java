package runnable;

public class CuentaRegresiva implements Runnable  {
	private int n;
	
	public CuentaRegresiva(int n) {
        this.n = n;
    }
	
	
    public void run() {
        try {
            for (int i = n; i >= 0; i--) {
                System.out.println(i);
                Thread.sleep(500); // Espera 500 milisegundos entre cada número
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }
    }
	

}
