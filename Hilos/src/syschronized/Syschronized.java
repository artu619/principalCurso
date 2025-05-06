package syschronized;

public class Syschronized {
	private int valor = 0;

    public synchronized void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }

}
