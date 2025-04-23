package project.util;

/**
 * Clase utilitaria para validaciones comunes en la aplicación.
 * Proporciona métodos para verificar valores nulos y números positivos.
 */

public class Validator {
	/**
     * Verifica que un objeto no sea nulo.
     * @param obj Objeto a validar.
     * @param name Nombre del parámetro (para mensajes de error descriptivos).
     * @throws IllegalArgumentException si el objeto es nulo.
     */
    public static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " no puede ser null");
        }
    }
    /**
     * Verifica que un valor numérico sea positivo.
     * @param value Valor numérico a validar.
     * @param name Nombre del parámetro (para mensajes de error descriptivos).
     * @throws IllegalArgumentException si el valor es menor o igual a cero.
     */

    public static void checkPositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " debe ser positivo");
        }
    }
}