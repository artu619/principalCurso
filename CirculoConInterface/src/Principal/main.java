package Principal;
import Figuras.Circulo;
import Figuras.Figura;
public class main {
	 public static void main(String[] args) {
	        Figura circulo = new Circulo(5.0);

	        System.out.println("Área: " + circulo.calcularArea());
	        System.out.println("Perímetro: " + circulo.calcularPerimetro());
	    }

}
