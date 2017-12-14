package _06_StringProcessingEX;

import java.util.Scanner;

public class _01_CountSubstringOccurrences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toLowerCase();
        String searchedWord = scanner.nextLine().toLowerCase();
        int matchCounter = 0;
        for (int i = 0; i < inputString.length() - searchedWord.length()+1; i++) {
            String currentCheck = inputString.substring(i, i + searchedWord.length());
            if (currentCheck.equals(searchedWord)){
                matchCounter++;
            }
        }
        System.out.println(matchCounter);
    }
}
