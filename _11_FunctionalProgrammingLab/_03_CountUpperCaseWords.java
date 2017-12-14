package _11_FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03_CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if(checkerUpperCase.test(input[i])){
                results.add(input[i]);
            }
        }
        System.out.println(results.size());
        for (String result : results) {
            System.out.println(result);
        }

    }
}
