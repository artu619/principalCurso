package biblioteca.interfaces;

import biblioteca.model.RecursoBiblioteca;

/**
 * Interfaz que define las operaciones que puede realizar cualquier entidad que pueda prestar recursos.
 * 
 * Esta interfaz es implementada por los usuarios u otras entidades capaces de gestionar el préstamo y devolución
 * de recursos de la biblioteca.
 */
public interface Prestamista {

    /**
     * Presta un recurso de la biblioteca.
     *
     * @param recurso El recurso que se desea prestar.
     */
    void prestarRecurso(RecursoBiblioteca recurso);

    /**
     * Devuelve un recurso previamente prestado.
     *
     * @param recurso El recurso que se desea devolver.
     */
    void devolverRecurso(RecursoBiblioteca recurso);
}

