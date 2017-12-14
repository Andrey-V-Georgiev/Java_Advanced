package _10_ManualStringProcessingLab;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _00_Tests {
    public static void main(String[] args) {

        String str = "1, 2, 3";

        List<Double> currentResults = Stream.of(str.split(", ")).map(Double::valueOf).collect(Collectors.toList());
        for (Double currentResult : currentResults) {
            System.out.println(currentResult);
        }
    }
}
