package project.util;

public class Validator {
    public static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " no puede ser null");
        }
    }

    public static void checkPositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " debe ser positivo");
        }
    }
}