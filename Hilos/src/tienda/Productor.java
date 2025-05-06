package tienda;

public class Productor implements Runnable {
	private final Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int valor = 1;
		while (true) {
			try {
				buffer.producir(valor++);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO: handle exception
				Thread.currentThread().interrupt();
				break;
			}
			
		}

	}

}
