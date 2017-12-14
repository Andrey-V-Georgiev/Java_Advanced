package _12_StreamAPI_Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_TakeTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            numbers.add(Integer.valueOf(tokens[i]));
        }

        numbers.stream()
                .distinct()
                .filter(x -> 10 <= x && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
