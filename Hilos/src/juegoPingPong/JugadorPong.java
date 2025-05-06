package juegoPingPong;

public class JugadorPong implements Runnable {
	private final Pelota pelota;
	
	public JugadorPong(Pelota pelota) {
        this.pelota = pelota;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            pelota.golpear("Pong");
        }
    }

}
