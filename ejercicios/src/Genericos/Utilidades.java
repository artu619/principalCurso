package Genericos;

import java.util.List;

public class Utilidades {
	 public static <E extends Comparable<E>> E maximo(List<E> lista) {
		 if (lista == null || lista.isEmpty()) {
	            throw new IllegalArgumentException("La lista no puede estar vacía.");
	     }
		 E max = lista.get(0);
	        for (E elemento : lista) {
	            if (elemento.compareTo(max) > 0) {
	                max = elemento;
	            }
	        }
	        return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = List.of(5, 12, 3, 8);
        System.out.println(maximo(nums));  // 12

        List<String> strs = List.of("zorro", "abeja", "mono");
        System.out.println(maximo(strs));  // zorro

	}

}
