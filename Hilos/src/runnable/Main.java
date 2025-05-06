package runnable;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread contador = new Thread(new CuentaRegresiva(5), "Contador");
        contador.start();

	}

}
