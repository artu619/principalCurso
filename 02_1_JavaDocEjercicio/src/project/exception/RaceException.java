package project.exception;

/**
 * Excepción personalizada para manejar errores específicos de la carrera.
 * Extiende RuntimeException para permitir su uso sin necesidad de declaración en métodos.
 */

public class RaceException extends RuntimeException {
	/**
     * Constructor que recibe un mensaje de error y lo pasa a la superclase.
     * @param message Mensaje descriptivo del error ocurrido.
     */
    public RaceException(String message) {
        super(message);
    }
}