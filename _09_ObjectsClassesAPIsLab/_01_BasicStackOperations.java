package _09_ObjectsClassesAPIsLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> commands = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int pushCount = commands.get(0);
        int popCount = commands.get(1);
        int numForCheck = commands.get(2);
        List<Integer> numbers = Stream.of(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        Deque<Integer> stack = new ArrayDeque<>();
        pushInStack(stack, numbers, pushCount);
        popTheStack(stack, numbers, popCount);
        boolean isPresent = checkTheStack(stack, numForCheck);
        if (isPresent) {
            System.out.println("true");
        } else if(stack.isEmpty()){
            System.out.println(0);
            return;
        } else{
            int minNum = findMinNum(stack);
            System.out.println(minNum);
        }
    }

    private static int findMinNum(Deque<Integer> stack) {
        int minNum = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int currNum = stack.pop();
            if (currNum < minNum) {
                minNum = currNum;
            }
        }
        return minNum;
    }

    private static boolean checkTheStack(Deque<Integer> stack, int numForCheck) {
        for (int i = 0; i < stack.size(); i++) {
            int currNum = stack.pop();
            if (numForCheck == currNum) {
                return true;
            }
            stack.add(currNum);
        }
        return false;
    }

    private static void popTheStack(Deque<Integer> stack, List<Integer> numbers, int popCount) {
        for (int i = 0; i < popCount; i++) {
            stack.pop();
        }
    }

    private static void pushInStack(Deque<Integer> stack, List<Integer> numbers, int pushCount) {
        for (int i = 0; i < pushCount; i++) {
            stack.push(numbers.get(i));
        }
    }
}
