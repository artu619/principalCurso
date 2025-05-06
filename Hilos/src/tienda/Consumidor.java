package tienda;

public class Consumidor implements Runnable {
	private final Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		 this.buffer = buffer;
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				buffer.consumir();
				Thread.sleep (500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			
		}

	}

}
