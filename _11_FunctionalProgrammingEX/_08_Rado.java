package _11_FunctionalProgrammingEX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _08_Rado {
    public static void main(String[] args) {
        int[] numbers = getNumbers();
        int smallestElementIndex = getIndex(numbers);
        printIndex(smallestElementIndex);
    }

    private static void printIndex(int smallestElementIndex) {
        System.out.println(smallestElementIndex);
    }

    private static int getIndex(int[] numbers) {
        Function<int[], Integer> getSmallestElementIndex = nums -> {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= min) {
                    min = nums[i];
                    index = i;
                }
            }
            return index;
        };
        int index = getSmallestElementIndex.apply(numbers);
        return index;
    }

    private static int[] getNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        return numbers;
    }
}
