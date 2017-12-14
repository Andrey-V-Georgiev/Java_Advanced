package _11_FunctionalProgrammingEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _04_FindEvensOrOdds {

    static List<Integer> nums;
    static int lowerBorder;
    static int upperBorder;
    static String typeNumbers;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        nums = Stream.of(bf.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        lowerBorder = nums.get(0);
        upperBorder = nums.get(1);
        typeNumbers = bf.readLine();
        Predicate<Integer> isEven = x -> x % 2 == 0;
        printResults(isEven);
    }

    private static void printResults(Predicate<Integer> isEven) {

        for (int i = lowerBorder; i <= upperBorder; i++) {
            switch (typeNumbers) {
                case "odd":
                    if (!isEven.test(i)) {
                        System.out.print(i + " ");
                    }
                    break;

                case "even":
                    if (isEven.test(i)) {
                        System.out.print(i + " ");
                    }
                    break;
            }
        }
    }
}
