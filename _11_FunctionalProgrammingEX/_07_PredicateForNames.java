package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _07_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<String> wordsList = Stream.of(bf.readLine().split("\\s+")).collect(Collectors.toList());
        BiPredicate<Integer,String> coverRequrements = (x, y)-> x >= y.length();
        for (String word : wordsList) {
            if(coverRequrements.test(n, word)){
                System.out.println(word);
            }
        }
    }
}
