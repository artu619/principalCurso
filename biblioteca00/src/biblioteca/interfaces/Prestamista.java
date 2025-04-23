package biblioteca.interfaces;

import biblioteca.model.RecursoBiblioteca;
/**
 * Interfaz que define las operaciones que puede realizar cualquier entidad que pueda prestar recursos.
 * En este caso, los usuarios implementan esta interfaz.
 */

public interface Prestamista {
	/**
     * Método para prestar un recurso.
     * @param recurso El recurso que se desea prestar.
     */
	void prestarRecurso(RecursoBiblioteca recurso);
	 /**
     * Método para devolver un recurso.
     * @param recurso El recurso que se desea devolver.
     */
    void devolverRecurso(RecursoBiblioteca recurso);

}
