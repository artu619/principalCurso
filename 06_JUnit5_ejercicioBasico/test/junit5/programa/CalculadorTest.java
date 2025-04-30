package junit5.programa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import programa.Calculadora;

public class CalculadorTest {
	private Calculadora calculadora;
	
	@BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }
	
	 @AfterEach
	    void tearDown() {
	        calculadora = null;
	 }
	 
	 @Test
	    void sumar_DosNumerosPositivos_ResultadoCorrecto() {
	        assertEquals(5, calculadora.sumar(2, 3));
	 }

	 @Test
	 void restar_DosNumerosPositivos_ResultadoCorrecto() {
	        assertEquals(1, calculadora.restar(3, 2));
	 }

}
