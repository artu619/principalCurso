package biblioteca.model;

/**
 * Clase que representa un libro en la biblioteca.
 * Hereda de RecursoBiblioteca.
 */

public class Libro extends RecursoBiblioteca {
	/**
     * Constructor de Libro.
     * @param id ID único del libro (ej: L1).
     * @param titulo Título del libro.
     */
	public Libro(String id, String titulo) {
		super(id, titulo);
    }

}
