package tienda;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Buffer buffer = new Buffer();
        
        Thread productor = new Thread(new Productor(buffer));
        Thread consumidor1 = new Thread(new Consumidor(buffer));
        Thread consumidor2 = new Thread(new Consumidor(buffer));
        
        productor.start();
        consumidor1.start();
        consumidor2.start();

	}

}
