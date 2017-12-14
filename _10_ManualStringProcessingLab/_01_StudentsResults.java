package _10_ManualStringProcessingLab;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01_StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        String input = scanner.nextLine();


        String[] firstSplit = input.split(" - ");
        String currentName = firstSplit[0];
        String resultsString = firstSplit[1];

        List<Double> currentResults = Stream.of(resultsString.split(", ")).map(Double::valueOf).collect(Collectors.toList());
        double sum = 0;
        for (Double result : currentResults) {
            sum += result;
        }
        double average = sum/3;
        currentResults.add(average);
        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                currentName, currentResults.get(0), currentResults.get(1), currentResults.get(2), currentResults.get(3)));

    }
}
