package _06_StringProcessingEX;

import java.util.Scanner;

public class _04_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            String hex = Integer.toHexString(currChar);
            String uni = String.format("\\u00%s",hex);
            System.out.print(uni);
        }
    }
}
