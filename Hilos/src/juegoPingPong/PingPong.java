package juegoPingPong;

public class PingPong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pelota pelota = new Pelota();
		Thread jugadorPing = new Thread(new JugadorPing(pelota));
        Thread jugadorPong = new Thread(new JugadorPong(pelota));
        
        jugadorPing.start();
        jugadorPong.start();
	}

}
