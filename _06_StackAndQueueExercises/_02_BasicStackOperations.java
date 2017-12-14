package _06_StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = commands[0];
        int s = commands[1];
        int x = commands[2];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        boolean containsX = stack.contains(x);
        if (containsX == true) {
            System.out.println("true");
            return;
        }else if(stack.size()==0){
            System.out.println(0);
            return;
        }else{
            System.out.println(FindTheSmallest(stack));
            return;
        }

    }

    private static int FindTheSmallest(Deque<Integer> stack) {
        int smallest = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if(integer<smallest){
                smallest=integer;
            }
        }
        return smallest;
    }
}
