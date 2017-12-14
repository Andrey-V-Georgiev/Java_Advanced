package _06_StringProcessingEX;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _09_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            if (Pattern.matches(regex, input)) {
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}

