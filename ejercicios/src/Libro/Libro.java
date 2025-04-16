package Libro;

public class Libro {
	private String titulo;
    private String autor;
    private int añoPublicacion;

    // Constructor
    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }

    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Publicación: " + añoPublicacion;
    }

}
