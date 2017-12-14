package _06_StackAndQueueExercises;

import java.util.*;

public class _01_ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            stack.push(num);
        }
        for (Integer integer : stack) {
            System.out.print(integer+" ");
        }

    }
}
