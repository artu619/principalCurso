package biblioteca.model;

/**
 * Clase que representa un libro como recurso dentro de la biblioteca.
 * 
 * Esta clase extiende {@link RecursoBiblioteca} e implementa las características
 * específicas de un recurso del tipo libro.
 */
public class Libro extends RecursoBiblioteca {

    /**
     * Crea un nuevo libro con el ID y título especificados.
     *
     * @param id     ID único del libro (por ejemplo, "L1").
     * @param titulo Título del libro.
     */
    public Libro(String id, String titulo) {
        super(id, titulo);
    }
}
