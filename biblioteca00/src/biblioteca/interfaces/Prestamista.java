package biblioteca.interfaces;

import biblioteca.model.RecursoBiblioteca;

public interface Prestamista {
	void prestarRecurso(RecursoBiblioteca recurso);
    void devolverRecurso(RecursoBiblioteca recurso);

}
