package _10_ManualStringProcessingLab;

import java.util.HashMap;
import java.util.Scanner;

public class _04_SpecialWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] specialWords = scanner.nextLine().split(" ");
        String[] text = scanner.nextLine().split(" ");

        HashMap<String, Integer> result = new HashMap<>();
        for (String specialWord : specialWords) {
            result.put(specialWord, 0);
        }
        for (String specialWord : specialWords) {
            for (String s : text) {
                if (specialWord.compareToIgnoreCase(s) == 0) {
                    result.put(specialWord, result.get(specialWord) + 1);
                }
            }
        }
        for (String s : result.keySet()) {
            System.out.println(s + " - " + result.get(s));
        }
    }
}
