package _06_StringProcessingEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            checkAndPrintLine(input);
            input = scanner.nextLine();
        }
    }

    private static void checkAndPrintLine(String input) {
        String regex = "(?<= |^)([a-zA-Z]+[.,-_]*[a-zA-Z0-9]*?)@([a-zA-Z-]+){1}.([a-zA-Z-]+){1}.([a-z]+){1,}(?=,|.|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String curMatch = matcher.group(0);
            System.out.println(curMatch);

        }
    }
}
