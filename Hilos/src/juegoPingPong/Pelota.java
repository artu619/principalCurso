package juegoPingPong;

public class Pelota {
	private boolean pingTurno = true;
	
    public synchronized void golpear(String jugador) {
        while ((jugador.equals("Ping") && !pingTurno) || (jugador.equals("Pong") && pingTurno)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println(jugador + " dice: " + (pingTurno ? "ping" : "pong"));
        pingTurno = !pingTurno;
        
        notify();
    }

}
