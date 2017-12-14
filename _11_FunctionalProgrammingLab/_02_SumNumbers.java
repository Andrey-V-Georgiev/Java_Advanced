package _11_FunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.Function;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", "); //Array of Strings

        Function<String, Integer> parser = x -> Integer.parseInt(x); //Function who parse String to Integer

        int sum = 0;
        for (String s : input) {
            sum += parser.apply(s);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
