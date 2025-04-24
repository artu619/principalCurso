package biblioteca.model;

/**
 * Clase que representa un DVD en la biblioteca.
 * Hereda de RecursoBiblioteca.
 */
public class DVD extends RecursoBiblioteca {
	/**
     * Constructor de DVD.
     * @param id ID único del DVD (ej: D1).
     * @param titulo Título del DVD.
     */
    public DVD(String id, String titulo) {
        super(id, titulo);
    }
}
