package _11_FunctionalProgrammingLab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _01_SortOddNumbers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.asList(scanner.nextLine().split(", "));
        List<Integer> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        numbers.removeIf(n -> n % 2 != 0); //Remove even numbers
        StringBuilder sb = new StringBuilder(); //Put manipulated numbers in sb
        for (Integer s : numbers) {
            sb.append(s);
            sb.append(", ");
        }
        sb.delete(sb.length() -2, sb.length()); //Remove the last cell who is ", "
        System.out.println(sb);

        sb = new StringBuilder();
        numbers.sort((a, b) -> a.compareTo(b)); //Sort them
        for (Integer s : numbers) {
            sb.append(s);
            sb.append(", ");
        }
        sb.delete(sb.length() -2, sb.length());
        System.out.println(sb);
    }
}
