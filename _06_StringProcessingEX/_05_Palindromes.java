package _06_StringProcessingEX;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Stream.of(scanner.nextLine().split("[,.\\s\\+?!]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
        TreeSet<String> palindroms = new TreeSet<>();
        for (String word : input) {
            if (isPalindrome(word)) {
                palindroms.add(word);
            }
        }
        printPalindromes(palindroms);
    }

    private static void printPalindromes(TreeSet<String> palindroms) {
        System.out.println(String.format("[%s]", String.join(", ", palindroms)));

    }

    private static boolean isPalindrome(String word) {
        boolean isPalindrom = true;
        for (int i = 0; i < word.length() / 2; i++) {

            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                isPalindrom = false;
                break;
            }
        }
        return isPalindrom;
    }
}
