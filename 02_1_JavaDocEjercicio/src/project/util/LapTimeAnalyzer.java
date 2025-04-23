package project.util;

import java.util.List;
import java.util.DoubleSummaryStatistics;

public class LapTimeAnalyzer {

    public static DoubleSummaryStatistics analyze(List<Double> times) {
        return times.stream()
                    .mapToDouble(Double::doubleValue)
                    .summaryStatistics();
    }

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