package project.util;

import java.util.List;
import java.util.DoubleSummaryStatistics;
/**
 * Clase utilitaria para analizar tiempos de vuelta en una carrera.
 * Proporciona métodos para obtener estadísticas y calcular la desviación estándar.
 */

public class LapTimeAnalyzer {
	/**
     * Analiza una lista de tiempos de vuelta y obtiene estadísticas generales.
     * @param times Lista de tiempos de vuelta registrados.
     * @return Objeto DoubleSummaryStatistics con valores como promedio, mínimo y máximo.
     */

    public static DoubleSummaryStatistics analyze(List<Double> times) {
        return times.stream()
                    .mapToDouble(Double::doubleValue)
                    .summaryStatistics();
    }
    /**
     * Calcula la desviación estándar de los tiempos de vuelta.
     * @param times Lista de tiempos de vuelta registrados.
     * @return Valor de la desviación estándar de los tiempos de vuelta.
     */

    public static double stdDev(List<Double> times) {
        double avg = analyze(times).getAverage();
        return Math.sqrt(
            times.stream()
                 .mapToDouble(t -> (t - avg) * (t - avg))
                 .average()
                 .orElse(0)
        );
    }
}