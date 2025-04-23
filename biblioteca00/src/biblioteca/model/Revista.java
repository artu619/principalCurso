package biblioteca.model;

/**
 * Clase que representa una revista en la biblioteca.
 * Hereda de RecursoBiblioteca.
 */

public class Revista extends RecursoBiblioteca {
	/**
     * Constructor de Revista.
     * @param id ID único de la revista (ej: R1).
     * @param titulo Título de la revista.
     */
    public Revista(String id, String titulo) {
    	super(id, titulo);
    }

}
