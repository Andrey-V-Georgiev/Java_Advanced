package _10_FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> wordsList = Stream.of(bf.readLine().split(" ")).collect(Collectors.toList());
        List<String> results = new ArrayList<>();
        Predicate<String> checkForUpper = x -> x.charAt(0) == x.toUpperCase().charAt(0);

        for (int i = 0; i < wordsList.size(); i++) {
            if (checkForUpper.test(wordsList.get(i))) {
                results.add(wordsList.get(i));
            }
        }
        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
