package _02_IntroToJavaExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _09_ByteParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String numsStr = reader.readLine();
            int currNum = Integer.parseInt(numsStr);
            numbers.add(currNum);
        }

        while (true) {
            String commandString = reader.readLine();
            String[] commandArr = commandString.split("\\s+");
            if (commandString.equals("party over")) {
                for (Integer number : numbers) {
                    System.out.println(number);
                }
                return;
            }
            int action = Integer.parseInt(commandArr[0]);
            int index = Integer.parseInt(commandArr[1]);
            switch (action) {
                case -1:
                    numbers = flipAtCurrentPosition(numbers, index);
                    break;
                case 0:
                    numbers = unsetAtCurrentPosition(numbers, index);
                    break;
                case 1:
                    numbers = setAtCurrentPosition(numbers, index);
                    break;
            }
        }
    }

    private static List<Integer> setAtCurrentPosition(List<Integer> numbers, int index) {
        List<Integer> changedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            int mask = 1 << index;
            int result = number | mask;
            changedNumbers.add(result);
        }
        return changedNumbers;
    }

    private static List<Integer> unsetAtCurrentPosition(List<Integer> numbers, int index) {
        List<Integer> changedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            int mask = ~(1 << index);
            int result = number & mask;
            changedNumbers.add(result);
        }
        return changedNumbers;

    }

    private static List<Integer> flipAtCurrentPosition(List<Integer> numbers, int index) {
        List<Integer> changedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            int mask = 1 << index;
            int result = number ^ mask;
            changedNumbers.add(result);
        }
        return changedNumbers;
    }
}
