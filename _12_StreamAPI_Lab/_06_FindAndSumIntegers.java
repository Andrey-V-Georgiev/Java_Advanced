package _12_StreamAPI_Lab;

import java.util.*;

public class _06_FindAndSumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = Arrays.asList(scanner.nextLine().split("\\s+"));

        Optional<Integer> sum = tokens.stream()
                .filter(x -> isNumber(x))
                .map(x -> Integer.valueOf(x))
                .reduce((x, y) -> x + y);

        if (sum.isPresent()) {
            System.out.println(sum.get());
        } else {
            System.out.println("No match");
        }
    }

    private static boolean isNumber(String string) {
        if (string.isEmpty()) {
            return false;
        }

        char[] characters = string.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (i == 0) {
                if (characters[i] == '-') {
                    continue;
                }
            }
            if (!Character.isDigit(characters[i])) {
                return false;
            }
        }
        return true;
    }
}
