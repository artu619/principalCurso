package programa;
public class CadenaUtils {
    /** Invierte el contenido de la cadena; si es null devuelve cadena vacía */
    public String invertir(String input) {
        if (input == null) return "";
        return new StringBuilder(input).reverse().toString();
    }
}