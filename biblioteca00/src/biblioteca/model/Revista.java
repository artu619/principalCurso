package biblioteca.model;

/**
 * Clase que representa una revista como recurso dentro de la biblioteca.
 * 
 * Esta clase extiende {@link RecursoBiblioteca} e implementa las características
 * específicas de un recurso del tipo revista.
 */
public class Revista extends RecursoBiblioteca {

    /**
     * Crea una nueva revista con el ID y título especificados.
     *
     * @param id     ID único de la revista (por ejemplo, "R1").
     * @param titulo Título de la revista.
     */
    public Revista(String id, String titulo) {
        super(id, titulo);
    }
}