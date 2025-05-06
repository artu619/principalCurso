package juegoPingPong;

public class JugadorPing implements Runnable {
	private final Pelota pelota;
	
	public JugadorPing(Pelota pelota) {
        this.pelota = pelota;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            pelota.golpear("Ping");
        }
    }

}
