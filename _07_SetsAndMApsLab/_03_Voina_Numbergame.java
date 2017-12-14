package _07_SetsAndMApsLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _03_Voina_Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = getFirstNumbers(scanner);
        LinkedHashSet<Integer> secondPlayer = getSecondNumbers(scanner);

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            } else {
                continue;
            }
        }

        if(firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else if(secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        }else if(secondPlayer == firstPlayer){
            System.out.println("Draw");
        }

    }

    private static LinkedHashSet<Integer> getFirstNumbers(Scanner scanner) {
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        int[] input = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (Integer i : input) {
            firstSet.add(i);
        }
        return firstSet;
    }

    private static LinkedHashSet<Integer> getSecondNumbers(Scanner scanner) {
        LinkedHashSet<Integer> secondtSet = new LinkedHashSet<>();
        int[] input = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (Integer i : input) {
            secondtSet.add(i);
        }
        return secondtSet;
    }
}
