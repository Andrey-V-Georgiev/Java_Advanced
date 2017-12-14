package _06_StackAndQueueExercises;

import java.util.Scanner;

public class _00_Tests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            System.out.println(input);
            input = scanner.nextLine();
        }

    }
}
